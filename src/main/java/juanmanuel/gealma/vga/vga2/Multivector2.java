package juanmanuel.gealma.vga.vga2;

import juanmanuel.gealma.vga.Scalar;
import juanmanuel.gealma.vga.basis.vga.E0;
import juanmanuel.gealma.vga.basis.vga.E1;
import juanmanuel.gealma.vga.basis.vga.E1E2;
import juanmanuel.gealma.vga.basis.vga.E2;

public record Multivector2(E0 e0, E1 e1, E2 e2, E1E2 e1e2) implements Geometric2<Multivector2> {
    @Override
    public Multivector2 plus(Multivector2 other) {
        return null;
    }

    @Override
    public Multivector2 unaryMinus() {
        return new Multivector2(e0.unaryMinus(), e1.unaryMinus(), e2.unaryMinus(), e1e2.unaryMinus());
    }

    @Override
    public Multivector2 div(Multivector2 other) throws ArithmeticException {
        return null;
    }

    @Override
    public Multivector2 div(double other) {
        return null;
    }

    @Override
    public Multivector2 div(Scalar other) {
        return null;
    }

    @Override
    public Multivector2 inner(Multivector2 other) {
        return null;
    }

    @Override
    public Multivector2 inner(double other) {
        return null;
    }

    @Override
    public Multivector2 inner(Scalar other) {
        return null;
    }

    @Override
    public Multivector2 inverse() {
        return null;
    }

    @Override
    public Multivector2 normalized() {
        return null;
    }

    @Override
    public Multivector2 outer(Multivector2 other) {
        return null;
    }

    @Override
    public Multivector2 outer(double other) {
        return null;
    }

    @Override
    public Multivector2 outer(Scalar other) {
        return null;
    }

    @Override
    public Multivector2 times(Multivector2 other) {
        return null;
    }

    @Override
    public Multivector2 times(double other) {
        return null;
    }

    @Override
    public Multivector2 times(Scalar other) {
        return null;
    }

    @Override
    public Multivector2 reverse() {
        return null;
    }

    @Override
    public Multivector2 minus(Multivector2 other) {
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
