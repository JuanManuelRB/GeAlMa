package juanmanuel.gealma.threedimensional;

import juanmanuel.gealma.nthdimensional.Geometric;
import org.jetbrains.annotations.NotNull;

/**
 * Interface that represents a 3-dimensional geometric algebra element.
 *
 * The metods defined in this interface are the necessary for the basic operations (sum, product, inversion, etc.)
 * on the geometric algebra elements in 3 dimensions.
 */
public interface Geometric3 extends Geometric {
    /**
     *
     * @return the scalar part of the object.
     */
    @NotNull Scalar scalar();

    /**
     *
     * @return the vector part of the object.
     */
    @NotNull Vector3 vector();

    /**
     *
     * @return the bivector part of the object.
     */
    @NotNull Bivector3 bivector();

    /**
     *
     * @return a rotor composed of the scalar and bivector parts of the object.
     */
    @NotNull default Rotor3 rotor() {
        return scalar().plus(bivector());
    }

    /**
     *
     * @return the trivector part of the object.
     */
    @NotNull Trivector3 trivector();

    /**
     *
     * @return the additive inverse of the element.
     */
    @NotNull Geometric3 unaryMinus();

    /**
     *
     * @return the multiplicative inverse of the element.
     */
    @NotNull Geometric3 reciprocal();

    /**
     *
     * @return the absolute value of the element.
     */
    @NotNull Geometric3 unaryPlus();

    /**
     *
     * @return the size of the element.
     */
    double magnitude();

    /**
     *
     * @return an element with same orientation and magnitude of 1.
     */
    @NotNull Geometric3 normalized();

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
    @NotNull Geometric3 plus(double other);

    /**
     *
     * @param other a scalar.
     * @return an element with the addition of a scalar.
     */
    @NotNull default Geometric3 plus(@NotNull Scalar other) {
        return plus(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional vector.
     * @return an element with the addition of a vector.
     */
    @NotNull Geometric3 plus(@NotNull Vector3 other);

    /**
     *
     * @param other a 3-dimensional bivector.
     * @return an element with the addition of a bivector.
     */
    @NotNull Geometric3 plus(@NotNull Bivector3 other);

    /**
     *
     * @param other a 3-dimensional rotor.
     * @return an element with the addition of the scalar and bivector parts of a rotor.
     */
    @NotNull Geometric3 plus(@NotNull Rotor3 other);

    /**
     *
     * @param other a 3-dimensional trivector.
     * @return an element with the addition of a trivector.
     */
    @NotNull Geometric3 plus(@NotNull Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return an element with the addition of other 3-dimensional element.
     */
    @NotNull
    default Geometric3 plus(@NotNull Geometric3 other) {
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
    @NotNull Geometric3 minus(double other);

    /**
     *
     * @param other a scalar.
     * @return an element with the subtraction of a scalar.
     */
    @NotNull default Geometric3 minus(@NotNull Scalar other) {
        return minus(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional vector.
     * @return an element with the subtraction of a vector.
     */
    @NotNull Geometric3 minus(@NotNull Vector3 other);

    /**
     *
     * @param other a 3-dimensional bivector.
     * @return an element with the subtraction of a bivector.
     */
    @NotNull Geometric3 minus(@NotNull Bivector3 other);

    /**
     *
     * @param other a 3-dimensional rotor.
     * @return an element with the subtraction of the scalar and bivector parts of a rotor.
     */
    @NotNull Geometric3 minus(@NotNull Rotor3 other);

    /**
     *
     * @param other a 3-dimensional trivector.
     * @return an element with the subtraction of a trivector.
     */
    @NotNull Geometric3 minus(@NotNull Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return an element with the subtraction of other 3-dimensional element.
     */
    @NotNull default Geometric3 minus(@NotNull Geometric3 other) {
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
    @NotNull Geometric3 inner(double other);

    /**
     *
     * @param other a scalar.
     * @return the element resulting from applying the inner product with a scalar.
     */
    @NotNull default Geometric3 inner(@NotNull Scalar other) {
        return inner(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional vector.
     */
    @NotNull Geometric3 inner(@NotNull Vector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional bivector.
     */
    @NotNull Geometric3 inner(@NotNull Bivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional rotor.
     */
    @NotNull Geometric3 inner(@NotNull Rotor3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional trivector.
     */
    @NotNull Geometric3 inner(@NotNull Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the inner product with a 3-dimensional element.
     */
    @NotNull default Geometric3 inner(@NotNull Geometric3 geometric3) {
        return this.inner(geometric3.scalar()).plus(this.inner(geometric3.vector())).plus(this.inner(geometric3.bivector())).plus(this.inner(geometric3.trivector()));
    }

    // Outer Product

    /**
     *
     * @param other a scalar value.
     * @return the element resulting from applying the outer product with a scalar value.
     */
    @NotNull Geometric3 outer(double other);

    /**
     *
     * @param other a scalar.
     * @return the element resulting from applying the outer product with a scalar.
     */
    @NotNull default Geometric3 outer(@NotNull Scalar other) {
        return outer(other.e0());
    }

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional vector.
     */
    @NotNull Geometric3 outer(@NotNull Vector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional bivector.
     */
    @NotNull Geometric3 outer(@NotNull Bivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional rotor.
     */
    @NotNull Geometric3 outer(@NotNull Rotor3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional trivector.
     */
    @NotNull Geometric3 outer(@NotNull Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the outer product with a 3-dimensional element.
     */
    @NotNull default Geometric3 outer(@NotNull Geometric3 geometric3) {
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
    @NotNull Geometric3 times(double other);

    /**
     *
     * @param other a 3-dimensional scalar.
     * @return the element resulting from applying the geometric product with a 3-dimensional scalar.
     */
    @NotNull default Geometric3 times(@NotNull Scalar other) {
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
    @NotNull Geometric3 times(@NotNull Vector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional bivector.
     */
    @NotNull Geometric3 times(@NotNull Bivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional rotor.
     */
    @NotNull Geometric3 times(@NotNull Rotor3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional trivector.
     */
    @NotNull Geometric3 times(@NotNull Trivector3 other);

    /**
     *
     * @param other a 3-dimensional element.
     * @return the element resulting from applying the geometric product with a 3-dimensional element.
     */
    @NotNull default Geometric3 times(@NotNull Geometric3 other) {
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
    @NotNull Geometric3 div(double other);

    /**
     *
     * @param other a scalar.
     * @return the element resulting from applying the geometric product with the inverse of a scalar.
     */
    @NotNull default Geometric3 div(@NotNull Scalar other) {
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
    @NotNull Geometric3 div(@NotNull Vector3 other);

    /**
     *
     * @param other a 3-dimensional vector.
     * @return the element resulting from applying the geometric product with the inverse of a 3-dimensional bivector.
     */
    @NotNull Geometric3 div(@NotNull Bivector3 other);

    /**
     *
     * @param other a 3-dimensional vector.
     * @return the element resulting from applying the geometric product with the inverse of a 3-dimensional rotor.
     */
    @NotNull Geometric3 div(@NotNull Rotor3 other);

    /**
     *
     * @param other a 3-dimensional vector.
     * @return the element resulting from applying the geometric product with the inverse of a 3-dimensional trivector.
     */
    @NotNull Geometric3 div(@NotNull Trivector3 other);

}
