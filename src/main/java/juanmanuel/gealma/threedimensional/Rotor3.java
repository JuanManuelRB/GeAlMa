package juanmanuel.gealma.threedimensional;

import org.jetbrains.annotations.NotNull;

/**
 * The scalar parameter can have any real value, including negative values. It represents the amount of rotation in
 * the rotor.
 *
 * The bivector parameter can have any value that is a valid bivector in geometric algebra. A bivector is a multivector
 * with a grade (or number of dimensions) of 2. It can be expressed as a linear combination of the basis bivectors of
 * the algebra, which satisfy the following conditions:
 *
 * The bivectors are orthogonal to the scalar unit (e1.e., the unit with a grade of 0).
 * The bivectors are orthogonal to each other.
 * The bivectors square to the negative of the scalar unit.
 * For example, in 3-dimensional Euclidean space, the basis bivectors are e2e3, e3e1, and e1e2, where e1, e2, and e3 are
 * the basis vectors of the space.
 *
 * It's important to note that the bivector parameter should not be confused with the vector parameter, which represents
 * a multivector with a grade of 1. A vector is a linear combination of the basis vectors of the algebra, and it is
 * orthogonal to the scalar unit, but it is not orthogonal to the bivectors.
 *
 * @param scalar
 * @param e1e2
 * @param e2e3
 * @param e3e1
 *
 */
public record Rotor3(double scalar, double e1e2, double e2e3, double e3e1) implements Geometric3 {
    public Rotor3(double scalar, Bivector3 bivector) {
        this(scalar, bivector.e1e2(), bivector.e2e3(), bivector.e3e1());
    }

    /**
     * Takes two vectors and creates a rotor that will rotate twice the angle between the two vectors.
     *
     * @param from the vector from which the angle starts.
     * @param to the vector to which the angle ends.
     */
    public Rotor3(Vector3 from, Vector3 to) {
        this(Math.acos(from.inner(to).scalar()), from.outer(to));
    }

    public static Rotor3 fromAnglePlain(double angle, Bivector3 bivector3) {
        var halfAngle = angle /2;
        return new Rotor3(Math.cos(halfAngle), bivector3.normalized().times(Math.sin(halfAngle)));
    }

    public @NotNull Rotor3 reverse() {
        return new Rotor3(scalar, -e1e2, -e2e3, -e3e1);
    }

    public double magnitude() {
        return Math.sqrt((scalar * scalar) + (e1e2 * e1e2) + (e2e3 * e2e3) + (e3e1 * e3e1));
    }

    public Rotor3 normalized() {
        return this.div(magnitude());
    }

    public @NotNull Vector3 rotate(Vector3 vector) {
        var normal = normalized();
        return normal.times(vector).times(normal.reverse()).vector();
    }

    public double angle() {
        return Math.atan2(bivector().magnitude(), scalar);
    }

    @Override
    public @NotNull Vector3 vector() {
        return Vector3.ZERO;
    }

    @Override
    public @NotNull Bivector3 bivector() {
        return new Bivector3(e1e2, e2e3, e3e1);
    }

    @Override
    public @NotNull Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @Override
    public @NotNull Rotor3 plus(double other) {
        return new Rotor3(scalar() + other, bivector());
    }

    @Override
    public @NotNull Geometric3Object plus(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), other, bivector(), Trivector3.ZERO);
    }

    @Override
    public @NotNull Rotor3 plus(@NotNull Bivector3 other) {
        return new Rotor3(scalar(), this.bivector().plus(other));
    }

    @Override
    public @NotNull Geometric3Object plus(@NotNull Trivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), other);
    }

    @Override
    public @NotNull Rotor3 minus(double other) {
        return new Rotor3(scalar() - other, bivector());
    }

    @Override
    public @NotNull Geometric3 minus(@NotNull Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Rotor3 minus(@NotNull Bivector3 other) {
        return new Rotor3(scalar(), bivector().minus(other));
    }

    @Override
    public @NotNull Geometric3 minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).times(other);
    }

    @Override
    public @NotNull Rotor3 times(@NotNull Bivector3 other) {

        var out = bivector().outer(other);
        var inn = bivector().inner(other).scalar();
        var sca = other.times(scalar);
        return new Rotor3(inn, out.plus(sca));
    }

    public @NotNull Rotor3 times(@NotNull Rotor3 other) {

        var out = bivector().outer(other);
        var inn = bivector().inner(other).scalar();
        var sca = other.times(scalar);
        return new Rotor3(inn, out.plus(sca));
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Trivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).times(other);
    }

    @Override
    public @NotNull Geometric3 inner(double other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public @NotNull Geometric3 inner(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public @NotNull Geometric3 inner(@NotNull Bivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public @NotNull Geometric3 inner(@NotNull Trivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public @NotNull Geometric3 outer(double other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Bivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public @NotNull Geometric3 outer(@NotNull Trivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public Rotor3 div(double other) {
        return new Rotor3(scalar / other, e1e2 / other, e2e3 / other, e3e1 / other);
    }

    @Override
    public Geometric3 div(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).div(other);
    }

    @Override
    public Geometric3 div(@NotNull Bivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).div(other);
    }

    @Override
    public Geometric3 div(@NotNull Trivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).div(other);
    }

    @Override
    public @NotNull Rotor3 unaryMinus() {
        return new Rotor3(-scalar(), bivector().unaryMinus());
    }

    @Override
    public @NotNull Rotor3 unaryPlus() {
        return new Rotor3(Math.abs(scalar()), bivector().unaryPlus());
    }

    @Override
    public @NotNull Rotor3 inverse() {
        return new Rotor3(1 / scalar(), bivector().inverse());
    }
}
