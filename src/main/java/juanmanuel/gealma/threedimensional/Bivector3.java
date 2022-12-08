package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Bivector3(double ij, double jk, double ki) implements Geometric3 {
    public static final Bivector3 ZERO = new Bivector3(0, 0, 0);
    public static final Bivector3 IJ = new Bivector3(1, 0, 0);
    public static final Bivector3 JK = new Bivector3(0, 1, 0);
    public static final Bivector3 KI = new Bivector3(0, 0, 1);
    public static final Bivector3 ONE = new Bivector3(1, 1, 1);


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
    public Geometric3 plus(double other) {
        return new Geometric3Object(other, Vector3.ZERO, this, Trivector3.ZERO);
    }

    @NotNull
    @Override
    public Geometric3 plus(@NotNull Vector3 other) {
        return new Geometric3Object(0, other, this, Trivector3.ZERO);
    }

    @NotNull
    @Override
    public Bivector3 plus(@NotNull Bivector3 other) {
        return new Bivector3(this.ij + other.ij, this.jk + other.jk, this.ki + other.ki);
    }

    @NotNull
    @Override
    public Geometric3 plus(@NotNull Trivector3 other) {
        return new Geometric3Object(0, Vector3.ZERO, this, other);
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
    public Bivector3 minus(@NotNull Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Geometric3 minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @NotNull
    @Override
    public Geometric3 times(double other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 times(@NotNull Vector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 times(@NotNull Bivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 times(@NotNull Trivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 inner(@NotNull Vector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 inner(@NotNull Bivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 inner(@NotNull Trivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 outer(@NotNull Vector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 outer(@NotNull Bivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 outer(@NotNull Trivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Bivector3 unaryMinus() {
        return null;
    }

    @NotNull
    @Override
    public Bivector3 unaryPlus() {
        return null;
    }

    @Override
    public double magnitude() {
        return 0;
    }
}
