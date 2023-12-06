package juanmanuel.gealma.vga.vga2;

import juanmanuel.gealma.operations.Division;
import juanmanuel.gealma.operations.InnerProduct;
import juanmanuel.gealma.operations.OuterProduct;
import juanmanuel.gealma.operations.Product;
import juanmanuel.gealma.vga.Scalar;
import juanmanuel.gealma.vga.basis.vga.E0;
import juanmanuel.gealma.vga.basis.vga.E1E2;

import java.util.Objects;

public record Bivector2(E1E2 e1e2) implements Geometric2<Bivector2> {
    public final static Bivector2 ZERO = new Bivector2(0);
    public final static Bivector2 ONE = new Bivector2(1);

    public Bivector2 {
        Objects.requireNonNull(e1e2);
    }

    public Bivector2(double e1e2) {
        this(new E1E2(e1e2));
    }

    @Override
    public Bivector2 plus(Bivector2 other) {
        return null;
    }

    @Override
    public Bivector2 unaryMinus() {
        return new Bivector2(e1e2.unaryMinus());
    }

    @Override
    public Bivector2 minus(Bivector2 other) {
        return null;
    }

    @Override
    public InnerProduct<?> inner(Bivector2 other) {
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
    public OuterProduct<?> outer(Bivector2 other) {
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
    public Product<?> times(Bivector2 other) {
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
    public Bivector2 inverse() {
        return null;
    }

    @Override
    public Division<?> div(Bivector2 other) throws ArithmeticException {
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
    public Bivector2 normalized() {
        return null;
    }

    @Override
    public Bivector2 reverse() {
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

    public Rotor2 plus(double scalar) {
        return new Rotor2(new E0(scalar), e1e2);
    }

    public Rotor2 plus(Scalar scalar) {
        return new Rotor2(scalar.e0(), e1e2);
    }

    public Rotor2 minus(double scalar) {
        return this.plus(-scalar);
    }

    public Rotor2 minus(Scalar scalar) {
        return this.plus(scalar.unaryMinus());
    }
}
