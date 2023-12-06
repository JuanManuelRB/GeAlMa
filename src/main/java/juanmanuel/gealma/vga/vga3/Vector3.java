package juanmanuel.gealma.vga.vga3;

import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;
import juanmanuel.gealma.vga.Scalar;
import juanmanuel.gealma.vga.basis.Basis3;
import juanmanuel.gealma.vga.basis.vga.E1;
import juanmanuel.gealma.vga.basis.vga.E2;
import juanmanuel.gealma.vga.basis.vga.E3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class represents a vector in three-dimensional vector geometric algebra.
 * <p>
 *     The vector is a sum of the basis vectors e1, e2 and e3.
 *     For example, the vector (1e1 + 2e2 + 3e3) is represented by the {@code Vector3} object {@code new Vector3(1, 2, 3)}.
 * </p>
 * <p>
 *     The vector (0e1 + 0e2 + 0e3) is represented by the {@code Vector3} object {@code Vector3.ZERO}.
 * </p>
 * <p>
 *     The vector (1e1 + 1e2 + 1e3) is represented by the {@code Vector3} object {@code Vector3.ONE}.
 * </p>
 */
public record Vector3(@Override E1 e1, @Override E2 e2, @Override E3 e3) implements Geometric3<Vector3> {
    // Corresponds to the number of basis of the geometric object.
    public static final byte NUMBER_OF_ELEMENTS = 3;
    public static final Vector3 ZERO = new Vector3();
    public static final Vector3 ONE = new Vector3(1, 1, 1);
    private static final VectorSpecies<Double> vectorSpecies = DoubleVector.SPECIES_PREFERRED;

    public Vector3 {
        Objects.requireNonNull(e1);
        Objects.requireNonNull(e2);
        Objects.requireNonNull(e3);
    }

    public Vector3() {
        this(E1.ZERO, E2.ZERO, E3.ZERO);
    }

    public Vector3(double e1, double e2, double e3) {
        this(new E1(e1), new E2(e2), new E3(e3));
    }

    /**
     * Returns the negation of this vector.
     * The negation of a vector is a vector with the same magnitude but opposite direction.
     * For example, the negation of the vector (1e1 + 2e2 + 3e3) is (-1e1 - 2e2 - 3e3).
     * @return the negation of this vector.
     */
    @Override
    public Vector3 unaryMinus() {
        return new Vector3(e1.unaryMinus(), e2.unaryMinus(), e3.unaryMinus());
    }

    @Override
    public Vector3 reverse() {
        return this;
    }

    @Override
    public Vector3 inverse() {
        return div(magnitudeSquared());
    }

    @Override
    public Vector3 normalized() {
        return this.div(this.magnitude());
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
    public Vector3 plus(Vector3 other) {
        double[] resultArray = new double[Geometric3.vectorSpecies.length()];
        this.toVector().add(other.toVector()).intoArray(resultArray, 0);

        return new Vector3(resultArray[0], resultArray[1], resultArray[2]);
    }

    @Override
    public Vector3 minus(Vector3 other) {
        double[] resultArray = new double[Geometric3.vectorSpecies.length()];
        this.toVector().sub(other.toVector()).intoArray(resultArray, 0);
        return new Vector3(resultArray[0], resultArray[1], resultArray[2]);
    }

    @Override
    public Vector3 inner(double other) {
        return this.times(other);
    }

    @Override
    public Vector3 inner(Scalar other) {
        return this.times(other);
    }

    @Override
    public Scalar inner(Vector3 other) {
        return new Scalar(this.toVector().mul(other.toVector()).reduceLanes(VectorOperators.ADD));
    }

    @Override
    public Vector3 outer(double other) {
        return this.times(other);
    }

    @Override
    public Vector3 outer(Scalar other) {
        return this.times(other);
    }

    @Override
    public Bivector3 outer(Vector3 other) {
        double[] result = new double[Geometric3.vectorSpecies.length()];

        var vt_1 = this.toVector();
        var vo_1 = vectorFrom(other.e2, other.e3, other.e1);
        var vo_2 = other.toVector();
        var vt_2 = vectorFrom(this.e2, this.e3, this.e1);

        vt_1.mul(vo_1).sub(vt_2.mul(vo_2)).intoArray(result, 0);

        return new Bivector3(result[0], result[1], result[2]);
    }

    @Override
    public Vector3 times(double other) {
        double[] result = new double[Geometric3.vectorSpecies.length()];
        toVector().mul(other).intoArray(result, 0);
        return new Vector3(result[0], result[1], result[2]);
    }

    @Override
    public Vector3 times(Scalar other) {
        return this.times(other.value());
    }

    @Override
    public Rotor3 times(Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    public double x() {
        return e1.value();
    }

    public double y() {
        return e2.value();
    }

    public double z() {
        return e3.value();
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

    public double angleWith(Vector3 other) {
        return this.normalized().inner(other.normalized()).value();
    }

    /**
     * Returns an array of doubles with the values of the vector's basis. The order of the basis is the same as the order
     * of the basis in the {@link Basis3}.
     */
    public double[] toArray() {
        return new double[]{this.e1.value(), this.e2.value(), this.e3.value()};
    }

    public DoubleVector toVector() {
        return vectorFrom(e1, e2, e3);
    }

    private static DoubleVector vectorFrom(Basis3<?> b1, Basis3<?> b2, Basis3<?> b3) {
        return DoubleVector.fromArray(
                vectorSpecies,
                new double[]{b1.value(), b2.value(), b3.value(), 0},
                0
        );
    }

    public Multivector3 plus(double other) {
        return plus(new Scalar(other));
    }

    public Multivector3 plus(Scalar other) {
        return new Multivector3(other, this, Bivector3.ZERO, Trivector3.ZERO);
    }


    public Multivector3 plus(Bivector3 other) {
        return new Multivector3(Scalar.zero, this, other, Trivector3.ZERO);
    }

    public Multivector3 plus(Rotor3 other) {
        return new Multivector3(other.scalar(), this, other.bivector(), Trivector3.ZERO);
    }

    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(Scalar.zero, this, Bivector3.ZERO, other);
    }

    public Multivector3 plus(Multivector3 other) {
        double[] resultArray = new double[4];
        this.toVector().add(other.vector().toVector()).intoArray(resultArray, 0);

        return new Multivector3(
                other.e0(),
                new E1(resultArray[0]),
                new E2(resultArray[1]),
                new E3(resultArray[2]),
                other.e1e2(),
                other.e2e3(),
                other.e3e1(),
                other.e1e2e3()
        );
    }

    public Multivector3 minus(double other) {
        return this.plus(-other);
    }

    public Multivector3 minus(Scalar other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Bivector3 other) {
        return new Multivector3(Scalar.zero, this, other, Trivector3.ZERO);
    }

    public Multivector3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Trivector3 other) {
        return new Multivector3(Scalar.zero, this, Bivector3.ZERO, other);
    }

    public Multivector3 minus(Multivector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Vector3 inner(Bivector3 other) {
        var vv = DoubleVector.fromArray(
                DoubleVector.SPECIES_512,
                new double[]{e1.value(), e2.value(), e3.value(), e2.unaryMinus().value(), e3.unaryMinus().value(), e1.unaryMinus().value(), 0, 0},
                0
        );
        var vb = DoubleVector.fromArray(
                DoubleVector.SPECIES_512,
                new double[]{other.e1e2().value(), other.e2e3().value(), other.e3e1().value(), other.e1e2().value(), other.e2e3().value(), other.e3e1().value(), 0, 0},
                0
        );
        double[] arr = new double[8];
        vv.mul(vb).intoArray(arr, 0);

        var v1 = DoubleVector.fromArray(vectorSpecies, new double[]{arr[2], arr[0], arr[1], 0}, 0);
        var v2 = DoubleVector.fromArray(vectorSpecies, arr, 3);
        double[] resultArray = new double[Geometric3.vectorSpecies.length()];
        v1.add(v2).intoArray(resultArray, 0);
        return new Vector3(resultArray[0], resultArray[1], resultArray[2]);


//        return new Vector3(
//                e3.times(other.e3e1()).plus(e2.times(other.e1e2())),
//                e1.times(other.e1e2()).plus(e3.times(other.e2e3())),
//                e2.times(other.e2e3()).plus(e1.times(other.e3e1()))
//        );
    }

    public Vector3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    public Bivector3 inner(Trivector3 other) {
        var result = new double[Geometric3.vectorSpecies.length()];
        toVector().mul(other.volume()).intoArray(result, 0);
        return new Bivector3(result[0], result[1], result[2]);

//        return new Bivector3(
//                e3.times(other.e1e2e3()),
//                e1.times(other.e1e2e3()),
//                e2.times(other.e1e2e3())
//        );
    }

    public Multivector3 inner(Multivector3 other) {
        return inner(other.scalar())
                .plus(inner(other.vector()))
                .plus(inner(other.bivector()))
                .plus(inner(other.trivector()));
    }

    public Trivector3 outer(Bivector3 other) {
        var vv = toVector();
        var vb = vectorFrom(other.e2e3(), other.e3e1(), other.e1e2());
        return new Trivector3(vv.mul(vb).reduceLanes(VectorOperators.ADD));

//        return new Trivector3(this.e1.times(other.e2e3())
//                .plus(this.e2.times(other.e3e1()))
//                .plus(this.e3.times(other.e1e2()))
//        );
    }

    public Multivector3 outer(Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    public Scalar outer(Trivector3 other) {
        return Scalar.zero;
    }

    public Multivector3 outer(Multivector3 other) {
        return this.outer(other.scalar())
                .plus(this.outer(other.vector()))
                .plus(this.outer(other.bivector()))
                .plus(this.outer(other.trivector()));
    }

    public Multivector3 times(Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    public Multivector3 times(Rotor3 other) {
        return this.times(other.scalar()).plus(this.times(other.bivector()));
    }

    public Bivector3 times(Trivector3 other) {
        // outer product = 0
        return this.inner(other);
    }

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

}
