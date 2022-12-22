package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Trivector3(double e1e2e3) implements Geometric3 {
    public static final Trivector3 ZERO = new Trivector3();
    public static final Trivector3 ONE = new Trivector3(1);

    public Trivector3() {
        this(0);
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
        return Bivector3.ZERO;
    }

    @Override
    public @NotNull Trivector3 trivector() {
        return this;
    }

    @Override
    public @NotNull Trivector3 unaryMinus() {
        return new Trivector3(-this.e1e2e3);
    }

    @Override
    public @NotNull Trivector3 unaryPlus() {
        return new Trivector3(Math.abs(this.e1e2e3));
    }

    @Override
    public double magnitude() {
        return e1e2e3;
    }

    public @NotNull Trivector3 normalized() {
        return Trivector3.ONE;
    }

    @Override
    public @NotNull Trivector3 inverse() {
        return this.unaryMinus();
    }

    @Override
    public @NotNull Geometric3 plus(double other) {
        return new Geometric3Object(other, vector(), bivector(), this);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Scalar other) {
        return new Geometric3Object(other, vector(), bivector(), this);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), other, bivector(), this);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Bivector3 other) {
        return new Geometric3Object(scalar(), vector(), other, this);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Rotor3 other) {
        return new Geometric3Object(other.scalar(), vector(), other.bivector(), this);
    }

    @Override
    public @NotNull Trivector3 plus(@NotNull Trivector3 other) {
        return new Trivector3(this.e1e2e3 + other.e1e2e3);
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
    public @NotNull Geometric3 minus(@NotNull Vector3 other) {
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
    public @NotNull Trivector3 minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Trivector3 inner(double other) {
        return new Trivector3(e1e2e3 * other);
    }

    @Override
    public @NotNull Trivector3 inner(Scalar other) {
        return new Trivector3(this.e1e2e3 * other.e0());
    }

    @NotNull
    @Override
    public Bivector3 inner(@NotNull Vector3 other) {
        return new Bivector3(this.e1e2e3 * other.e3(), this.e1e2e3 * other.e1(), -(this.e1e2e3 * other.e2()));
    }

    @NotNull
    @Override
    public Vector3 inner(@NotNull Bivector3 other) {
        return new Vector3(this.e1e2e3 * other.e2e3(), -(this.e1e2e3 * other.e3e1()), -(this.e1e2e3 * other.e1e2()));
    }

    @Override
    public @NotNull Geometric3 inner(@NotNull Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public @NotNull Scalar inner(@NotNull Trivector3 other) {
        return new Scalar(-(this.e1e2e3 * other.e1e2e3));
    }

    @Override
    public @NotNull Scalar outer(double other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Scalar outer(Scalar other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Scalar outer(@NotNull Vector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Scalar outer(@NotNull Bivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    @NotNull
    @Override
    public Geometric3 outer(@NotNull Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public @NotNull Trivector3 times(double other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Trivector3 times(Scalar other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Bivector3 times(@NotNull Vector3 other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Vector3 times(@NotNull Bivector3 other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public @NotNull Scalar times(@NotNull Trivector3 other) {
        return this.inner(other);
    }

    @Override
    public @NotNull Trivector3 div(double other) {
        return new Trivector3(e1e2e3 / other);
    }

    @Override
    public @NotNull Trivector3 div(Scalar other) {
        return new Trivector3(this.e1e2e3 / other.e0());
    }

    @Override
    public @NotNull Bivector3 div(@NotNull Vector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Vector3 div(@NotNull Bivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Rotor3 other) {
        return this.times(other.inverse());
    }

    @Override
    public @NotNull Scalar div(@NotNull Trivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public String toString() {
        return  "Trivector: " + e1e2e3 + "(e1e2e3)";
    }
}
