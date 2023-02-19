package juanmanuel.gealma.twodimensional.objects;

import juanmanuel.gealma.twodimensional.basis.E1;
import juanmanuel.gealma.twodimensional.basis.E2;

public record Vector2(E1 e1, E2 e2) implements Geometric2 {
    @Override
    public double magnitudeSquared() {
        return 0;
    }

    @Override
    public double magnitude() {
        return 0;
    }

    @Override
    public Vector2 normalized() {
        return null;
    }

    @Override
    public Vector2 unaryMinus() {
        return null;
    }

    @Override
    public Vector2 inverse() {
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
    public Vector2 plus(Vector2 other) {
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
    public Multivector2 plus(Multivector2 other) {
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
    public Vector2 minus(Vector2 other) {
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
    public Multivector2 minus(Multivector2 other) {
        return null;
    }
}
