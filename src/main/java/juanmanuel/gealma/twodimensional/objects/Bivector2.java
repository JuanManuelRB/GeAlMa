package juanmanuel.gealma.twodimensional.objects;

import juanmanuel.gealma.twodimensional.basis.E1E2;

public record Bivector2(E1E2 e1e2) implements Geometric2 {
    public static final Bivector2 ZERO = new Bivector2(0);

    public Bivector2(double e1e2) {
        this(new E1E2(e1e2));
    }

    @Override
    public double magnitudeSquared() {
        return Math.abs(e1e2.times(e1e2).value());
    }

    @Override
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    @Override
    public Bivector2 normalized() {
        // return this.div(magnitudeSquared());
        return null;
    }

    @Override
    public Bivector2 unaryMinus() {
        return null;
    }

    @Override
    public Geometric2 inverse() {
        return null;
    }

    @Override
    public Geometric2 plus(double other) {
        return null;
    }

    @Override
    public Geometric2 plus(Scalar other) {
        return null;
    }

    @Override
    public Geometric2 plus(Vector2 other) {
        return null;
    }

    @Override
    public Geometric2 plus(Bivector2 other) {
        return null;
    }

    @Override
    public Geometric2 plus(Complex other) {
        return null;
    }

    @Override
    public Geometric2 plus(Multivector2 other) {
        return null;
    }

    @Override
    public Geometric2 minus(double other) {
        return null;
    }

    @Override
    public Geometric2 minus(Scalar other) {
        return null;
    }

    @Override
    public Geometric2 minus(Vector2 other) {
        return null;
    }

    @Override
    public Geometric2 minus(Bivector2 other) {
        return null;
    }

    @Override
    public Geometric2 minus(Complex other) {
        return null;
    }

    @Override
    public Geometric2 minus(Multivector2 other) {
        return null;
    }
}
