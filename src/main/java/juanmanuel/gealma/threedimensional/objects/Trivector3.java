package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.threedimensional.basis.E0;
import juanmanuel.gealma.threedimensional.basis.E1E2E3;
import juanmanuel.gealma.threedimensional.basis.Geometric3Basis;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public record Trivector3(@Override E1E2E3 e1e2e3) implements Geometric3 {
    // Corresponds to the number of basis of the geometric object.
    public static final byte NUMBER_OF_ELEMENTS = 1;

    public static final Trivector3 ONE = new Trivector3(1);
    public static final Trivector3 ZERO = new Trivector3(E1E2E3.ZERO);

    public Trivector3 {
        Objects.requireNonNull(e1e2e3);
    }

    public Trivector3(double e1e2e3) {
        this(new E1E2E3(e1e2e3));
    }

    @Override
    public String toString() {
        return "(" + e1e2e3.value() + ")e1e2e3";
    }

    @Override
    public Geometric3 normalized() {
        return null;
    }

    @Override
    public double magnitudeSquared() {
        return Math.abs(this.inner(this).value());
    }

    @Override
    public double magnitude() {
        return e1e2e3.value();
    }

    public double volume() {
        return magnitude();
    }

    @Override
    public Trivector3 unaryMinus() {
        return new Trivector3(-e1e2e3.value());
    }

    @Override
    public Trivector3 reciprocal() {
        return div(magnitudeSquared());
    }

    @Override
    public Multivector3 plus(double other) {
        return plus(new Scalar(other));
    }

    @Override
    public Multivector3 plus(Scalar other) {
        return new Multivector3(other, Vector3.ZERO, Bivector3.ZERO, this);
    }

    @Override
    public Multivector3 plus(Vector3 other) {
        return new Multivector3(Scalar.ZERO, other, Bivector3.ZERO, this);
    }

    @Override
    public Multivector3 plus(Bivector3 other) {
        return new Multivector3(Scalar.ZERO, Vector3.ZERO, other, this);
    }

    @Override
    public Multivector3 plus(Rotor3 other) {
        return new Multivector3(other.scalar(), Vector3.ZERO, other.bivector(), this);
    }

    @Override
    public Trivector3 plus(Trivector3 other) {
        return new Trivector3(e1e2e3.plus(other.e1e2e3));
    }

    @Override
    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(
                other.scalar(),
                other.vector(),
                other.bivector(),
                this.plus(other.trivector()));
    }

    @Override
    public Trivector3 div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Trivector3 div(Scalar other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Bivector3 div(Vector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Vector3 div(Bivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Multivector3 div(Rotor3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Scalar div(Trivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Multivector3 div(Multivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Trivector3 times(double other) {
        return new Trivector3(e1e2e3.times(new E0(other)));
    }

    @Override
    public Trivector3 times(Scalar other) {
        return new Trivector3(e1e2e3.times(other.e0()));
    }

    @Override
    public Bivector3 times(Vector3 other) {
        return inner(other);
    }

    @Override
    public Vector3 times(Bivector3 other) {
        // outer product = 0
        return inner(other);
    }

    /**
     * @param other
     * @return a multivector composed of vector + trivector.
     */
    @Override
    public Multivector3 times(Rotor3 other) {
        // outer product = 0
        return this.inner(other); // vector + trivector
    }

    @Override
    public Scalar times(Trivector3 other) {
        return inner(other);
    }

    @Override
    public Multivector3 times(Multivector3 other) {
        return times(other.scalar())
                .plus(times(other.vector()))
                .plus(times(other.bivector()))
                .plus(times(other.trivector()));
    }

    @Override
    public Trivector3 inner(double other) {
        return inner(new Scalar(other));
    }

    @Override
    public Trivector3 inner(Scalar other) {
        return new Trivector3(e1e2e3.times(other.e0()));
    }

    @Override
    public Bivector3 inner(Vector3 other) {
        return new Bivector3(
                e1e2e3.times(other.e3()),
                e1e2e3.times(other.e1()),
                e1e2e3.times(other.e2())
        );
    }

    @Override
    public Vector3 inner(Bivector3 other) {
        return new Vector3(
                e1e2e3.times(other.e2e3()),
                e1e2e3.times(other.e3e1()),
                e1e2e3.times(other.e1e2())
        );
    }

    @Override
    public Multivector3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    /**
     * @param other a trivector
     * @return a scalar
     */
    @Override
    public Scalar inner(Trivector3 other) {
        return new Scalar(e1e2e3.times(other.e1e2e3));
    }

    /**
     * @param other a multivector
     * @return a multivector
     */
    @Override
    public Multivector3 inner(Multivector3 other) {
        var trivScalar = this.inner(other.scalar());
        var trivVector = this.inner(other.vector());
        var trivBivector = this.inner(other.bivector());
        var trivTrivector = this.inner(other.trivector());
        return trivScalar.plus(trivVector).plus(trivBivector).plus(trivTrivector);
    }

    /**
     * @param other a scalar
     * @return a trivector
     */
    @Override
    public Trivector3 outer(double other) {
        return outer(new Scalar(other));
    }

    /**
     * @param other a scalar
     * @return a trivector
     */
    @Override
    public Trivector3 outer(Scalar other) {
        return new Trivector3(e1e2e3.times(other.e0()));
    }

    /**
     * Always 0
     *
     * @param other a vector
     * @return a scalar with value 0.
     */
    @Override
    public Scalar outer(Vector3 other) {
        return Scalar.ZERO;
    }

    /**
     * Always 0
     *
     * @param other a bivector
     * @return a scalar with value 0.
     */
    @Override
    public Scalar outer(Bivector3 other) {
        return Scalar.ZERO;
    }

    /**
     * Always 0
     *
     * @param other a rotor
     * @return a scalar with value 0.
     */
    @Override
    public Scalar outer(Rotor3 other) {
        // outer product = 0
        return Scalar.ZERO;
    }

    @Override
    public Scalar outer(Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public Trivector3 outer(Multivector3 other) {
        return outer(other.scalar());
    }

    @Override
    public Multivector3 minus(double other) {
        return null;
    }

    @Override
    public Multivector3 minus(Scalar other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Multivector3 minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Multivector3 minus(Bivector3 other) {
        return this.plus(other.unaryMinus());

    }

    @Override
    public Multivector3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());

    }

    @Override
    public Trivector3 minus(Trivector3 other) {
        return new Trivector3(e1e2e3.plus(other.e1e2e3.unaryMinus()));
    }

    @Override
    public Multivector3 minus(Multivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Iterator<Geometric3Basis> iterator() {
        return new Iterator<>() {
            private byte actual = 1;

            @Override
            public boolean hasNext() {
                return actual <= NUMBER_OF_ELEMENTS;
            }

            @Override
            public Geometric3Basis next() {
                if (actual != 1)
                    throw new NoSuchElementException("The element " + actual + " does not correspond to any element of vectors in three dimensions");

                actual++;
                return e1e2e3;
            }
        };
    }

    @Override
    public Trivector3 reverse() {
        return unaryMinus();
    }
}
