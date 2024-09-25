package juanmanuel.gealma.vga.vga2;

import juanmanuel.gealma.vga.Scalar;
import juanmanuel.gealma.vga.basis.E0;
import juanmanuel.gealma.vga.basis.E1E2;

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
        return new Bivector2(e1e2.plus(other.e1e2));
    }

    @Override
    public Bivector2 unaryMinus() {
        return new Bivector2(e1e2.unaryMinus());
    }

    @Override
    public Bivector2 minus(Bivector2 other) {
        return new Bivector2(e1e2.minus(other.e1e2));
    }

    @Override
    public Scalar inner(Bivector2 other) {
        return new Scalar(e1e2.times(other.e1e2));
    }

    @Override
    public Bivector2 inner(double other) {
        return new Bivector2(e1e2.times(other));
    }

    @Override
    public Bivector2 inner(Scalar other) {
        return inner(other.value());
    }

    @Override
    public Scalar outer(Bivector2 other) {
        return new Scalar(e1e2.times(other.e1e2));
    }

    @Override
    public Bivector2 outer(double other) {
        return new Bivector2(e1e2.times(other));
    }

    @Override
    public Bivector2 outer(Scalar other) {
        return outer(other.value());
    }

    @Override
    public Scalar times(Bivector2 other) {
        return new Scalar(e1e2.times(other.e1e2));
    }

    @Override
    public Bivector2 times(double other) {
        return new Bivector2(e1e2.times(other));
    }

    @Override
    public Bivector2 times(Scalar other) {
        return times(other.value());
    }

    @Override
    public Bivector2 inverse() {
        return new Bivector2(e1e2.inverse());
    }

    @Override
    public Scalar div(Bivector2 other) throws ArithmeticException {
        return this.times(other.inverse());
    }

    @Override
    public Bivector2 div(double other) {
        return new Bivector2(e1e2.div(other));
    }

    @Override
    public Bivector2 div(Scalar other) {
        return div(other.value());
    }

    @Override
    public Bivector2 normalized() {
        return Bivector2.ONE;
    }

    @Override
    public Bivector2 reverse() {
        return this.unaryMinus();
    }

    @Override
    public double magnitudeSquared() {
        return times(this).value();
    }

    @Override
    public double magnitude() {
        return e1e2.value();
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
