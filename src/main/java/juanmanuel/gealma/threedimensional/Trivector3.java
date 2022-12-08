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
    public Geometric3 plus(double other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 plus(@NotNull Vector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 plus(@NotNull Bivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Trivector3 plus(@NotNull Trivector3 other) {
        return new Trivector3(this.ijk + other.ijk);
    }

    @NotNull
    @Override
    public Geometric3 minus(double other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 minus(@NotNull Vector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 minus(@NotNull Bivector3 other) {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 minus(@NotNull Trivector3 other) {
        return null;
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
    public Geometric3 unaryMinus() {
        return null;
    }

    @NotNull
    @Override
    public Geometric3 unaryPlus() {
        return null;
    }

    @Override
    public double magnitude() {
        return 0;
    }
}
