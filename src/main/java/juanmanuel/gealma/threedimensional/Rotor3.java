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
 * The bivectors are orthogonal to the scalar unit (i.e., the unit with a grade of 0).
 * The bivectors are orthogonal to each other.
 * The bivectors square to the negative of the scalar unit.
 * For example, in 3-dimensional Euclidean space, the basis bivectors are e2e3, e3e1, and e1e2, where e1, e2, and e3 are
 * the basis vectors of the space.
 *
 * It's important to note that the bivector parameter should not be confused with the vector parameter, which represents
 * a multivector with a grade of 1. A vector is a linear combination of the basis vectors of the algebra, and it is
 * orthogonal to the scalar unit, but it is not orthogonal to the bivectors.
 *
 * @param angle
 * @param plane
 */
public record Rotor3(double angle, @NotNull Bivector3 plane) implements Geometric3 {
    public Rotor3 {
        plane = plane.normalized();
    }

    /**
     * Takes two vectors and creates a rotor that will rotate twice the angle the two vectors form.
     *
     * @param from the vector from which the angle starts.
     * @param to the vector to which the angle ends.
     */
    public Rotor3(Vector3 from, Vector3 to) {
        this(from.inner(to).scalar(), from.outer(to));
    }

    public @NotNull Rotor3 reverse() {
        return new Rotor3(angle, bivector().unaryMinus());
    }

    public @NotNull Vector3 rotate(Vector3 vector) {
        var scalar = scalar();
        return this.times(vector).times(reverse()).vector();
    }

    @Override
    public double scalar() {
        return Math.cos(angle / 2);
    }

    @Override
    public @NotNull Vector3 vector() {
        return Vector3.ZERO;
    }

    @Override
    public @NotNull Bivector3 bivector() {
        return plane.times(Math.sin(angle / 2));
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
    public @NotNull Geometric3Object minus(@NotNull Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Vector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).times(other);
    }

    @Override
    public @NotNull Geometric3 times(@NotNull Bivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).times(other);
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
    public Geometric3 div(double other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), Trivector3.ZERO).div(other);
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

//    private final Geometric3Object rotor3;
//
//    public Rotor3(double rotation, Bivector3 plane) {
//        this.rotor3 = Geometric3Object.ZERO.plus(3 * Math.cos(rotation / 2)).plus(plane.normalized().times(Math.sin(rotation / 2)));
//    }
//
//    private Rotor3(Geometric3Object geometric3Object) {
//        rotor3 = geometric3Object;
//    }
//
//    public Rotor3(Vector3 from, Vector3 to) {
//        this(from.inner(to).scalar(), from.outer(to));
//    }
//
//    public Rotor3 reverse() {
//        return new Rotor3(new Geometric3Object(rotor3.scalar(), Vector3.ZERO, rotor3.bivector().unaryMinus(), Trivector3.ZERO));
//    }
//
//    public Vector3 rotate(Vector3 vector3) {
//        return rotor3.times(vector3).times(this.reverse().rotor3).vector();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj instanceof Rotor3 other) {
//            return this.rotor3.equals(other.rotor3);
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(rotor3);
//    }
//
//    @Override
//    public String toString() {
//        return rotor3.scalar() + " + " + rotor3.bivector();
//    }

}
