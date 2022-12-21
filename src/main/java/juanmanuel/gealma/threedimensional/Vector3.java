package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Vector3(double e1, double e2, double e3) implements Geometric3 {
    public static final Vector3 ZERO = new Vector3(0, 0, 0);
    public static final Vector3 ONE = new Vector3(1, 1, 1);
//    public static final Vector3 I = Vector3.ONE.vectorI();
//    public static final Vector3 J = Vector3.ONE.vectorJ();
//    public static final Vector3 K = Vector3.ONE.vectorK();

    public Vector3 vectorI() {
        return new Vector3(e1, 0, 0);
    }

    public Vector3 vectorJ() {
        return new Vector3(0, e2, 0);
    }

    public Vector3 vectorK() {
        return new Vector3(0, 0, e3);
    }

    public double magnitude() {
        return Math.sqrt(inner(this).scalar());
    }

    public double length() {
        return magnitude();
    }

    public Vector3 projection(Vector3 other) {
        return other.inverse().times(inner(other).scalar());
    }

    public Vector3 rejection(Vector3 other) {
        return this.minus(projection(other));
    }

    public static Vector3 sum(Vector3... vectors) {
        var vec = Vector3.ZERO;
        for (var vecs : vectors) {
            vec = vec.plus(vecs).vector();
        }
        return vec.vector();
    }

//    public static Geometric3 product(Vector3... vectors) {
//        Geometric3 vec = Vector3.ONE;
//        for (var vecs : vectors) {
//            vec = vec.times(vecs);
//        }
//        return vec;
//    }

    @NotNull
    public Vector3 normalized() {
        return this.div(this.magnitude());
    }

    // Geometric Primitives

    @Override
    public double scalar() {
        return 0;
    }

    @NotNull @Override
    public Vector3 unaryMinus() {
        return new Vector3(-e1, -e2, -e3);
    }

    @NotNull @Override
    public Vector3 unaryPlus() {
        return new Vector3(Math.abs(e1), Math.abs(e2), Math.abs(e3));
    }

    @NotNull @Override
    public Vector3 vector() {
        return this;
    }

    // Addition

    @NotNull @Override
    public Bivector3 bivector() {
        return Bivector3.ZERO;
    }

    @NotNull @Override
    public Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @NotNull @Override
    public Geometric3Object plus(double other) {
        return new Geometric3Object(other, this, Bivector3.ZERO, Trivector3.ZERO);
    }

    @NotNull @Override
    public Vector3 plus(@NotNull Vector3 other) {
        return new Vector3(this.e1 + other.e1, this.e2 + other.e2, this.e3 + other.e3);
    }

    // Subtraction

    @NotNull @Override
    public Geometric3Object plus(@NotNull Bivector3 other) {
        return new Geometric3Object(0, this, other, Trivector3.ZERO);
    }

    @NotNull @Override
    public Geometric3Object plus(@NotNull Trivector3 other) {
        return new Geometric3Object(0, this, Bivector3.ZERO, other);
    }

    @NotNull
    @Override
    public Geometric3Object minus(@NotNull Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull @Override
    public Geometric3Object minus(double other) {
        return this.plus(-other);
    }

    @NotNull @Override
    public Vector3 minus(@NotNull Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull @Override
    public Geometric3Object minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull @Override
    public Vector3 times(double other) {
        return this.inner(other);
    }

    @NotNull @Override
    public Geometric3 times(@NotNull Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @NotNull @Override
    public Geometric3Object times(@NotNull Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Geometric3Object times(@NotNull Trivector3 other) {
        return (Geometric3Object) this.inner(other).plus(this.outer(other));
    }

    @NotNull @Override
    public Vector3 inner(double other) {
        return new Vector3(e1 * other, e2 * other, e3 * other);
    }

    @NotNull @Override
    public Geometric3Object inner(@NotNull Vector3 other) {
        return new Geometric3Object(
                this.e1 * other.e1 + this.e2 * other.e2 + this.e3 * other.e3,
                Vector3.ZERO,
                Bivector3.ZERO,
                Trivector3.ZERO
        );
    }

    @NotNull @Override
    public Vector3 inner(@NotNull Bivector3 other) {
        //TODO: Vector computation?
        return new Vector3(
                this.e3 * other.e3e1() - this.e2 * other.e1e2(),
                this.e1 * other.e1e2() - this.e3 * other.e2e3(),
                this.e2 * other.e2e3() - this.e1 * other.e3e1()
        );
    }

    @NotNull @Override
    public Bivector3 inner(@NotNull Trivector3 other) {
        //TODO: Vector computation?
        return new Bivector3(
                this.e1 * other.e1e2e3(),
                this.e2 * other.e1e2e3(),
                this.e3 * other.e1e2e3()
        );
    }

    @NotNull @Override
    public Geometric3Object outer(double other) {
        return Geometric3Object.ZERO;
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
    public Vector3 div(double other) {
        return new Vector3(e1 / other, e2 / other, e3 / other);
    }

    @NotNull @Override
    public Geometric3 div(@NotNull Vector3 other) {
        return this.times(other.inverse());
    }

    @NotNull @Override
    public Geometric3Object div(@NotNull Bivector3 other) {
        return this.times(other.inverse());
    }

    @NotNull @Override
    public Geometric3Object div(@NotNull Trivector3 other) {
        return this.times(other.inverse());
    }

    @NotNull @Override
    public Vector3 inverse() {
        return this.div(this.magnitude() * this.magnitude());
    }

    @NotNull @Override
    public Trivector3 outer(@NotNull Bivector3 other) {
        return new Trivector3(this.e1 * other.e2e3() + this.e2 * other.e3e1() + this.e3 * other.e1e2());
    }

    @NotNull @Override
    public Geometric3Object outer(@NotNull Trivector3 other) {
        return Geometric3Object.ZERO;
    }

    public Vector3 reflectOver(Vector3 other) {
        return other.inverse().times(this).times(other).vector();
    }

    public Vector3 rotated(Rotor3 rotor) {
        return rotor.rotate(this);
    }

    public Vector3 rotated(double angle, Bivector3 plane) {
        return new Rotor3(angle, plane).rotate(this);
    }

    @Override
    public String toString() {
//        var str = "";
//        if (e1 != 0)
//            str += e1 + "(e1)";
//
//        if (e2 != 0){
//            if (e1 != 0)
//                str += " + ";
//            str += e2 + "(e2)";
//        }
//
//        if (e3 != 0) {
//            if (e2 != 0)
//                str += " + ";
//            str += e3 + "(e3)";
//        }
//        return str;

        return e1 + "(e1) + " + e2 + "(e2) + " + e3 + "(e3)";
    }
}
