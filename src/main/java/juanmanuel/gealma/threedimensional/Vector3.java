package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.basis.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public record Vector3(@Override E1 e1, @Override E2 e2, @Override E3 e3) implements Geometric3<Vector3> {
    // Corresponds to the number of basis of the geometric object.
    public static final byte NUMBER_OF_ELEMENTS = 3;
    public static final Vector3 ZERO = new Vector3(E1.ZERO, E2.ZERO, E3.ZERO);
    public static final Vector3 ONE = new Vector3(new E1(1), new E2(1), new E3(1));

    public Vector3 {
        Objects.requireNonNull(e1);
        Objects.requireNonNull(e2);
        Objects.requireNonNull(e3);
    }

    public Vector3(double e1, double e2, double e3) {
        this(new E1(e1), new E2(e2), new E3(e3));
    }

    @Override
    public Vector3 unaryMinus() {
        return new Vector3(e1.unaryMinus(), e2.unaryMinus(), e3.unaryMinus());
    }

    @Override
    public double magnitudeSquared() {
        return Math.abs(this.inner(this).value());
    }

    @Override
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    @Override
    public Vector3 inverse() {
        return div(magnitudeSquared());
    }

    @Override
    public Vector3 normalized() {
        return this.div(this.magnitude());
    }

    public double length() {
        return magnitude();
    }

    public Vector3 reflectOver(Vector3 other) {
        return other.inverse().times(this).times(other).vector();
    }

    public Vector3 rotated(Rotor3 rotor) {
        return rotor.rotate(this);
    }

    public Vector3 rotated(Bivector3 plane, double angle) {
        return Rotor3.from(plane, angle).rotate(this);
    }

    public Vector3 rotated(Vector3 axis, double angle) {
        return Rotor3.from(axis, angle).rotate(this);
    }

    public Vector3 projection(Vector3 vector) {
        return vector.inverse().times(this.inner(vector));
    }

    public Vector3 projection(Bivector3 plane) {
//        return plane.reciprocal().times(this.inner(plane));
        return null;
    }

    public Vector3 rejection(Vector3 vector) {
        return this.minus(projection(vector));
    }

    public Vector3 reflection(Vector3 vector) {
        var proj = projection(vector);
        var rej = this.minus(proj); // Equivalent to rejection(), but saves calling twice projection() method.

        return proj.minus(rej);
//        return vector.reciprocal().times(this).times(vector);
    }

    /**
     * Returns an array of doubles with the values of the vector's basis. The order of the basis is the same as the order
     * of the basis in the {@link Basis3}.
     */
    private double[] toArray() {
        return new double[]{this.e1.value(), this.e2.value(), this.e3.value()};
    }

    @Override
    public Vector3 plus(Vector3 other) {
        return new Vector3(
                this.e1.value() + other.e1.value(),
                this.e2.value() + other.e2.value(),
                this.e3.value() + other.e3.value()
        );
    }

    @Override
    public Vector3 minus(Vector3 other) {
        return plus(other.unaryMinus());
    }

    public Multivector3 plus(double other) {
        return plus(new Scalar(other));
    }

    public Multivector3 plus(Scalar other) {
        return new Multivector3(other, this, Bivector3.ZERO, Trivector3.ZERO);
    }


    public Multivector3 plus(Bivector3 other) {
        return new Multivector3(Scalar.ZERO, this, other, Trivector3.ZERO);
    }

    public Multivector3 plus(Rotor3 other) {
        return new Multivector3(other.scalar(), this, other.bivector(), Trivector3.ZERO);
    }

    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(Scalar.ZERO, this, Bivector3.ZERO, other);
    }

    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(other.scalar(), this.plus(other.vector()), other.bivector(), other.trivector());
    }

    public Multivector3 minus(double other) {
        return this.plus(-other);
    }

    public Multivector3 minus(Scalar other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Bivector3 other) {
        return new Multivector3(Scalar.ZERO, this, other, Trivector3.ZERO);
    }

    public Multivector3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Trivector3 other) {
        return new Multivector3(Scalar.ZERO, this, Bivector3.ZERO, other);
    }

    public Multivector3 minus(Multivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Vector3 inner(double other) {
        return inner(new Scalar(other));
    }

    @Override
    public Vector3 inner(Scalar other) {
        return other.inner(this);
    }

    @Override
    public Scalar inner(Vector3 other) {
        return new Scalar(this.e1.times(other.e1)
                .plus(this.e2.times(other.e2))
                .plus(this.e3.times(other.e3))
        );
    }

    @Override
    public Vector3 inner(Bivector3 other) {
        return new Vector3(
                e3.times(other.e3e1()).plus(e2.times(other.e1e2())),
                e1.times(other.e1e2()).plus(e3.times(other.e2e3())),
                e2.times(other.e2e3()).plus(e1.times(other.e3e1()))
        );
    }

    @Override
    public Vector3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public Bivector3 inner(Trivector3 other) {
        return new Bivector3(
                e3.times(other.e1e2e3()),
                e1.times(other.e1e2e3()),
                e2.times(other.e1e2e3())
        );
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
        return Scalar.ZERO;
    }

    @Override
    public Scalar outer(Scalar other) {
        return Scalar.ZERO;
    }

    @Override
    public Bivector3 outer(Vector3 other) {
        return new Bivector3(
                this.e1.times(e2).plus(other.e1.times(this.e2)),
                this.e2.times(e3).plus(other.e2.times(this.e3)),
                this.e3.times(e1).plus(other.e3.times(this.e1))
        );
    }

    @Override
    public Trivector3 outer(Bivector3 other) {
        return new Trivector3(this.e1.times(other.e2e3())
                .plus(this.e2.times(other.e3e1()))
                .plus(this.e3.times(other.e1e2()))
        );
    }

    public Trivector3 outer(Rotor3 other) {
        return this.outer(other.bivector());
    }

    @Override
    public Scalar outer(Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public Geometric3<?> outer(Multivector3 other) {
        return this.outer(other.scalar())
                .plus(this.outer(other.vector()))
                .plus(this.outer(other.bivector()))
                .plus(this.outer(other.trivector()));
    }

    @Override
    public Vector3 times(double other) {
        return times(new Scalar(other));
    }

    @Override
    public Vector3 times(Scalar other) {
        // outer product = 0
        return this.inner(other);
    }

    @Override
    public Rotor3 times(Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Multivector3 times(Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Multivector3 times(Rotor3 other) {
        return this.times(other.scalar()).plus(this.times(other.bivector()));
    }

    @Override
    public Bivector3 times(Trivector3 other) {
        // outer product = 0
        return this.inner(other);
    }

    @Override
    public Multivector3 times(Multivector3 other) {
        return this.times(other.scalar())
                .plus(this.times(other.vector()))
                .plus(this.times(other.bivector()))
                .plus(this.times(other.trivector()));
    }

    public Vector3 div(double other) {
        return div(new Scalar(other));
    }

    public Vector3 div(Scalar other) {
        return this.times(other.inverse());
    }

    public Rotor3 div(Vector3 other) {
        return times(other.inverse());
    }

    public Multivector3 div(Bivector3 other) {
        return times(other.inverse());
    }

    public Multivector3 div(Rotor3 other) {
        return this.times(other.inverse());
    }

    public Bivector3 div(Trivector3 other) {
        return times(other.inverse());
    }

    public Multivector3 div(Multivector3 other) {
        return this.times(other.inverse());
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
            public Basis3<?> next() {
                return switch (actual) {
                    case 1 -> {
                        actual++;
                        yield e1;
                    }
                    case 2 -> {
                        actual++;
                        yield e2;
                    }
                    case 3 -> {
                        actual++;
                        yield e3;
                    }
                    default ->
                            throw new NoSuchElementException("The element " + actual + " does not correspond to any element of vectors in three dimensions");
                };
            }
        };
    }

    @Override
    public String toString() {
        return "(" + e1.value() + ")e1 + " + "(" + e2.value() + ")e2 + " + "(" + e3.value() + ")e3";
    }

    @Override
    public Vector3 reverse() {
        return this;
    }

}
