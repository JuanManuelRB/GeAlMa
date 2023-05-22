package juanmanuel.gealma.twodimensional;

import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.VectorSpecies;
import juanmanuel.gealma.Geometric;
import juanmanuel.gealma.Scalar;
import juanmanuel.gealma.basis.*;
import juanmanuel.gealma.operations.*;
import juanmanuel.gealma.threedimensional.Bivector3;
import juanmanuel.gealma.threedimensional.Rotor3;
import juanmanuel.gealma.threedimensional.Trivector3;
import juanmanuel.gealma.threedimensional.Vector3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This interface represents a vanilla geometric algebra object in 3 dimensions.
 * <p>
 *     In Vanilla Geometric Algebra, a geometric object is represented by a multivector, which is a sum of scalar, vector, bivector and trivector parts.
 * </p>
 *
 * <p>
 *     The scalar is represented by the {@link Scalar} class, the vector by the {@link Vector3} class, the bivector by the {@link Bivector3} class and the trivector by the {@link Trivector3} class.
 * </p>
 *
 * <p>
 *     Additionally, a rotor which is a geometric object that represents a rotation is represented by the {@link Rotor3} class.
 * </p>
 */
public sealed interface Geometric2<T extends Geometric2<T>>
        extends Iterable<Basis3<?>>, Addition<T>, Subtraction<T>, Reversion<T>, Normalization<T>,
        InnerProduct<T>, OuterProduct<T>, Product<T>, Division<T>, Geometric<T>
        permits Bivector2, Multivector2, Rotor2, Vector2 {

    // Corresponds to the number of basis of the geometric object.
    byte NUMBER_OF_ELEMENTS = 4;
    VectorSpecies<Double> vectorSpecies = DoubleVector.SPECIES_128;
    byte VECTOR_SIZE = 2;

    /**
     * @return the basis e0.
     */
    default E0 e0() {
        return E0.ZERO;
    }

    /**
     * @return the basis e1.
     */
    default E1 e1() {
        return E1.ZERO;
    }

    /**
     * @return the basis e2.
     */
    default E2 e2() {
        return E2.ZERO;
    }

    /**
     * @return the basis e1e2.
     */
    default E1E2 e1e2() {
        return E1E2.ZERO;
    }

    /**
     * @return the scalar part of the object.
     */
    default Scalar scalar() {
        return new Scalar(this.e0());
    }

    /**
     * @return the vector part of the object.
     */
    default Vector2 vector() {
        return new Vector2(this.e1(), this.e2());
    }

    /**
     * @return the bivector part of the object.
     */
    default Bivector2 bivector() {
        return new Bivector2(this.e1e2());
    }

    /**
     * @return the multivector composed of the scalar, vector, bivector and trivector of the object.
     */
    default Multivector2 multivector() {
        return new Multivector2(e0(), e1(), e2(), e1e2());
    }


    /**
     * @return the imaginary subspace of the object.
     */
    default Geometric2<?> imaginarySubspace() {
        return bivector().plus(bivector());
    }

    /**
     * @return a Rotor composed of the scalar and bivector of the element.
     */
    default Rotor2 toRotor() {
        return bivector().plus(scalar()).normalized();
    }

    /**
     * @return the magnitude squared of the object.
     */
    double magnitudeSquared();

    /**
     * @return the magnitude of the object.
     */
    double magnitude();

    default Geometric2<?> plus(Geometric2<?> other) {
        return multivector().plus(other.multivector());
    }

    default Geometric2<?> minus(Geometric2<?> other) {
        return multivector().minus(other.multivector());
    }

    /**
     * The geometric product of two geometric objects. The geometric product is the distributive product of each basis with each other basis.
     *
     * @param other the other object to be multiplied.
     * @return the geometric product of the object and the other object.
     */
    default Geometric2<?> times(Geometric2<?> other) {
//        var thisMultivector = multivector();
//        var otherMultivector = other.multivector();
//        return thisMultivector.times(otherMultivector);
        return multivector().times(other.multivector());
    }

    default Geometric2<?> inner(Geometric2<?> other) {
        return multivector().inner(other.multivector());
    }

    default Geometric2<?> outer(Geometric2<?> other) {
        return multivector().outer(other.multivector());
    }

    @Override
    default Iterator<Basis3<?>> iterator() {
        return new Iterator<>() {
            private byte actual = 0;

            @Override
            public boolean hasNext() {
                return actual <= NUMBER_OF_ELEMENTS;
            }

            @Override
            public Basis3<?> next() {
                return switch (actual) {
                    case 0 -> {
                        actual++;
                        yield e0();
                    }
                    case 1 -> {
                        actual++;
                        yield e1();
                    }
                    case 2 -> {
                        actual++;
                        yield e2();
                    }
                    case 3 -> {
                        actual++;
                        yield e1e2();
                    }
                    default ->
                            throw new NoSuchElementException("The element " + actual + " does not correspond to any element of geometric algebra in three dimensions");
                };
            }
        };
    }

//    default Geometric3 inner(Geometric3 other) {
//        return scalar().inner()
//    }
//
//    default Geometric3 outer(Geometric3 other) {
//        return new Multivector3(
//                scalar().minus(other.scalar()),
//                vector().minus(other.vector()),
//                bivector().minus(other.bivector()),
//                trivector().minus(other.trivector())
//        );
//    }
//
//    default Geometric3 times(Geometric3 other) {
//        return this.inner(other).plus(this.outer(other));
//    }
}
