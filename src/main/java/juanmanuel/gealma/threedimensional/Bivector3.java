package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Bivector3(double e1e2, double e2e3, double e3e1) implements Geometric3 {
    public static final Bivector3 ZERO = new Bivector3();
    public static final Bivector3 IJ = new Bivector3(1, 0, 0);
    public static final Bivector3 JK = new Bivector3(0, 1, 0);
    public static final Bivector3 KI = new Bivector3(0, 0, 1);
    public static final Bivector3 ONE = new Bivector3(1, 1, 1);

    public Bivector3() {
        this(0, 0, 0);
    }

    public double area() {
        return magnitude();
    }

    @Override
    public double magnitude() {
        return Math.sqrt(inner(this).unaryPlus().e0());
    }

    @Override
    public @NotNull Bivector3 normalized() {
        return this.div(this.magnitude());
    }

    @Override
    public @NotNull Scalar scalar() {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Vector3 vector() {
        return Vector3.ZERO;
    }

    @Override
    public @NotNull Bivector3 bivector() {
        return this;
    }

    @Override
    public @NotNull Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @Override
    public @NotNull Bivector3 unaryMinus() {
        return new Bivector3(-e1e2, -e2e3, -e3e1);
    }

    @Override
    public @NotNull Bivector3 unaryPlus() {
        return new Bivector3(Math.abs(this.e1e2), Math.abs(this.e2e3), Math.abs(this.e3e1));
    }

    @Override
    public @NotNull Bivector3 inverse() {
        return this.div(this.magnitude() * this.magnitude());
    }

    @Override
    public @NotNull Rotor3 plus(double other) {
        return new Rotor3(other, this);
    }

    @Override
    public @NotNull Rotor3 plus(@NotNull Scalar other) {
        return new Rotor3(other, this);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), other, this, trivector());
    }

    @Override
    public @NotNull Bivector3 plus(@NotNull Bivector3 other) {
        return new Bivector3(this.e1e2 + other.e1e2, this.e2e3 + other.e2e3, this.e3e1 + other.e3e1);
    }

    @Override
    public @NotNull Rotor3 plus(@NotNull Rotor3 other) {
        return new Rotor3(other.scalar(), this.plus(other.bivector()));
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Trivector3 other) {
        return new Geometric3Object(scalar(), vector(), this, other);
    }

    @Override
    public @NotNull Rotor3 minus(double other) {
        return this.plus(-other);
    }

    @Override
    public @NotNull Geometric3 minus(@NotNull Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Bivector3 minus(@NotNull Bivector3 other) {
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
    public @NotNull Bivector3 inner(double other) {
        return new Bivector3(e1e2 * other, e2e3 * other, e3e1 * other);
    }

    @Override
    public @NotNull Bivector3 inner(Scalar other) {
        return new Bivector3(this.e1e2 * other.e0(), this.e2e3 * other.e0(), this.e3e1 * other.e0());
    }

    @Override
    public @NotNull Trivector3 inner(@NotNull Vector3 other) {
        return new Trivector3(this.e1e2 * other.e3() + this.e2e3 * other.e1() + this.e3e1 * other.e2());
    }

    @Override
    public @NotNull Scalar inner(@NotNull Bivector3 other) {
        return new Scalar(-(this.e1e2 * other.e1e2 + this.e2e3 * other.e2e3 + this.e3e1 * other.e3e1));
    }

    @Override
    public @NotNull Rotor3 inner(@NotNull Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public @NotNull Vector3 inner(@NotNull Trivector3 other) {
        return new Vector3(this.e2e3 * other.e1e2e3(), -(this.e3e1 * other.e1e2e3()), -(this.e1e2 * other.e1e2e3()));
    }

    @Override
    public @NotNull Scalar outer(double other) {
        return scalar();
    }

    @Override
    public @NotNull Scalar outer(Scalar other) {
        return scalar();
    }

    @Override
    public @NotNull Vector3 outer(@NotNull Vector3 other) {
        return new Vector3(
                this.e1e2 * other.e2() - this.e3e1 * other.e3(),
                this.e2e3 * other.e3() - this.e1e2 * other.e1(),
                this.e3e1 * other.e1() - this.e2e3 * other.e2()
        );
    }

    @Override
    public @NotNull Bivector3 outer(@NotNull Bivector3 other) {
        return new Bivector3(
                this.e3e1 * other.e2e3 - this.e2e3 * other.e3e1,
                this.e1e2 * other.e3e1 - this.e3e1 * other.e1e2,
                this.e2e3 * other.e1e2 - this.e1e2 * other.e2e3
        );
    }

    @Override
    public @NotNull Rotor3 outer(@NotNull Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    @NotNull
    @Override
    public Scalar outer(@NotNull Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Bivector3 times(double other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Bivector3 times(Scalar other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Rotor3 times(@NotNull Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Rotor3 times(@NotNull Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Vector3 times(@NotNull Trivector3 other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Bivector3 div(double other) {
        return new Bivector3(e1e2 / other, e2e3 / other, e3e1 / other);
    }

    @Override
    public @NotNull Bivector3 div(Scalar other) {
        return new Bivector3(this.e1e2 / other.e0(), this.e2e3 / other.e0(), this.e3e1 / other.e0());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Vector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Rotor3 div(@NotNull Bivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Rotor3 div(@NotNull Rotor3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Trivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public String toString() {
        return "Bivector: " + e1e2 + "(e1e2) + " + e2e3 + "(e2e3) + " + e3e1 + "(e3e1)";
    }
}
