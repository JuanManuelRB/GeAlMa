package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.threedimensional.basis.E1E2;
import juanmanuel.gealma.threedimensional.basis.E2E3;
import juanmanuel.gealma.threedimensional.basis.E3E1;
import juanmanuel.gealma.threedimensional.basis.Geometric3Basis;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public record Bivector3(E1E2 e1e2, E2E3 e2e3, E3E1 e3e1) implements Geometric3 {
    // Corresponds to the number of basis of the geometric object.
    public static final byte NUMBER_OF_ELEMENTS = 3;

    public static final Bivector3 ZERO = new Bivector3(E1E2.ZERO, E2E3.ZERO, E3E1.ZERO);

    public Bivector3 {
        Objects.requireNonNull(e1e2);
        Objects.requireNonNull(e2e3);
        Objects.requireNonNull(e3e1);
    }

    public Bivector3(double e1e2, double e2e3, double e3e1) {
        this(new E1E2(e1e2), new E2E3(e2e3), new E3E1(e3e1));
    }

    @Override
    public Bivector3 unaryMinus() {
        return new Bivector3(e1e2.unaryMinus(), e2e3.unaryMinus(), e3e1.unaryMinus());
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
    public Bivector3 reciprocal() {
        return div(magnitudeSquared());
    }

    @Override
    public Bivector3 normalized() {
        return this.div(this.magnitude());
    }

    public Bivector3 projection(Bivector3 bivector) {
        return bivector.reciprocal().times(this.inner(bivector));
    }

    @Override
    public Rotor3 plus(double other) {
        return plus(new Scalar(other));
    }

    @Override
    public Rotor3 plus(Scalar other) {
        return new Rotor3(other, this);
    }

    @Override
    public Multivector3 plus(Vector3 other) {
        return new Multivector3(Scalar.ZERO, other, this, Trivector3.ZERO);
    }

    @Override
    public Bivector3 plus(Bivector3 other) {
        return new Bivector3(
                e1e2.plus(other.e1e2),
                e2e3.plus(other.e2e3),
                e3e1.plus(other.e3e1)
        );
    }

    @Override
    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(other.scalar(), this.plus(other.bivector()));
    }

    @Override
    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(Scalar.ZERO, Vector3.ZERO, this, other);
    }

    @Override
    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(other.scalar(), other.vector(), this.plus(other.bivector()), other.trivector());
    }

    @Override
    public Rotor3 minus(double other) {
        return minus(new Scalar(other));
    }

    @Override
    public Rotor3 minus(Scalar other) {
        return plus(other.unaryMinus());
    }

    @Override
    public Multivector3 minus(Vector3 other) {
        return plus(other.unaryMinus());
    }

    @Override
    public Bivector3 minus(Bivector3 other) {
        return plus(other.unaryMinus());
    }

    @Override
    public Rotor3 minus(Rotor3 other) {
        return plus(other.unaryMinus());
    }

    @Override
    public Multivector3 minus(Trivector3 other) {
        return plus(other.unaryMinus());
    }

    @Override
    public Multivector3 minus(Multivector3 other) {
        return plus(other.unaryMinus());
    }

    @Override
    public Bivector3 inner(double other) {
        return inner(new Scalar(other));
    }

    @Override
    public Bivector3 inner(Scalar other) {
        return new Bivector3(
                e1e2.times(other.e0()),
                e2e3.times(other.e0()),
                e3e1.times(other.e0())
        );
    }

    @Override
    public Trivector3 inner(Vector3 other) {
        return new Trivector3(e1e2.times(other.e3())
                .plus(e2e3.times(other.e1()))
                .plus(e3e1.times(other.e2()))
        );
    }

    @Override
    public Scalar inner(Bivector3 other) {
        return new Scalar(e1e2.times(other.e1e2).plus(e2e3.times(other.e2e3)).plus(e3e1.times(other.e3e1)));
    }

    @Override
    public Rotor3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public Vector3 inner(Trivector3 other) {
        return new Vector3(
                e2e3.times(other.e1e2e3()),
                e3e1.times(other.e1e2e3()),
                e1e2.times(other.e1e2e3())
        );
    }

    @Override
    public Multivector3 inner(Multivector3 other) {
        return this.inner(other.scalar())
                .plus(this.inner(other.vector()))
                .plus(this.inner(other.bivector()))
                .plus(this.inner(other.trivector()));
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
    public Vector3 outer(Vector3 other) {
        return new Vector3(
                e1e2.times(other.e2()).plus(e3e1.times(other.e3())),
                e2e3.times(other.e3()).plus(e1e2.times(other.e1())),
                e3e1.times(other.e1()).plus(e2e3.times(other.e2()))
        );
    }

    @Override
    public Bivector3 outer(Bivector3 other) {
        return new Bivector3(
                this.e3e1.times(other.e2e3).plus(this.e2e3.times(other.e3e1)),
                this.e1e2.times(other.e3e1).plus(this.e3e1.times(other.e1e2)),
                this.e2e3.times(other.e1e2).plus(this.e1e2.times(other.e2e3))
        );
    }

    @Override
    public Rotor3 outer(Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    @Override
    public Scalar outer(Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public Multivector3 outer(Multivector3 other) {
        return outer(other.scalar())
                .plus(outer(other.vector()))
                .plus(outer(other.bivector()))
                .plus(outer(other.trivector()));
    }

    @Override
    public Bivector3 times(double other) {
        return times(new Scalar(other));
    }

    @Override
    public Bivector3 times(Scalar other) {
        // outer product = 0
        return inner(other);
    }

    @Override
    public Multivector3 times(Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Rotor3 times(Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Rotor3 times(Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Vector3 times(Trivector3 other) {
        // outer product = 0
        return this.inner(other);
    }

    @Override
    public Multivector3 times(Multivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Bivector3 div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Bivector3 div(Scalar other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Multivector3 div(Vector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Rotor3 div(Bivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Rotor3 div(Rotor3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Vector3 div(Trivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Multivector3 div(Multivector3 other) {
        return this.times(other.reciprocal());
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
                return switch (actual) {
                    case 1 -> {
                        actual++;
                        yield e1e2;
                    }
                    case 2 -> {
                        actual++;
                        yield e2e3;
                    }
                    case 3 -> {
                        actual++;
                        yield e3e1;
                    }
                    default ->
                            throw new NoSuchElementException("The element " + actual + " does not correspond to any element of bivectors in three dimensions");
                };
            }
        };
    }

    @Override
    public String toString() {
        return "(" + e1e2.value() + ")e1e2 + " + "(" + e2e3.value() + ")e2e3 + " + "(" + e3e1.value() + ")e3e1";
    }

    @Override
    public Bivector3 reverse() {
        return unaryMinus();
    }
}
