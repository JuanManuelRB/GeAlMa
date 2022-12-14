package juanmanuel.gealma.threedimensional;

/**
 * The e0 parameter can have any real value, including negative values. It represents the amount of rotation in
 * the rotor.
 *
 * The bivector parameter can have any value that is a valid bivector in geometric algebra. A bivector is a multivector
 * with a grade (or number of dimensions) of 2. It can be expressed as a linear combination of the basis bivectors of
 * the algebra, which satisfy the following conditions:
 *
 * The bivectors are orthogonal to the e0 unit (e1.e., the unit with a grade of 0).
 * The bivectors are orthogonal to each other.
 * The bivectors square to the negative of the e0 unit.
 * For example, in 3-dimensional Euclidean space, the basis bivectors are e2e3, e3e1, and e1e2, where e1, e2, and e3 are
 * the basis vectors of the space.
 *
 * It's important to note that the bivector parameter should not be confused with the vector parameter, which represents
 * a multivector with a grade of 1. A vector is a linear combination of the basis vectors of the algebra, and it is
 * orthogonal to the e0 unit, but it is not orthogonal to the bivectors.
 *
 * @param e0
 * @param e1e2
 * @param e2e3
 * @param e3e1
 *
 */
public record Rotor3(double e0, double e1e2, double e2e3, double e3e1) implements Geometric3 {
    public Rotor3(double scalar, Bivector3 bivector) {
        this(scalar, bivector.e1e2(), bivector.e2e3(), bivector.e3e1());
    }

    public Rotor3(Scalar scalar, Bivector3 bivector) {
        this(scalar.e0(), bivector.e1e2(), bivector.e2e3(), bivector.e3e1());
    }

    public Rotor3() {
        this(0, 0, 0, 0);
    }

//    /**
//     * Takes two vectors and creates a rotor that will rotate twice the angle between the two vectors.
//     *
//     * @param from the vector from which the angle starts.
//     * @param to the vector to which the angle ends.
//     */
//    public Rotor3(Vector3 from, Vector3 to) {
//        this(Math.acos(from.inner(to).scalar().e0()), from.outer(to));
//    }

    public static Rotor3 fromPlain(double angle, Bivector3 plain) {
        var halfAngle = angle / 2;
        return new Rotor3(Math.cos(halfAngle), plain.normalized().times(Math.sin(halfAngle)));
    }

    public static Rotor3 fromAxis(double angle, Vector3 axis) {
        var halfAngle = angle / 2;
        var plain = axis.times(Trivector3.ONE);
        return new Rotor3(Math.cos(halfAngle), plain.normalized().times(Math.sin(halfAngle)));

    }

    public Rotor3 reverse() {
        return new Rotor3(e0, -e1e2, -e2e3, -e3e1);
    }

    @Override
    public double magnitude() {
        return this.inner(this).e0();
    }

    public double angle() {
        return 2 * Math.atan2(bivector().magnitude(), e0);
    }

//    public double angle() {
//        return 2 * Math.acos(this.normalized().e0);
//    }

    @Override
    public Rotor3 normalized() {
        return this.div(magnitude());
    }

    public Vector3 rotate(Vector3 vector) {
        var normal = normalized();
        return normal.times(vector).times(normal.reverse()).vector();
    }


    @Override
    public Scalar scalar() {
        return new Scalar(e0);
    }

    @Override
    public Vector3 vector() {
        return Vector3.ZERO;
    }

    @Override
    public Bivector3 bivector() {
        return new Bivector3(e1e2, e2e3, e3e1);
    }

    @Override
    public Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(e0() + other.e0, bivector().plus(other.bivector()));
    }

    @Override
    public Rotor3 plus(double other) {
        return new Rotor3(e0() + other, bivector());
    }

    @Override
    public Geometric3Object plus(Vector3 other) {
        return new Geometric3Object(scalar(), other, bivector(), Trivector3.ZERO);
    }

    @Override
    public Rotor3 plus(Bivector3 other) {
        return new Rotor3(e0(), this.bivector().plus(other));
    }

    @Override
    public Geometric3Object plus(Trivector3 other) {
        return new Geometric3Object(scalar(), Vector3.ZERO, bivector(), other);
    }

    @Override
    public Rotor3 minus(double other) {
        return new Rotor3(e0() - other, bivector());
    }

    @Override
    public Geometric3 minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Rotor3 minus(Bivector3 other) {
        return new Rotor3(e0(), bivector().minus(other));
    }

    @Override
    public Geometric3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Rotor3 times(double other) {
        return new Rotor3(e0 * other, e1e2 * other, e2e3 * other, e3e1 * other);
    }

    @Override
    public Geometric3 times(Vector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).times(other);
    }

    @Override
    public Rotor3 times(Bivector3 other) {
        var out = bivector().outer(other);
        var inn = bivector().inner(other).scalar();
        var sca = other.times(e0);

        return new Rotor3(inn, out.plus(sca));
    }

    @Override
    public Rotor3 times(Rotor3 other) {
        var b1 = this.bivector();
        var b2 = other.bivector();

        var ss = this.e0 * other.e0;
        var inn = b1.inner(b2).scalar();
        var out = b1.outer(b2);

        return new Rotor3(inn.plus(ss), b1.times(other.e0).plus(b2.times(this.e0)).plus(out));
    }

    @Override
    public Geometric3 times(Trivector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).times(other);
    }

    @Override
    public Geometric3 inner(double other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public Geometric3 inner(Vector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public Geometric3 inner(Bivector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public Rotor3 inner(Rotor3 other) {
        return this.scalar().inner(other.scalar())
                .plus(this.bivector().inner(other.bivector()))
                .plus(this.scalar().inner(other.bivector()))
                .plus(other.scalar().inner(this.bivector()));
    }

    @Override
    public Geometric3 inner(Trivector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).inner(other);
    }

    @Override
    public Geometric3 outer(double other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public Geometric3 outer(Vector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public Geometric3 outer(Bivector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public Rotor3 outer(Rotor3 other) {
        return this.scalar().outer(other.scalar())
                .plus(this.bivector().outer(other.bivector()))
                .plus(this.scalar().outer(other.bivector()))
                .plus(other.scalar().outer(this.bivector())).rotor();
    }

    @Override
    public Geometric3 outer(Trivector3 other) {
        return new Geometric3Object(e0(), Vector3.ZERO, bivector(), Trivector3.ZERO).outer(other);
    }

    @Override
    public Rotor3 div(double other) {
        return new Rotor3(e0 / other, e1e2 / other, e2e3 / other, e3e1 / other);
    }

    @Override
    public Geometric3 div(Vector3 other) {
        return new Geometric3Object(e0(), vector(), bivector(), trivector()).div(other);
    }

    @Override
    public Geometric3 div(Bivector3 other) {
        // TODO: Bivector3
        return new Geometric3Object(e0(), vector(), bivector(), trivector()).div(other);
    }

    @Override
    public Rotor3 div(Rotor3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Trivector3 other) {
        return new Geometric3Object(e0(), vector(), bivector(), trivector()).div(other);
    }

    @Override
    public Rotor3 unaryMinus() {
        return new Rotor3(-e0(), bivector().unaryMinus());
    }

    @Override
    public Rotor3 unaryPlus() {
        return new Rotor3(Math.abs(e0()), bivector().unaryPlus());
    }

    @Override
    public Rotor3 reciprocal() {
        return new Rotor3(1 / e0(), bivector().reciprocal());
    }

    @Override
    public String toString() {
        return "Rotor: " + e0 + "(e0) + " + e1e2 + "(e1e2) + " + e2e3 + "(e2e3) + " + e3e1  + "(e3e1)";
    }
}
