package juanmanuel.gealma.vga.vga2;

import jdk.incubator.vector.DoubleVector;
import jdk.incubator.vector.VectorOperators;
import juanmanuel.gealma.operations.Division;
import juanmanuel.gealma.vga.Scalar;
import juanmanuel.gealma.vga.basis.Basis2;
import juanmanuel.gealma.vga.basis.vga.E1;
import juanmanuel.gealma.vga.basis.vga.E2;

import java.util.Objects;

public record Vector2(E1 e1, E2 e2) implements Geometric2<Vector2> {
    public final static Vector2 ZERO = new Vector2(0, 0);
    public final static Vector2 ONE = new Vector2(1, 1);

    public Vector2 {
        Objects.requireNonNull(e1);
        Objects.requireNonNull(e2);
    }

    public Vector2(double e1, double e2) {
        this(new E1(e1), new E2(e2));
    }

    private DoubleVector toVector() {
        return vectorFrom(e1, e2);
    }

    private static DoubleVector vectorFrom(Basis2<?> b1, Basis2<?> b2) {
        return DoubleVector.fromArray(
                vectorSpecies,
                new double[]{b1.value(), b2.value()},
                0
        );
    }

    @Override
    public Vector2 plus(Vector2 other) {
        return new Vector2(e1.plus(other.e1()), e2.plus(other.e2()));
    }

    @Override
    public Vector2 unaryMinus() {
        return new Vector2(-e1.value(), -e2.value());
    }

    @Override
    public Vector2 minus(Vector2 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Vector2 inner(double other) {
        return this.times(other);
    }

    @Override
    public Vector2 inner(Scalar other) {
        return this.times(other);
    }

    @Override
    public Scalar inner(Vector2 other) {
        return new Scalar(this.toVector().mul(other.toVector()).reduceLanes(VectorOperators.ADD));
    }

    @Override
    public Vector2 outer(double other) {
        return this.times(other);
    }

    @Override
    public Vector2 outer(Scalar other) {
        return this.times(other);
    }

    @Override
    public Bivector2 outer(Vector2 other) {
        double[] result = new double[VECTOR_SIZE];

        var vt = this.toVector();
        var vo = vectorFrom(other.e2, other.e1.unaryMinus());

        return new Bivector2(vt.mul(vo).reduceLanes(VectorOperators.ADD));
    }

    @Override
    public Rotor2 times(Vector2 other) {
        return null;
    }

    @Override
    public Vector2 times(double other) {
        return null;
    }

    @Override
    public Vector2 times(Scalar other) {
        return null;
    }

    @Override
    public Vector2 inverse() {
        return null;
    }

    @Override
    public Division<?> div(Vector2 other) throws ArithmeticException {
        return null;
    }

    @Override
    public Division<?> div(double other) {
        return null;
    }

    @Override
    public Division<?> div(Scalar other) {
        return null;
    }

    @Override
    public Vector2 normalized() {
        return null;
    }

    @Override
    public Vector2 reverse() {
        return null;
    }

    @Override
    public double magnitudeSquared() {
        return 0;
    }

    @Override
    public double magnitude() {
        return 0;
    }
}
