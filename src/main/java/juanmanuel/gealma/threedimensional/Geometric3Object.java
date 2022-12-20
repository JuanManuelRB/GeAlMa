package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

public record Geometric3Object(double scalar, @NotNull Vector3 vector, @NotNull Bivector3 bivector, @NotNull Trivector3 trivector) implements Geometric3 {
    public static final Geometric3Object ZERO = new Geometric3Object(0, Vector3.ZERO, Bivector3.ZERO, Trivector3.ZERO);

    @Override
    public @NotNull Geometric3 unaryMinus() {
        return new Geometric3Object(-scalar, vector.unaryMinus(), bivector.unaryMinus(), trivector.unaryMinus());
    }

    @Override
    public @NotNull Geometric3 unaryPlus() {
        return new Geometric3Object(Math.abs(scalar), vector.unaryPlus(), bivector.unaryPlus(), trivector.unaryPlus());
    }

    @Override
    public @NotNull Geometric3 inverse() {
//        return Geometric3Object.ZERO.plus(1).div(this);
        return null;
    }

    @Override
    public @NotNull Geometric3 plus(double other) {
        return new Geometric3Object(scalar + other, vector, bivector, trivector);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Vector3 other) {
        return new Geometric3Object(scalar, vector().plus(other), bivector, trivector);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Bivector3 other) {
        return new Geometric3Object(scalar, vector, bivector.plus(other), trivector);
    }

    @Override
    public @NotNull Geometric3 plus(@NotNull Trivector3 other) {
        return new Geometric3Object(scalar, vector, bivector, trivector.plus(other));
    }

    @Override
    public @NotNull Geometric3 minus(double other) {
        return this.plus(-other);
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
    public @NotNull Geometric3 times(@NotNull Vector3 other) {
        return other.times(scalar).plus(vector.times(other)).plus(bivector.times(other)).plus(trivector.times(other));
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Bivector3 other) {
        return other.times(scalar).plus(vector.times(other)).plus(bivector.times(other)).plus(trivector.times(other));
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Trivector3 other) {
        return other.times(scalar).plus(vector.times(other)).plus(bivector.times(other)).plus(trivector.times(other));
    }

    @Override
    @NotNull
    public Geometric3 inner(double other) {
        return vector.inner(other).plus(bivector.inner(other)).plus(trivector.inner(other)).plus(scalar * other);
    }

    @Override
    public @NotNull Geometric3 inner(@NotNull Vector3 other) {
        return other.inner(scalar).plus(vector.inner(other)).plus(bivector.inner(other)).plus(trivector.inner(other));
    }

    @Override
    public @NotNull Geometric3 inner(@NotNull Bivector3 other) {
        return other.inner(scalar).plus(vector.inner(other)).plus(bivector.inner(other)).plus(trivector.inner(other));
    }

    @Override
    public @NotNull Geometric3 inner(@NotNull Trivector3 other) {
        return other.inner(scalar).plus(vector.inner(other)).plus(bivector.inner(other)).plus(trivector.inner(other));
    }

    @Override
    @NotNull
    public Geometric3 outer(double other) {
        return vector.outer(other).plus(bivector.outer(other)).plus(trivector.outer(other)).plus(0);
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Vector3 other) {
        return other.outer(scalar).plus(vector.outer(other)).plus(bivector.outer(other)).plus(trivector.outer(other));
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Bivector3 other) {
        return other.outer(scalar).plus(vector.outer(other)).plus(bivector.outer(other)).plus(trivector.outer(other));
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Trivector3 other) {
        return other.outer(scalar).plus(vector.outer(other)).plus(bivector.outer(other)).plus(trivector.outer(other));
    }

    @Override
    public Geometric3 div(double other) {
        return new Geometric3Object(
                this.scalar / other,
                this.vector.div(other),
                this.bivector.div(other),
                this.trivector.div(other)
                );
    }

    @Override
    public Geometric3 div(@NotNull Vector3 other) {
//        return other.inverse().times(other).plus(this.vector.div(other)).plus(this.bivector.div(other)).plus(this.trivector.div(other));
        return null;
    }

    @Override
    public Geometric3 div(@NotNull Bivector3 other) {
//        return other.inverse().times(other).plus(this.vector.div(other)).plus(this.bivector.div(other)).plus(this.trivector.div(other));
        return null;
    }

    @Override
    public Geometric3 div(@NotNull Trivector3 other) {
//        return other.inverse().times(other).plus(this.vector.div(other)).plus(this.bivector.div(other)).plus(this.trivector.div(other));
        return null;
    }

    @Override
    public String toString() {
        return "" + scalar + " + " + vector + " + " + bivector + " + " + trivector;
    }
}
