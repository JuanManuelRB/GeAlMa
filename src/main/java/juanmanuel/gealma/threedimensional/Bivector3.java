package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Bivector3(double e1e2, double e2e3, double e3e1) implements Geometric3 {
    public static final Bivector3 ZERO = new Bivector3(0, 0, 0);
    public static final Bivector3 IJ = new Bivector3(1, 0, 0);
    public static final Bivector3 JK = new Bivector3(0, 1, 0);
    public static final Bivector3 KI = new Bivector3(0, 0, 1);
    public static final Bivector3 ONE = new Bivector3(1, 1, 1);

    public double area() {
        return magnitude();
    }

    public double magnitude() {
        return Math.sqrt(inner(this).unaryPlus().scalar());
    }

    @NotNull public Bivector3 normalized() {
        return this.div(this.magnitude());
    }

    @Override
    public double scalar() {
        return 0;
    }

    @NotNull
    @Override
    public Vector3 vector() {
        return Vector3.ZERO;
    }

    @NotNull
    @Override
    public Bivector3 bivector() {
        return this;
    }

    @NotNull
    @Override
    public Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @NotNull
    @Override
    public Bivector3 unaryMinus() {
        return new Bivector3(-this.e1e2, -this.e2e3, -this.e3e1);
    }

    @NotNull
    @Override
    public Bivector3 unaryPlus() {
        return new Bivector3(Math.abs(this.e1e2), Math.abs(this.e2e3), Math.abs(this.e3e1));
    }

    @Override
    public @NotNull Bivector3 inverse() {
        return this.div(this.magnitude() * this.magnitude());
    }

    @NotNull
    @Override
    public Rotor3 plus(double other) {
        return new Rotor3(other, this);
    }

    @NotNull
    @Override
    public Geometric3Object plus(@NotNull Vector3 other) {
        return new Geometric3Object(0, other, this, Trivector3.ZERO);
    }

    @NotNull
    @Override
    public Bivector3 plus(@NotNull Bivector3 other) {
        return new Bivector3(this.e1e2 + other.e1e2, this.e2e3 + other.e2e3, this.e3e1 + other.e3e1);
    }

    @NotNull
    @Override
    public Geometric3Object plus(@NotNull Trivector3 other) {
        return new Geometric3Object(0, Vector3.ZERO, this, other);
    }

    @NotNull
    @Override
    public Rotor3 minus(double other) {
        return this.plus(-other);
    }

    @NotNull
    @Override
    public Geometric3Object minus(@NotNull Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Bivector3 minus(@NotNull Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Geometric3Object minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Bivector3 times(double other) {
        return this.inner(other);
    }

    @NotNull
    @Override
    public Geometric3 times(@NotNull Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @NotNull
    @Override
    public Geometric3 times(@NotNull Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @NotNull
    @Override
    public Geometric3 times(@NotNull Trivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @NotNull
    @Override
    public Bivector3 inner(double other) {
        return new Bivector3(e1e2 * other, e2e3 * other, e3e1 * other);
    }

    @NotNull
    @Override
    public Trivector3 inner(@NotNull Vector3 other) {
        return new Trivector3(this.e1e2 * other.e3() + this.e2e3 * other.e1() + this.e3e1 * other.e2());
    }

    @NotNull
    @Override
    public Geometric3Object inner(@NotNull Bivector3 other) {
        return new Geometric3Object(
                -(this.e1e2 * other.e1e2 + this.e2e3 * other.e2e3 + this.e3e1 * other.e3e1),
                Vector3.ZERO,
                Bivector3.ZERO,
                Trivector3.ZERO
        );
    }

    @NotNull
    @Override
    public Vector3 inner(@NotNull Trivector3 other) {
        return new Vector3(this.e2e3 * other.e1e2e3(), -(this.e3e1 * other.e1e2e3()), -(this.e1e2 * other.e1e2e3()));
    }

    @NotNull
    @Override
    public Geometric3Object outer(double other) {
        return Geometric3Object.ZERO;
    }

    @NotNull
    @Override
    public Vector3 outer(@NotNull Vector3 other) {
        return new Vector3(
                this.e1e2 * other.e2() - this.e3e1 * other.e3(),
                this.e2e3 * other.e3() - this.e1e2 * other.e1(),
                this.e3e1 * other.e1() - this.e2e3 * other.e2()
        );
    }

    @NotNull
    @Override
    public Bivector3 outer(@NotNull Bivector3 other) {
        return new Bivector3(
                this.e3e1 * other.e2e3 - this.e2e3 * other.e3e1,
                this.e1e2 * other.e3e1 - this.e3e1 * other.e1e2,
                this.e2e3 * other.e1e2 - this.e1e2 * other.e2e3
        );
    }

    @NotNull
    @Override
    public Geometric3Object outer(@NotNull Trivector3 other) {
        return Geometric3Object.ZERO;
    }

    @Override
    public @NotNull Bivector3 div(double other) {
        return new Bivector3(e1e2 / other, e2e3 / other, e3e1 / other);
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
    public @NotNull Geometric3 div(@NotNull Trivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public String toString() {
//        var str = "";
//        if (e1e2 != 0)
//            str += e1e2 + "(e1e2)";
//
//        if (e2e3 != 0) {
//            if (e1e2 != 0)
//                str += " + ";
//            str += e2e3 + "(e2e3)";
//        }
//
//        if (e3e1 != 0) {
//            if (e2e3 != 0)
//                str += " + ";
//            str += e3e1 + "(e3e1)";
//        }
//        return str;
        return e1e2 + "(e1e2) + " + e2e3 + "(e2e3) + " + e3e1 + "(e3e1)";
    }

    @NotNull
    public Bivector3 bivectorIJ() {
        return new Bivector3(e1e2, 0, 0);
    }

    @NotNull
    public Bivector3 bivectorJK() {
        return new Bivector3(e1e2, 0, 0);
    }

    @NotNull
    public Bivector3 bivectorKI() {
        return new Bivector3(e1e2, 0, 0);
    }
}
