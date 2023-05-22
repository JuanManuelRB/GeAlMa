package juanmanuel.gealma.twodimensional;

import juanmanuel.gealma.Scalar;
import juanmanuel.gealma.basis.E0;
import juanmanuel.gealma.basis.E1E2;
import juanmanuel.gealma.operations.Division;
import juanmanuel.gealma.operations.InnerProduct;
import juanmanuel.gealma.operations.OuterProduct;
import juanmanuel.gealma.operations.Product;

public record Rotor2(E0 e0, E1E2 e1e2) implements Geometric2<Rotor2>{
    @Override
    public Rotor2 plus(Rotor2 other) {
        return null;
    }

    @Override
    public Rotor2 unaryMinus() {
        return null;
    }

    @Override
    public Division<?> div(Rotor2 other) throws ArithmeticException {
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
    public InnerProduct<?> inner(Rotor2 other) {
        return null;
    }

    @Override
    public InnerProduct<?> inner(double other) {
        return null;
    }

    @Override
    public InnerProduct<?> inner(Scalar other) {
        return null;
    }

    @Override
    public Rotor2 inverse() {
        return null;
    }

    @Override
    public Rotor2 normalized() {
        return null;
    }

    @Override
    public OuterProduct<?> outer(Rotor2 other) {
        return null;
    }

    @Override
    public OuterProduct<?> outer(double other) {
        return null;
    }

    @Override
    public OuterProduct<?> outer(Scalar other) {
        return null;
    }

    @Override
    public Product<?> times(Rotor2 other) {
        return null;
    }

    @Override
    public Product<?> times(double other) {
        return null;
    }

    @Override
    public Product<?> times(Scalar other) {
        return null;
    }

    @Override
    public Rotor2 reverse() {
        return null;
    }

    @Override
    public Rotor2 minus(Rotor2 other) {
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
