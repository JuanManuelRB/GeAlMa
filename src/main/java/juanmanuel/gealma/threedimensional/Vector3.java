package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Vector3(double e1, double e2, double e3) implements Geometric3 {
    public static final Vector3 ZERO = new Vector3();
    public static final Vector3 ONE = new Vector3(1, 1, 1);

    public Vector3() {
        this(0, 0, 0);
    }

//    public static Vector3 sum(Vector3... vectors) {
//        var vec = Vector3.ZERO;
//        for (var vecs : vectors) {
//            vec = vec.plus(vecs).vector();
//        }
//        return vec.vector();
//    } TODO?

//    public static Geometric3 product(Vector3... vectors) {
//        Geometric3 vec = Vector3.ONE;
//        for (var vecs : vectors) {
//            vec = vec.times(vecs);
//        }
//        return vec;
//    } TODO

    @Override
    public @NotNull Scalar scalar() {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Vector3 vector() {
        return this;
    }

    @Override
    public @NotNull Bivector3 bivector() {
        return Bivector3.ZERO;
    }

    @Override
    public @NotNull Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @Override
    public @NotNull Vector3 unaryMinus() {
        return new Vector3(-e1, -e2, -e3);
    }

    @Override
    public @NotNull Vector3 unaryPlus() {
        return new Vector3(Math.abs(e1), Math.abs(e2), Math.abs(e3));
    }

    @Override
    public @NotNull Vector3 normalized() {
        return this.div(this.magnitude());
    }

    // Addition

    @Override
    public @NotNull Geometric3 plus(double other) {
        return new Geometric3Object(other, this, bivector(), trivector());
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Scalar other) {
        return new Geometric3Object(other, this, bivector(), trivector());
    }

    @Override
    public @NotNull Vector3 plus(@NotNull Vector3 other) {
        return new Vector3(this.e1 + other.e1, this.e2 + other.e2, this.e3 + other.e3);
    }

    // Subtraction

    @Override
    public @NotNull Geometric3 plus(@NotNull Bivector3 other) {
        return new Geometric3Object(0, this, other, Trivector3.ZERO);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Rotor3 other) {
        return new Geometric3Object(other.scalar(), this, other.bivector(), trivector());
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Trivector3 other) {
        return new Geometric3Object(0, this, Bivector3.ZERO, other);
    }

    @Override
    public @NotNull Geometric3 minus(double other) {
        return this.plus(-other);
    }
    @Override
    public @NotNull Geometric3 minus(Scalar other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Vector3 minus(@NotNull Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Geometric3 minus(@NotNull Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Geometric3 minus(@NotNull Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Geometric3 minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }



    @Override
    public @NotNull Vector3 inner(double other) {
        return new Vector3(e1 * other, e2 * other, e3 * other);
    }

    @Override
    public @NotNull Vector3 inner(Scalar other) {
        return new Vector3(e1 * other.e0(), e2 * other.e0(), e3 * other.e0());
    }

    @Override
    public @NotNull Scalar inner(@NotNull Vector3 other) {
        return new Scalar(this.e1 * other.e1 + this.e2 * other.e2 + this.e3 * other.e3);
    }

    @Override
    public @NotNull Vector3 inner(@NotNull Bivector3 other) {
        return new Vector3(
                this.e3 * other.e3e1() - this.e2 * other.e1e2(),
                this.e1 * other.e1e2() - this.e3 * other.e2e3(),
                this.e2 * other.e2e3() - this.e1 * other.e3e1()
        );
    }

    @Override
    public @NotNull Vector3 inner(@NotNull Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @NotNull @Override
    public Bivector3 inner(@NotNull Trivector3 other) {
        return new Bivector3(
                this.e1 * other.e1e2e3(),
                this.e2 * other.e1e2e3(),
                this.e3 * other.e1e2e3()
        );
    }

    @Override
    public @NotNull Scalar outer(double other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Scalar outer(Scalar other) {
        return Scalar.ZERO;
    }

    @NotNull @Override
    public Bivector3 outer(@NotNull Vector3 other) {
        return new Bivector3(
                this.e1 * other.e2 - other.e1 * this.e2,
                this.e2 * other.e3 - other.e2 * this.e3,
                this.e3 * other.e1 - other.e3 * this.e1
        );
    }

    @NotNull @Override
    public Trivector3 outer(@NotNull Bivector3 other) {
        return new Trivector3(this.e1 * other.e2e3() + this.e2 * other.e3e1() + this.e3 * other.e1e2());
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    @NotNull @Override
    public Geometric3 outer(@NotNull Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Vector3 times(double other) {
        return new Vector3(e1 * other, e2 * other, e3 * other);
    }

    @Override
    public @NotNull Vector3 times(@NotNull Scalar other) {
        return new Vector3(e1 * other.e0(), e2 * other.e0(), e3 * other.e0());
    }

    @Override
    public @NotNull Rotor3 times(@NotNull Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Bivector3 times(@NotNull Trivector3 other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Vector3 inverse() {
        return this.div(this.magnitude() * this.magnitude());
    }

    @Override
    public @NotNull Vector3 div(double other) {
        return new Vector3(e1 / other, e2 / other, e3 / other);
    }

    @Override
    public @NotNull Vector3 div(Scalar other) {
        return new Vector3(this.e1 / other.e0(), this.e2 / other.e0(), this.e3 / other.e0());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Vector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Bivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Rotor3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Trivector3 other) {
        return this.times(other.inverse());
    }

    public Vector3 reflectOver(Vector3 other) {
        return other.inverse().times(this).times(other).vector();
    }

    public Vector3 rotated(Rotor3 rotor) {
        return rotor.rotate(this);
    }

    public Vector3 rotated(double angle, Bivector3 plane) {
        return Rotor3.fromPlain(angle, plane).rotate(this);
    }

    @Override
    public double magnitude() {
        return Math.sqrt(inner(this).e0());
    }

    public double length() {
        return magnitude();
    }

    public Vector3 projection(Vector3 other) {
        return other.inverse().times(inner(other));
    }

    public Vector3 rejection(Vector3 other) {
        return this.minus(projection(other));
    }

    @Override
    public String toString() {
        return "Vector: " + e1 + "(e1) + " + e2 + "(e2) + " + e3 + "(e3)";
    }
}
