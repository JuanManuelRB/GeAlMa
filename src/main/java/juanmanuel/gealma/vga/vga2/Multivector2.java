package juanmanuel.gealma.vga.vga2;

import juanmanuel.gealma.vga.Scalar;
import juanmanuel.gealma.vga.basis.E0;
import juanmanuel.gealma.vga.basis.E1;
import juanmanuel.gealma.vga.basis.E1E2;
import juanmanuel.gealma.vga.basis.E2;

public record Multivector2(E0 e0, E1 e1, E2 e2, E1E2 e1e2) implements Geometric2<Multivector2> {
    public Multivector2(double e0, double e1, double e2, double e1e2) {
        this(new E0(e0), new E1(e1), new E2(e2), new E1E2(e1e2));
    }


    public Multivector2 plus(Bivector2 other) {
        return new Multivector2(
                e0,
                e1,
                e2,
                e1e2.plus(other.e1e2())
        );
    }

    @Override
    public Multivector2 plus(Multivector2 other) {
        return new Multivector2(
                e0.plus(other.e0),
                e1.plus(other.e1),
                e2.plus(other.e2),
                e1e2.plus(other.e1e2)
        );
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
        return new Multivector2(
                e0.div(other),
                e1.div(other),
                e2.div(other),
                e1e2.div(other)
        );
    }

    @Override
    public Multivector2 div(Scalar other) {
        return div(other.value());
    }

    @Override
    public Multivector2 inner(Multivector2 other) {
        return scalar().inner(other)
                .plus(vector().inner(other))
                .plus(bivector().inner(other));
    }

    @Override
    public Multivector2 inner(double other) {
        return new Multivector2(
                e0.times(other),
                e1.times(other),
                e2.times(other),
                e1e2.times(other)
        );
    }

    @Override
    public Multivector2 inner(Scalar other) {
        return inner(other.value());
    }

    @Override
    public Multivector2 inverse() {
        return div(times(reverse()));
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
        return scalar().outer(other)
                .plus(vector().outer(other))
                .plus(bivector().outer(other));
    }

    @Override
    public Multivector2 outer(Scalar other) {
        return outer(other.value());
    }

    @Override
    public Multivector2 times(Multivector2 other) {
        return null;
    }

    @Override
    public Multivector2 times(double other) {
        return new Multivector2(
                e0.times(other),
                e1.times(other),
                e2.times(other),
                e1e2.times(other)
        );
    }

    @Override
    public Multivector2 times(Scalar other) {
        return times(other.value());
    }

    @Override
    public Multivector2 reverse() {
        return new Multivector2(
                e0,
                e1.reverse(),
                e2.reverse(),
                e1e2.reverse()
        );
    }

    @Override
    public Multivector2 minus(Multivector2 other) {
        return new Multivector2(
                e0.minus(other.e0),
                e1.minus(other.e1),
                e2.minus(other.e2),
                e1e2.minus(other.e1e2)
        );
    }

    @Override
    public double magnitudeSquared() {
        return inner(this).e0.value();
    }

    @Override
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }
}
