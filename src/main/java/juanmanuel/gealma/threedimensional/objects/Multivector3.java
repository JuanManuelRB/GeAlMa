package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.threedimensional.basis.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public record Multivector3(E0 e0, E1 e1, E2 e2, E3 e3, E1E2 e1e2, E2E3 e2e3, E3E1 e3e1,
                           E1E2E3 e1e2e3) implements Geometric3 {

    public static final Multivector3 ZERO = new Multivector3(Scalar.ZERO, Vector3.ZERO, Bivector3.ZERO, Trivector3.ZERO);

    public Multivector3 {
        Objects.requireNonNull(e0);
        Objects.requireNonNull(e1);
        Objects.requireNonNull(e2);
        Objects.requireNonNull(e3);
        Objects.requireNonNull(e1e2);
        Objects.requireNonNull(e2e3);
        Objects.requireNonNull(e3e1);
        Objects.requireNonNull(e1e2e3);
    }

    public Multivector3(Scalar scalar, Vector3 vector3, Bivector3 bivector3, Trivector3 trivector3) {
        this(
                scalar.e0(),
                vector3.e1(),
                vector3.e2(),
                vector3.e3(),
                bivector3.e1e2(),
                bivector3.e2e3(),
                bivector3.e3e1(),
                trivector3.e1e2e3()
        );
    }

    public Multivector3(double e0, double e1, double e2, double e3, double e1e2, double e2e3, double e3e1, double e1e2e3) {
        this(
                new E0(e0),
                new E1(e1),
                new E2(e2),
                new E3(e3),
                new E1E2(e1e2),
                new E2E3(e2e3),
                new E3E1(e3e1),
                new E1E2E3(e1e2e3)
        );
    }

    /**
     * @return the normalized value of the multivector.
     */
    @Override
    public Geometric3 normalized() {
        return this.div(this.magnitude());
    }


    @Override
    public double magnitudeSquared() {
        return this.times(this.reverse()).e0().value();
    }

    @Override
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }


    @Override
    public Multivector3 unaryMinus() {
        return new Multivector3(scalar().unaryMinus(), vector().unaryMinus(), bivector().unaryMinus(), trivector().unaryMinus());
    }

    @Override
    public Multivector3 reciprocal() {
        return this.div(this.magnitude());
    }

    @Override
    public Multivector3 plus(double other) {
        return new Multivector3(e0.plus(new E0(other)), e1, e2, e3, e1e2, e2e3, e3e1, e1e2e3);
    }

    @Override
    public Multivector3 plus(Scalar other) {
        return new Multivector3(e0.plus(other.e0()), e1, e2, e3, e1e2, e2e3, e3e1, e1e2e3);
    }

    @Override
    public Multivector3 plus(Vector3 other) {
        return new Multivector3(e0, e1.plus(other.e1()), e2.plus(other.e2()), e3.plus(other.e3()), e1e2, e2e3, e3e1, e1e2e3);
    }

    @Override
    public Multivector3 plus(Bivector3 other) {
        return new Multivector3(e0, e1, e2, e3, e1e2.plus(other.e1e2()), e2e3.plus(other.e2e3()), e3e1.plus(other.e3e1()), e1e2e3);
    }

    @Override
    public Multivector3 plus(Rotor3 other) {
        return new Multivector3(
                scalar().plus(other.scalar()),
                vector(),
                bivector().plus(other.bivector()),
                trivector()
        );
    }

    @Override
    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(e0, e1, e2, e3, e1e2, e2e3, e3e1, e1e2e3.plus(other.e1e2e3()));
    }

    @Override
    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(
                e0.plus(other.e0),
                e1.plus(other.e1),
                e2.plus(other.e2),
                e3.plus(other.e3),
                e1e2.plus(other.e1e2),
                e2e3.plus(other.e2e3),
                e3e1.plus(other.e3e1),
                e1e2e3.plus(other.e1e2e3)
        );
    }

    @Override
    public Multivector3 minus(double other) {
        return minus(new Scalar(other));
    }

    @Override
    public Multivector3 minus(Scalar other) {
        return new Multivector3(e0.plus(other.e0().unaryMinus()), e1, e2, e3, e1e2, e2e3, e3e1, e1e2e3);
    }

    @Override
    public Multivector3 minus(Vector3 other) {
        return new Multivector3(
                e0,
                e1.plus(other.e1().unaryMinus()),
                e2.plus(other.e2().unaryMinus()),
                e3.plus(other.e3().unaryMinus()),
                e1e2,
                e2e3,
                e3e1,
                e1e2e3
        );
    }

    @Override
    public Multivector3 minus(Bivector3 other) {
        return new Multivector3(
                e0,
                e1,
                e2,
                e3,
                e1e2.plus(other.e1e2().unaryMinus()),
                e2e3.plus(other.e2e3().unaryMinus()),
                e3e1.plus(other.e3e1().unaryMinus()),
                e1e2e3
        );
    }

    @Override
    public Multivector3 minus(Rotor3 other) {
        return new Multivector3(
                e0.plus(other.e0().unaryMinus()),
                e1,
                e2,
                e3,
                e1e2.plus(other.e1e2().unaryMinus()),
                e2e3.plus(other.e2e3().unaryMinus()),
                e3e1.plus(other.e3e1().unaryMinus()),
                e1e2e3
        );
    }

    @Override
    public Multivector3 minus(Trivector3 other) {
        return new Multivector3(e0, e1, e2, e3, e1e2, e2e3, e3e1, e1e2e3.plus(other.e1e2e3().unaryMinus()));
    }

    @Override
    public Multivector3 minus(Multivector3 other) {
        return new Multivector3(
                e0.plus(other.e0.unaryMinus()),
                e1.plus(other.e1.unaryMinus()),
                e2.plus(other.e2.unaryMinus()),
                e3.plus(other.e3.unaryMinus()),
                e1e2.plus(other.e1e2.unaryMinus()),
                e2e3.plus(other.e2e3.unaryMinus()),
                e3e1.plus(other.e3e1.unaryMinus()),
                e1e2e3.plus(other.e1e2e3.unaryMinus())
        );
    }

    @Override
    public Geometric3 inner(double other) {
        return this.inner(new Scalar(other));
    }

    @Override
    public Geometric3 inner(Scalar other) {
        return this.times(other).plus(other.times(this)).div(2);

    }

    @Override
    public Geometric3 inner(Vector3 other) {
        return this.times(other).plus(other.times(this)).div(2);

    }

    @Override
    public Geometric3 inner(Bivector3 other) {
        return this.times(other).plus(other.times(this)).div(2);

    }

    @Override
    public Geometric3 inner(Rotor3 other) {
        return this.times(other).plus(other.times(this)).div(2);
    }

    @Override
    public Geometric3 inner(Trivector3 other) {
        return this.times(other).plus(other.times(this)).div(2);

    }

    @Override
    public Geometric3 inner(Multivector3 other) {
        return this.times(other).plus(other.times(this)).div(2);
    }

    @Override
    public Geometric3 outer(double other) {
        return this.outer(new Scalar(other));

    }

    @Override
    public Geometric3 outer(Scalar other) {
        return this.times(other).minus(other.times(this)).div(2);
    }

    @Override
    public Geometric3 outer(Vector3 other) {
        return this.times(other).minus(other.times(this)).div(2);
    }

    @Override
    public Geometric3 outer(Bivector3 other) {
        return this.times(other).minus(other.times(this)).div(2);
    }

    @Override
    public Geometric3 outer(Rotor3 other) {
        return this.times(other).minus(other.times(this)).div(2);
    }

    @Override
    public Geometric3 outer(Trivector3 other) {
        return this.times(other).minus(other.times(this)).div(2);
    }

    @Override
    public Multivector3 outer(Multivector3 other) {
        return this.times(other).minus(other.times(this)).div(2);
    }

    @Override
    public Multivector3 times(double other) {
        return null;
    }

    @Override
    public Geometric3 times(Scalar other) {
        return null;
    }

    @Override
    public Geometric3 times(Vector3 other) {
        return null;
    }

    @Override
    public Geometric3 times(Bivector3 other) {
        return null;
    }

    @Override
    public Multivector3 times(Rotor3 other) {
        return null;
    }

    @Override
    public Geometric3 times(Trivector3 other) {
        return null;
    }

    /**
     * The geometric product of two Multivector. The geometric product is the distributive product of each basis with each other basis.
     *
     * @param other the other object to be multiplied.
     * @return the geometric product of the object and the other object.
     */
    @Override
    public Multivector3 times(Multivector3 other) {
        // TODO: Consider using a lookup table for the geometric product? Clean this up.

        // e0 * Other
        E0 thisE0otherE0 = e0.times(other.e0());
        E1 thisE0otherE1 = e0.times(other.e1());
        E2 thisE0otherE2 = e0.times(other.e2());
        E3 thisE0otherE3 = e0.times(other.e3());
        E1E2 thisE0otherE1E2 = e0.times(other.e1e2());
        E2E3 thisE0otherE2E3 = e0.times(other.e2e3());
        E3E1 thisE0otherE3E1 = e0.times(other.e3e1());
        E1E2E3 thisE0otherE1E2E3 = e0.times(other.e1e2e3());

        // e1 * Other
        E1 thisE1otherE0 = e1.times(other.e0());
        E0 thisE1otherE1 = e1.times(other.e1());
        E1E2 thisE1otherE2 = e1.times(other.e2());
        E3E1 thisE1otherE3 = e1.times(other.e3());
        E2 thisE1otherE1E2 = e1.times(other.e1e2());
        E1E2E3 thisE1otherE2E3 = e1.times(other.e2e3());
        E3 thisE1otherE3E1 = e1.times(other.e3e1());
        E2E3 thisE1otherE1E2E3 = e1.times(other.e1e2e3());

        // e2 * Other
        E2 thisE2otherE0 = e2.times(other.e0());
        E1E2 thisE2otherE1 = e2.times(other.e1());
        E0 thisE2otherE2 = e2.times(other.e2());
        E2E3 thisE2otherE3 = e2.times(other.e3());
        E1 thisE2otherE1E2 = e2.times(other.e1e2());
        E3 thisE2otherE2E3 = e2.times(other.e2e3());
        E1E2E3 thisE2otherE3E1 = e2.times(other.e3e1());
        E3E1 thisE2otherE1E2E3 = e2.times(other.e1e2e3());

        // e3 * Other
        E3 thisE3otherE0 = e3.times(other.e0());
        E3E1 thisE3otherE1 = e3.times(other.e1());
        E2E3 thisE3otherE2 = e3.times(other.e2());
        E0 thisE3otherE3 = e3.times(other.e3());
        E1E2E3 thisE3otherE1E2 = e3.times(other.e1e2());
        E2 thisE3otherE2E3 = e3.times(other.e2e3());
        E1 thisE3otherE3E1 = e3.times(other.e3e1());
        E1E2 thisE3otherE1E2E3 = e3.times(other.e1e2e3());

        // e1e2 * Other
        E1E2 thisE1E2otherE0 = e1e2.times(other.e0());
        E2 thisE1E2otherE1 = e1e2.times(other.e1());
        E1 thisE1E2otherE2 = e1e2.times(other.e2());
        E1E2E3 thisE1E2otherE3 = e1e2.times(other.e3());
        E0 thisE1E2otherE1E2 = e1e2.times(other.e1e2());
        E3E1 thisE1E2otherE2E3 = e1e2.times(other.e2e3());
        E2E3 thisE1E2otherE3E1 = e1e2.times(other.e3e1());
        E3 thisE1E2otherE1E2E3 = e1e2.times(other.e1e2e3());

        // e2e3 * Other
        E2E3 thisE2E3otherE0 = e2e3.times(other.e0());
        E1E2E3 thisE2E3otherE1 = e2e3.times(other.e1());
        E3 thisE2E3otherE2 = e2e3.times(other.e2());
        E2 thisE2E3otherE3 = e2e3.times(other.e3());
        E3E1 thisE2E3otherE1E2 = e2e3.times(other.e1e2());
        E0 thisE2E3otherE2E3 = e2e3.times(other.e2e3());
        E1E2 thisE2E3otherE3E1 = e2e3.times(other.e3e1());
        E1 thisE2E3otherE1E2E3 = e2e3.times(other.e1e2e3());

        // e3e1 * Other
        E3E1 thisE3E1otherE0 = e3e1.times(other.e0());
        E3 thisE3E1otherE1 = e3e1.times(other.e1());
        E1E2E3 thisE3E1otherE2 = e3e1.times(other.e2());
        E1 thisE3E1otherE3 = e3e1.times(other.e3());
        E2E3 thisE3E1otherE1E2 = e3e1.times(other.e1e2());
        E1E2 thisE3E1otherE2E3 = e3e1.times(other.e2e3());
        E0 thisE3E1otherE3E1 = e3e1.times(other.e3e1());
        E2 thisE3E1otherE1E2E3 = e3e1.times(other.e1e2e3());

        // e1e2e3 * Other
        E1E2E3 thisE1E2E3otherE0 = e1e2e3.times(other.e0());
        E2E3 thisE1E2E3otherE1 = e1e2e3.times(other.e1());
        E3E1 thisE1E2E3otherE2 = e1e2e3.times(other.e2());
        E1E2 thisE1E2E3otherE3 = e1e2e3.times(other.e3());
        E3 thisE1E2E3otherE1E2 = e1e2e3.times(other.e1e2());
        E1 thisE1E2E3otherE2E3 = e1e2e3.times(other.e2e3());
        E2 thisE1E2E3otherE3E1 = e1e2e3.times(other.e3e1());
        E0 thisE1E2E3otherE1E2E3 = e1e2e3.times(other.e1e2e3());

        E0 sumE0 = thisE0otherE0.plus(thisE1otherE1).plus(thisE2otherE2).plus(thisE3otherE3).plus(thisE1E2otherE1E2).plus(thisE2E3otherE2E3).plus(thisE3E1otherE3E1).plus(thisE1E2E3otherE1E2E3);
        E1 sumE1 = thisE0otherE1.plus(thisE1otherE0).plus(thisE2otherE1E2).plus(thisE3otherE3E1).plus(thisE1E2otherE2).plus(thisE2E3otherE1E2E3).plus(thisE3E1otherE3).plus(thisE1E2E3otherE2E3);
        E2 sumE2 = thisE0otherE2.plus(thisE1otherE1E2).plus(thisE2otherE0).plus(thisE3otherE2E3).plus(thisE1E2otherE1).plus(thisE2E3otherE3).plus(thisE3E1otherE1E2E3).plus(thisE1E2E3otherE3E1);
        E3 sumE3 = thisE0otherE3.plus(thisE1otherE3E1).plus(thisE2otherE2E3).plus(thisE3otherE0).plus(thisE1E2otherE1E2E3).plus(thisE2E3otherE2).plus(thisE3E1otherE1).plus(thisE1E2E3otherE1E2);
        E1E2 sumE1E2 = thisE0otherE1E2.plus(thisE1otherE2).plus(thisE2otherE1).plus(thisE3otherE1E2E3).plus(thisE1E2otherE0).plus(thisE2E3otherE3E1).plus(thisE3E1otherE2E3).plus(thisE1E2E3otherE3);
        E2E3 sumE2E3 = thisE0otherE2E3.plus(thisE1otherE1E2E3).plus(thisE2otherE3).plus(thisE3otherE2).plus(thisE1E2otherE3E1).plus(thisE2E3otherE0).plus(thisE3E1otherE1E2).plus(thisE1E2E3otherE1);
        E3E1 sumE3E1 = thisE0otherE3E1.plus(thisE1otherE3).plus(thisE2otherE1E2E3).plus(thisE3otherE1).plus(thisE1E2otherE2E3).plus(thisE2E3otherE1E2).plus(thisE3E1otherE0).plus(thisE1E2E3otherE2);
        E1E2E3 sumE1E2E3 = thisE0otherE1E2E3.plus(thisE1otherE2E3).plus(thisE2otherE3E1).plus(thisE3otherE1E2).plus(thisE1E2otherE3).plus(thisE2E3otherE1).plus(thisE3E1otherE2).plus(thisE1E2E3otherE0);

        return new Multivector3(sumE0, sumE1, sumE2, sumE3, sumE1E2, sumE2E3, sumE3E1, sumE1E2E3);
    }

    @Override
    public Multivector3 div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Multivector3 div(Scalar other) {
        var otherInv = other.reciprocal().e0();
        return new Multivector3(
                e0.times(otherInv),
                e1.times(otherInv),
                e2.times(otherInv),
                e3.times(otherInv),
                e1e2.times(otherInv),
                e2e3.times(otherInv),
                e3e1.times(otherInv),
                e1e2e3.times(otherInv)
        );
    }

    @Override
    public Geometric3 div(Vector3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Bivector3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Rotor3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Multivector3 other) {
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
                return switch (actual++) {
                    case 1 -> e0;
                    case 2 -> e1;
                    case 3 -> e2;
                    case 4 -> e3;
                    case 5 -> e1e2;
                    case 6 -> e2e3;
                    case 7 -> e3e1;
                    case 8 -> e1e2e3;
                    default ->
                            throw new NoSuchElementException("The element " + actual + " does not correspond to any element of multivectors in three dimensions");
                };
            }
        };
    }

    @Override
    public Multivector3 reverse() {
        return new Multivector3(e0, e1, e2, e3, e1e2.unaryMinus(), e2e3.unaryMinus(), e3e1.unaryMinus(), e1e2e3.unaryMinus());
    }
}
