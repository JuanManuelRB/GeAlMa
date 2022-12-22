package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Scalar(double e0) implements Geometric3 {
    public static Scalar ZERO = new Scalar();
    public static Scalar ONE = new Scalar(1);

    public Scalar() {
        this(0);
    }

    @Override
    public @NotNull Scalar scalar() {
        return this;
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
        return Trivector3.ZERO;
    }

    @Override
    public @NotNull Scalar plus(double other) {
        return new Scalar(e0 + other);
    }

    @Override
    public @NotNull Scalar plus(Scalar other) {
        return new Scalar(this.e0 + other.e0);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Vector3 other) {
        return new Geometric3Object(this, other, bivector(), trivector());
    }

    @Override
    public @NotNull Rotor3 plus(@NotNull Bivector3 other) {
        return new Rotor3(this, other);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Trivector3 other) {
        return new Geometric3Object(this, vector(), bivector(), other);
    }

    @Override
    public @NotNull Geometric3 minus(double other) {
        return this.minus(new Scalar(other));
    }

    @Override
    public @NotNull Scalar minus(Scalar other) {
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
    public @NotNull Geometric3 minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Scalar inner(double other) {
        return new Scalar(e0 * other);
    }

    @Override
    public @NotNull Scalar inner(Scalar other) {
        return new Scalar(this.e0 * other.e0);
    }

    @Override
    public @NotNull Vector3 inner(@NotNull Vector3 other) {
        return other.inner(this);
    }

    @Override
    public @NotNull Bivector3 inner(@NotNull Bivector3 other) {
        return other.inner(this);
    }

    @Override
    public @NotNull Trivector3 inner(@NotNull Trivector3 other) {
        return other.inner(this);
    }

    @Override
    public @NotNull Scalar outer(double other) {
        return ZERO;
    }

    @Override
    public @NotNull Scalar outer(Scalar other) {
        return ZERO;
    }

    @Override
    public @NotNull Scalar outer(@NotNull Vector3 other) {
        return ZERO;
    }

    @Override
    public @NotNull Scalar outer(@NotNull Bivector3 other) {
        return ZERO;
    }

    @Override
    public @NotNull Scalar outer(@NotNull Trivector3 other) {
        return ZERO;
    }

    @Override
    public @NotNull Scalar times(double other) {
        return new Scalar(e0 * other);
    }

    @Override
    public @NotNull Scalar times(@NotNull Scalar other) {
        return new Scalar(this.e0 * other.e0);
    }

    @Override
    public @NotNull Vector3 times(@NotNull Vector3 other) {
        return new Vector3(
                other.e1() * e0,
                other.e2() * e0,
                other.e3() * e0
        );
    }

    @Override
    public @NotNull Bivector3 times(@NotNull Bivector3 other) {
        return new Bivector3(
                other.e1e2() * e0,
                other.e2e3() * e0,
                other.e3e1() * e0
        );
    }

    @Override
    public @NotNull Trivector3 times(@NotNull Trivector3 other) {
        return new Trivector3(other.e1e2e3() * e0);
    }

    @Override
    public @NotNull Scalar inverse() {
        return new Scalar(1 / e0);
    }

    @Override
    public @NotNull Scalar div(double other) {
        return new Scalar(e0 / other);
    }

    @Override
    public @NotNull Scalar div(Scalar other) {
        return new Scalar(this.e0 / other.e0);
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Vector3 other) {
        return null; // TODO
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Bivector3 other) {
        return null; // TODO
    }

    @Override
    public @NotNull Geometric3 div(@NotNull Trivector3 other) {
        return null; // TODO
    }

    @Override
    public @NotNull Scalar unaryMinus() {
        return new Scalar(-e0);
    }

    @Override
    public @NotNull Scalar unaryPlus() {
        return new Scalar(Math.abs(e0));
    }

    @Override
    public String toString() {
        return e0 + "(e0)";
    }
}
