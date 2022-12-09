package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Trivector3(double ijk) implements Geometric3 {
    public static final Trivector3 ZERO = new Trivector3(0);
    public static final Trivector3 ONE = new Trivector3(1);


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
        return Bivector3.ZERO;
    }

    @NotNull
    @Override
    public Trivector3 trivector() {
        return this;
    }

    @NotNull
    @Override
    public Trivector3 unaryMinus() {
        return new Trivector3(-this.ijk);
    }

    @NotNull
    @Override
    public Trivector3 unaryPlus() {
        return new Trivector3(Math.abs(this.ijk));
    }

    @Override
    public double magnitude() {
        return Math.sqrt(inner(this).scalar());
    }

    @NotNull
    @Override
    public Geometric3 plus(double other) {
        return new Geometric3Object(other, Vector3.ZERO, Bivector3.ZERO, this);
    }

    @NotNull
    @Override
    public Geometric3 plus(@NotNull Vector3 other) {
        return new Geometric3Object(0, other, Bivector3.ZERO, this);
    }

    @NotNull
    @Override
    public Geometric3 plus(@NotNull Bivector3 other) {
        return new Geometric3Object(0, Vector3.ZERO, other, this);
    }

    @NotNull
    @Override
    public Trivector3 plus(@NotNull Trivector3 other) {
        return new Trivector3(this.ijk + other.ijk);
    }

    @NotNull
    @Override
    public Geometric3 minus(double other) {
        return this.plus(-other);
    }

    @NotNull
    @Override
    public Geometric3 minus(@NotNull Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Geometric3 minus(@NotNull Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Trivector3 minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Trivector3 times(double other) {
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
    public Trivector3 inner(double other) {
        return new Trivector3(ijk * other);
    }

    @NotNull
    @Override
    public Bivector3 inner(@NotNull Vector3 other) {
        return new Bivector3(this.ijk * other.k(), this.ijk * other.i(), -(this.ijk * other.j()));
    }

    @NotNull
    @Override
    public Vector3 inner(@NotNull Bivector3 other) {
        return new Vector3(this.ijk * other.jk(), -(this.ijk * other.ki()), -(this.ijk * other.ij()));
    }

    @NotNull
    @Override
    public Geometric3 inner(@NotNull Trivector3 other) {
        return Geometric3Object.ZERO.plus(-(this.ijk * other.ijk));
    }

    @NotNull
    @Override
    public Geometric3 outer(double other) {
        return Geometric3Object.ZERO;
    }

    @NotNull
    @Override
    public Geometric3 outer(@NotNull Vector3 other) {
        return Geometric3Object.ZERO;
    }

    @NotNull
    @Override
    public Geometric3 outer(@NotNull Bivector3 other) {
        return Geometric3Object.ZERO;
    }

    @NotNull
    @Override
    public Geometric3 outer(@NotNull Trivector3 other) {
        return Geometric3Object.ZERO;
    }

    @Override
    public String toString() {
        return "(" + ijk + ")ijk";
    }
}
