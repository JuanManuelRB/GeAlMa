package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Bivector3(double ij, double jk, double ki) implements Geometric3 {
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
        return new Bivector3(-this.ij, -this.jk, -this.ki);
    }

    @NotNull
    @Override
    public Bivector3 unaryPlus() {
        return new Bivector3(Math.abs(this.ij), Math.abs(this.jk), Math.abs(this.ki));
    }

    @Override
    public @NotNull Bivector3 inverse() {
        return this.div(this.magnitude() * this.magnitude());
    }

    @NotNull
    @Override
    public Geometric3Object plus(double other) {
        return new Geometric3Object(other, Vector3.ZERO, this, Trivector3.ZERO);
    }

    @NotNull
    @Override
    public Geometric3Object plus(@NotNull Vector3 other) {
        return new Geometric3Object(0, other, this, Trivector3.ZERO);
    }

    @NotNull
    @Override
    public Bivector3 plus(@NotNull Bivector3 other) {
        return new Bivector3(this.ij + other.ij, this.jk + other.jk, this.ki + other.ki);
    }

    @NotNull
    @Override
    public Geometric3Object plus(@NotNull Trivector3 other) {
        return new Geometric3Object(0, Vector3.ZERO, this, other);
    }

    @NotNull
    @Override
    public Geometric3Object minus(double other) {
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
        return new Bivector3(ij * other, jk * other, ki * other);
    }

    @NotNull
    @Override
    public Trivector3 inner(@NotNull Vector3 other) {
        return new Trivector3(this.ij * other.k() + this.jk * other.i() + this.ki * other.j());
    }

    @NotNull
    @Override
    public Geometric3Object inner(@NotNull Bivector3 other) {
        return new Geometric3Object(
                -(this.ij * other.ij + this.jk * other.jk + this.ki * other.ki),
                Vector3.ZERO,
                Bivector3.ZERO,
                Trivector3.ZERO
        );
    }

    @NotNull
    @Override
    public Vector3 inner(@NotNull Trivector3 other) {
        return new Vector3(this.jk * other.ijk(), -(this.ki * other.ijk()), -(this.ij * other.ijk()));
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
                this.ij * other.j() - this.ki * other.k(),
                this.jk * other.k() - this.ij * other.i(),
                this.ki * other.i() - this.jk * other.j()
        );
    }

    @NotNull
    @Override
    public Bivector3 outer(@NotNull Bivector3 other) {
        return new Bivector3(
                this.ki * other.jk - this.jk * other.ki,
                this.ij * other.ki - this.ki * other.ij,
                this.jk * other.ij - this.ij * other.jk
        );
    }

    @NotNull
    @Override
    public Geometric3Object outer(@NotNull Trivector3 other) {
        return Geometric3Object.ZERO;
    }

    @Override
    public @NotNull Bivector3 div(double other) {
        return new Bivector3(ij / other, jk / other, ki / other);
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
//        if (ij != 0)
//            str += ij + "(ij)";
//
//        if (jk != 0) {
//            if (ij != 0)
//                str += " + ";
//            str += jk + "(jk)";
//        }
//
//        if (ki != 0) {
//            if (jk != 0)
//                str += " + ";
//            str += ki + "(ki)";
//        }
//        return str;
        return ij + "(ij) + " + jk + "(jk) + " + ki + "(ki)";
    }

    @NotNull
    public Bivector3 bivectorIJ() {
        return new Bivector3(ij, 0, 0);
    }

    @NotNull
    public Bivector3 bivectorJK() {
        return new Bivector3(ij, 0, 0);
    }

    @NotNull
    public Bivector3 bivectorKI() {
        return new Bivector3(ij, 0, 0);
    }
}
