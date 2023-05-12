package juanmanuel.gealma.threedimensional;

import juanmanuel.gealma.basis.Basis3;
import juanmanuel.gealma.basis.E0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public record Scalar(@Override E0 e0) implements Geometric3<Scalar>, Comparable<Scalar> {
    // Corresponds to the number of basis of the geometric object.
    public static final byte NUMBER_OF_ELEMENTS = 1;

    public static final Scalar ZERO = new Scalar(E0.ZERO);
    public static final Scalar ONE = new Scalar(1);

    public Scalar {
        Objects.requireNonNull(e0);
    }

    public Scalar(double e0) {
        this(new E0(e0));
    }

    @Override
    public double magnitudeSquared() {
        return inner(this).value();
    }

    @Override
    public double magnitude() {
        return e0.value();
    }

    double value() {
        return e0.value();
    }

    @Override
    public Scalar normalized() {
        return ONE;
    }

    @Override
    public Scalar inverse() {
        return new Scalar(1 / value());
    }

    @Override
    public Scalar unaryMinus() {
        return new Scalar(-value());
    }

    @Override
    public Scalar plus(Scalar other) {
        return new Scalar(this.value() + other.value());
    }

    @Override
    public Scalar minus(Scalar other) {
        return new Scalar(this.value() - other.value());
    }

    public Scalar plus(double other) {
        return plus(new Scalar(other));
    }

    public Multivector3 plus(Vector3 other) {
        return new Multivector3(this, other, Bivector3.ZERO, Trivector3.ZERO);
    }

    public Rotor3 plus(Bivector3 other) {
        return new Rotor3(this, other);
    }

    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(this.plus(other.scalar()), other.bivector());
    }

    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(this, Vector3.ZERO, Bivector3.ZERO, other);
    }

    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(this.plus(other.scalar()), other.vector(), other.bivector(), other.trivector());
    }

    public Scalar minus(double other) {
        return minus(new Scalar(other));
    }

    public Multivector3 minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor3 minus(Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Multivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Scalar inner(double other) {
        return inner(new Scalar(other));
    }

    @Override
    public Scalar inner(Scalar other) {
        return new Scalar(this.e0.times(other.e0));
    }

    @Override
    public Vector3 inner(Vector3 other) {
        return new Vector3(e0.times(other.e1()), e0.times(other.e2()), e0.times(other.e3()));
    }

    @Override
    public Bivector3 inner(Bivector3 other) {
        return new Bivector3(e0.times(other.e1e2()), e0.times(other.e2e3()), e0.times(other.e3e1()));
    }

    @Override
    public Rotor3 inner(Rotor3 other) {
        return inner(other.scalar()).plus(inner(other.bivector()));
    }

    @Override
    public Trivector3 inner(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

    @Override
    public Multivector3 inner(Multivector3 other) {
        return inner(other.scalar())
                .plus(inner(other.vector()))
                .plus(inner(other.bivector()))
                .plus(inner(other.trivector()));
    }

    @Override
    public Scalar outer(double other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Scalar other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Vector3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Bivector3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Rotor3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Trivector3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Multivector3 other) {
        return ZERO;
    }

    @Override
    public Scalar times(double other) {
        return times(new Scalar(other));
    }

    @Override
    public Scalar times(Scalar other) {
        return new Scalar(this.e0.times(other.e0));
    }

    @Override
    public Vector3 times(Vector3 other) {
        return new Vector3(e0.times(other.e1()), e0.times(other.e2()), e0.times(other.e3()));
    }

    @Override
    public Bivector3 times(Bivector3 other) {
        return new Bivector3(e0.times(other.e1e2()), e0.times(other.e2e3()), e0.times(other.e3e1()));
    }

    @Override
    public Rotor3 times(Rotor3 other) {
        return new Rotor3(this.times(other.scalar()), this.times(other.bivector()));
    }

    @Override
    public Trivector3 times(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

    @Override
    public Multivector3 times(Multivector3 other) {
        return new Multivector3(
                this.times(other.scalar()),
                this.times(other.vector()),
                this.times(other.bivector()),
                this.times(other.trivector())
        );
    }

    @Override
    public Scalar div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Scalar div(Scalar other) {
        return new Scalar(this.value() / other.value());
    }

    @Override
    public Vector3 div(Vector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Bivector3 div(Bivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Rotor3 div(Rotor3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Trivector3 div(Trivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Geometric3 div(Multivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public int compareTo(Scalar other) {
        return Double.compare(e0.value(), other.e0.value());
    }

    @Override
    public Iterator<Basis3<?>> iterator() {
        return new Iterator<>() {
            private byte actual = 1;

            @Override
            public boolean hasNext() {
                return actual <= NUMBER_OF_ELEMENTS;
            }

            @Override
            public E0 next() {
                if (actual != 1)
                    throw new NoSuchElementException("The element " + actual + " does not correspond to any element of vectors in three dimensions");

                actual++;
                return e0;
            }
        };
    }

    @Override
    public String toString() {
        return "(" + e0.value() + ")e0";
    }

    @Override
    public Scalar reverse() {
        return this;
    }
}
