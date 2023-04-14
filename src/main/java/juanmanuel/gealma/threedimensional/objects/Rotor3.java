package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.threedimensional.basis.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public record Rotor3(E0 e0, E1E2 e1e2, E2E3 e2e3, E3E1 e3e1) implements Geometric3 {
    // Corresponds to the number of basis of the geometric object.
    public static final byte NUMBER_OF_ELEMENTS = 4;

    public static final Rotor3 ZERO = new Rotor3(new E0(0), new E1E2(0), new E2E3(0), new E3E1(0));

    public Rotor3 {
        Objects.requireNonNull(e0);
        Objects.requireNonNull(e1e2);
        Objects.requireNonNull(e2e3);
        Objects.requireNonNull(e3e1);
    }

    public Rotor3(Scalar scalar, Bivector3 bivector3) {
        this(scalar.e0(), bivector3.e1e2(), bivector3.e2e3(), bivector3.e3e1());
    }

    public Rotor3(double scalar, Bivector3 bivector3) {
        this(new E0(scalar), bivector3.e1e2(), bivector3.e2e3(), bivector3.e3e1());
    }

    public static Rotor3 from(Bivector3 plain, double angle) {
        var halfAngle = angle / 2;
        return new Rotor3(Math.cos(halfAngle), plain.normalized().times(Math.sin(halfAngle)));
    }

    public static Rotor3 from(Vector3 axis, double angle) {
        var plain = axis.times(Trivector3.ONE);
        return from(plain, angle);
    }

    @Override
    public String toString() {
        return "(" + e0.value() + ")e0 + " + "(" + e1e2.value() + ")e1e2 + " + "(" + e2e3.value() + ")e2e3 + " + "(" + e3e1.value() + ")e3e1";
    }

    @Override
    public Rotor3 unaryMinus() {
        return new Rotor3(scalar().unaryMinus(), bivector().unaryMinus());
    }

    @Override
    public Rotor3 normalized() {
        return div(magnitude());
    }

    @Override
    public double magnitudeSquared() {
        return e0.times(e0)
                .plus(e1e2.times(e1e2).unaryMinus())
                .plus(e2e3.times(e2e3).unaryMinus())
                .plus(e3e1.times(e3e1).unaryMinus())
                .value();
    }

    @Override
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    public double angle() {
        return 2 * Math.atan2(bivector().magnitude(), e0.value());
    }

//    @Override

    public Rotor3 reverseConjugation() {
        return new Rotor3(e0, e1e2.unaryMinus(), e2e3.unaryMinus(), e3e1.unaryMinus());
    }
//    @Override

    public Rotor3 cliffordConjugation() {
        return new Rotor3(e0, e1e2.unaryMinus(), e2e3.unaryMinus(), e3e1.unaryMinus());
    }

    @Override
    public Rotor3 reciprocal() {
        return new Rotor3(e0, e1e2.unaryMinus(), e2e3.unaryMinus(), e3e1.unaryMinus());
    }

    public Vector3 rotate(Vector3 vector) {
//        return this.times(vector).times(this.reverseConjugation()).vector();
        var rotorVector = times(vector);

        var rotorDagger = reverseConjugation();

        var vec = rotorVector.vector();
        var trivec = rotorVector.trivector();

        return vec.times(rotorDagger).plus(trivec.times(rotorDagger)).vector();
    }

    public Bivector3 rotate(Bivector3 bivector) {
        return this.times(bivector).times(this.reverseConjugation()).bivector();
    }

    public Rotor3 rotate(Rotor3 rotor3) {
        return this.times(rotor3).times(this.reverseConjugation());
    }


    @Override
    public Rotor3 plus(double other) {
        return plus(new Scalar(other));
    }

    @Override
    public Rotor3 plus(Scalar other) {
        return new Rotor3(scalar().plus(other), bivector());
    }

    @Override
    public Multivector3 plus(Vector3 other) {
        return new Multivector3(scalar(), other, bivector(), Trivector3.ZERO);
    }

    @Override
    public Rotor3 plus(Bivector3 other) {
        return new Rotor3(scalar(), bivector().plus(other));
    }

    @Override
    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(scalar().plus(other.scalar()), bivector().plus(other.bivector()));
    }

    @Override
    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(scalar(), Vector3.ZERO, bivector(), other);
    }

    @Override
    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(scalar().plus(other.scalar()), other.vector(), bivector().plus(other.bivector()), other.trivector());
    }

    @Override
    public Geometric3 minus(double other) {
        return null;
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
    public Rotor3 minus(Bivector3 other) {
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
    public Geometric3 inner(double other) {
        return inner(new Scalar(other));
    }

    @Override
    public Rotor3 inner(Scalar other) {
        return new Rotor3(
                e0.times(other.e0()),
                e1e2.times(other.e0()),
                e2e3.times(other.e0()),
                e3e1.times(other.e0())
        );
    }

    /**
     * Does the inner product with a 3 dimensional vector.
     *
     * @param other a 3 dimensional geometric algebra vector.
     * @return a multivector containing a vector and a trivector.
     */
    @Override
    public Multivector3 inner(Vector3 other) {
//        new Vector3(e0.times(other.e1()), e0.times(other.e2()), e0.times(other.e3())); scalar().inner(other)
//        new Trivector3(e1e2.times(other.e3())
//                        .plus(e2e3.times(other.e1()))
//                        .plus(e3e1.times(other.e2()))); bivector().inner(other)
        return scalar().inner(other).plus(bivector().inner(other));
    }

    @Override
    public Rotor3 inner(Bivector3 other) {
        return scalar().inner(other).plus(bivector().inner(other));
    }

    @Override
    public Rotor3 inner(Rotor3 other) {
        return inner(other.scalar()).plus(inner(other.bivector()));
    }

    @Override
    public Geometric3 inner(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 inner(Multivector3 other) {
        return null;
    }

    @Override
    public Geometric3 outer(double other) {
        return null;
    }

    /**
     * Always 0.
     *
     * @param other
     * @return a scalar with value 0.
     */
    @Override
    public Scalar outer(Scalar other) {
        // outer product = 0
        return Scalar.ZERO;
    }

    @Override
    public Vector3 outer(Vector3 other) {
        // scalar outer product = 0
        return bivector().outer(other);
    }

    @Override
    public Rotor3 outer(Bivector3 other) {
        return scalar().outer(other).plus(bivector().outer(other));
    }

    @Override
    public Bivector3 outer(Rotor3 other) {

        return bivector().outer(other.bivector());
    }

    @Override
    public Geometric3 outer(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 outer(Multivector3 other) {
        return null;
    }

    @Override
    public Rotor3 times(double other) {
        return times(new Scalar(other));
    }

    @Override
    public Rotor3 times(Scalar other) {
        return new Rotor3(scalar().times(other), bivector().times(other));
    }

    @Override
    public Multivector3 times(Vector3 other) {
//        return inner(other).plus(outer(other));
        return scalar().times(other).plus(bivector().times(other));
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
    public Geometric3 times(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 times(Multivector3 other) {
        return multivector().times(other);
    }

    @Override
    public Rotor3 div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Rotor3 div(Scalar other) {
        return times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Vector3 other) {
        return times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Bivector3 other) {
        return times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Rotor3 other) {
        return times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Trivector3 other) {
        return times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Multivector3 other) {
        return times(other.reciprocal());
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
                        yield e0;
                    }
                    case 2 -> {
                        actual++;
                        yield e1e2;
                    }
                    case 3 -> {
                        actual++;
                        yield e2e3;
                    }
                    case 4 -> {
                        actual++;
                        yield e3e1;
                    }
                    default ->
                            throw new NoSuchElementException("The element " + actual + " does not correspond to any element of vectors in three dimensions");
                };
            }
        };
    }

    @Override
    public Rotor3 reverse() {
        return new Rotor3(e0, e1e2.unaryMinus(), e2e3.unaryMinus(), e3e1.unaryMinus());
    }
}
