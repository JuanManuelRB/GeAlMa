package juanmanuel.gealma.threedimensional;

/**
 * Interface that represents a 3-dimensional geometric algebra element.
 * <p>
 * The metods defined in this interface are the necessary for the basic operations (sum, product, inversion, etc.)
 * on the geometric algebra elements in 3 dimensions.
 */
public interface Geometric3 {
    /**
     *
     * @return the scalar part of the object.
     */
    Scalar scalar();

    /**
     *
     * @return the vector part of the object.
     */
    Vector3 vector();

    /**
     * @return the bivector part of the object.
     */
    Bivector3 bivector();

    /**
     *
     * @return a rotor composed of the scalar and bivector parts of the object.
     */
    default Rotor3 rotor() {
        return scalar().plus(bivector());
    }

    /**
     *
     * @return the trivector part of the object.
     */
    Trivector3 trivector();

    /**
     *
     * @return the additive inverse of the element.
     */
    Geometric3 unaryMinus();

    /**
     *
     * @return the multiplicative inverse of the element.
     */
    Geometric3 reciprocal();

    /**
     *
     * @return the absolute value of the element.
     */
    Geometric3 unaryPlus();

    /**
     *
     * @return the size of the element.
     */
    double magnitude();

    /**
     *
     * @return an element with same orientation and magnitude of 1.
     */
    Geometric3 normalized();

    /**
     *
     * @return the basis e0 value.
     */
    default double e0() {
        return scalar().e0();
    }

    /**
     *
     * @return the basis e1 value.
     */
    default double e1() {
        return vector().e1();
    }

    /**
     *
     * @return the basis e2 value.
     */
    default double e2() {
        return vector().e2();
    }

    /**
     *
     * @return the basis e3 value.
     */
    default double e3() {
        return vector().e3();
    }

    /**
     *
     * @return the basis e1e2 value.
     */
    default double e1e2() {
        return bivector().e1e2();
    }

    /**
     *
     * @return the basis e2e3 value.
     */
    default double e2e3() {
        return bivector().e2e3();
    }

    /**
     *
     * @return the basis e3e1 value.
     */
    default double e3e1() {
        return bivector().e3e1();
    }

    /**
     *
     * @return the basis e1e2e3 value.
     */
    default double e1e2e3() {
        return trivector().e1e2e3();
    }

    // Addition

    /**
     *
     * @param other a scalar value.
     * @return an element with the addition of a scalar value.
     */
    Geometric3 plus(double other);

    /**
     *
     * @param other a scalar.
     * @return an element with the addition of a scalar.
     */
    default Geometric3 plus(Scalar other) {
        return plus(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional vector.
     * @return an element with the addition of a vector.
     */
    Geometric3 plus(Vector3 other);

    /**
     *
     * @param other a 3-dimensional bivector.
     * @return an element with the addition of a bivector.
     */
    Geometric3 plus(Bivector3 other);

    /**
     *
     * @param other a 3-dimensional rotor.
     * @return an element with the addition of the scalar and bivector parts of a rotor.
     */
    Geometric3 plus(Rotor3 other);

    /**
     *
     * @param other a 3-dimensional trivector.
     * @return an element with the addition of a trivector.
     */
    Geometric3 plus(Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return an element with the addition of other 3-dimensional element.
     */
    default Geometric3 plus(Geometric3 other) {
        return new Geometric3Object(
                this.e0() + other.e0(),
                this.e1() + other.e0(),
                this.e2() + other.e0(),
                this.e3() + other.e0(),
                this.e1e2() + other.e0(),
                this.e2e3() + other.e0(),
                this.e3e1() + other.e0(),
                this.e1e2e3() + other.e0()
        );
    }

    // Subtraction

    /**
     *
     * @param other a scalar value.
     * @return an element with the subtraction of a scalar value.
     */
    Geometric3 minus(double other);

    /**
     *
     * @param other a scalar.
     * @return an element with the subtraction of a scalar.
     */
    default Geometric3 minus(Scalar other) {
        return minus(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional vector.
     * @return an element with the subtraction of a vector.
     */
    Geometric3 minus(Vector3 other);

    /**
     *
     * @param other a 3-dimensional bivector.
     * @return an element with the subtraction of a bivector.
     */
    Geometric3 minus(Bivector3 other);

    /**
     *
     * @param other a 3-dimensional rotor.
     * @return an element with the subtraction of the scalar and bivector parts of a rotor.
     */
    Geometric3 minus(Rotor3 other);

    /**
     *
     * @param other a 3-dimensional trivector.
     * @return an element with the subtraction of a trivector.
     */
    Geometric3 minus(Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return an element with the subtraction of other 3-dimensional element.
     */
    default Geometric3 minus(Geometric3 other) {
        return new Geometric3Object(
                this.e0() - other.e0(),
                this.e1() - other.e0(),
                this.e2() - other.e0(),
                this.e3() - other.e0(),
                this.e1e2() - other.e0(),
                this.e2e3() - other.e0(),
                this.e3e1() - other.e0(),
                this.e1e2e3() - other.e0()
        );
    }

    // Inner Product

    /**
     *
     * @param other a scalar value.
     * @return the element resulting from applying the inner product with a scalar value.
     */
    Geometric3 inner(double other);

    /**
     *
     * @param other a scalar.
     * @return the element resulting from applying the inner product with a scalar.
     */
    default Geometric3 inner(Scalar other) {
        return inner(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional vector.
     */
    Geometric3 inner(Vector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional bivector.
     */
    Geometric3 inner(Bivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional rotor.
     */
    Geometric3 inner(Rotor3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional trivector.
     */
    Geometric3 inner(Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional element.
     */
    default Geometric3 inner(Geometric3 geometric3) {
        return this.inner(geometric3.scalar()).plus(this.inner(geometric3.vector())).plus(this.inner(geometric3.bivector())).plus(this.inner(geometric3.trivector()));
    }

    // Outer Product

    /**
     *
     * @param other a scalar value.
     * @return the element resulting from applying the outer product with a scalar value.
     */
    Geometric3 outer(double other);

    /**
     *
     * @param other a scalar.
     * @return the element resulting from applying the outer product with a scalar.
     */
    default Geometric3 outer(Scalar other) {
        return outer(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional vector.
     */
    Geometric3 outer(Vector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional bivector.
     */
    Geometric3 outer(Bivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional rotor.
     */
    Geometric3 outer(Rotor3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional trivector.
     */
    Geometric3 outer(Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional element.
     */
    default Geometric3 outer(Geometric3 geometric3) {
        return this.outer(geometric3.scalar())
                .plus(this.outer(geometric3.vector()))
                .plus(this.outer(geometric3.bivector()))
                .plus(this.outer(geometric3.trivector()));
    }

    // Product

    /**
     *
     * @param other a 3-dimensional scalar value.
     * @return the element resulting from applying the geometric product with a 3-dimensional scalar value.
     */
    Geometric3 times(double other);

    /**
     *
     * @param other a 3-dimensional scalar.
     * @return the element resulting from applying the geometric product with a 3-dimensional scalar.
     */
    default Geometric3 times(Scalar other) {
        //return new Geometric3Object(scalar().times(other), vector().times(other), bivector().times(other), trivector().times(other));
        return new Geometric3Object(
                this.e0() * other.e0(),
                this.e1() * other.e0(),
                this.e2() * other.e0(),
                this.e3() * other.e0(),
                this.e1e2() * other.e0(),
                this.e2e3() * other.e0(),
                this.e3e1() * other.e0(),
                this.e1e2e3() * other.e0()
        );
    }

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional vector.
     */
    Geometric3 times(Vector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional bivector.
     */
    Geometric3 times(Bivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional rotor.
     */
    Geometric3 times(Rotor3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional trivector.
     */
    Geometric3 times(Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional element.
     */
    default Geometric3 times(Geometric3 other) {
        return this.times(other.scalar())
                .plus(this.times(other.vector()))
                .plus(this.times(other.bivector()))
                .plus(this.times(other.trivector()));
    }

    // Division

    /**
     *
     * @param other a scalar value.
     * @return the element resulting from applying the geometric product with the inverse of a scalar value.
     */
    Geometric3 div(double other);

    /**
     *
     * @param other a scalar.
     * @return the element resulting from applying the geometric product with the inverse of a scalar.
     */
    default Geometric3 div(Scalar other) {
        return new Geometric3Object(
                this.e0() / other.e0(),
                this.e1() / other.e0(),
                this.e2() / other.e0(),
                this.e3() / other.e0(),
                this.e1e2() / other.e0(),
                this.e2e3() / other.e0(),
                this.e3e1() / other.e0(),
                this.e1e2e3() / other.e0()
        );
    }

    /**
     *
     * @param other a 3-dimensional vector.
     * @return the element resulting from applying the geometric product with the inverse of a 3-dimensional vector.
     */
    Geometric3 div(Vector3 other);

    /**
     *
     * @param other a 3-dimensional vector.
     * @return the element resulting from applying the geometric product with the inverse of a 3-dimensional bivector.
     */
    Geometric3 div(Bivector3 other);

    /**
     *
     * @param other a 3-dimensional vector.
     * @return the element resulting from applying the geometric product with the inverse of a 3-dimensional rotor.
     */
    Geometric3 div(Rotor3 other);

    /**
     *
     * @param other a 3-dimensional vector.
     * @return the element resulting from applying the geometric product with the inverse of a 3-dimensional trivector.
     */
    Geometric3 div(Trivector3 other);

}
