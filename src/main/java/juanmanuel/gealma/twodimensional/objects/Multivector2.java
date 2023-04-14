package juanmanuel.gealma.twodimensional.objects;

import juanmanuel.gealma.twodimensional.basis.E0;
import juanmanuel.gealma.twodimensional.basis.E1;
import juanmanuel.gealma.twodimensional.basis.E1E2;
import juanmanuel.gealma.twodimensional.basis.E2;

public record Multivector2(E0 e0, E1 e1, E2 e2, E1E2 e1e2) implements Geometric2 {
    public Multivector2(Scalar scalar, Vector2 vector, Bivector2 bivector) {
        this(scalar.e0(), vector.e1(), vector.e2(), bivector.e1e2());
    }

    @Override
    public double magnitudeSquared() {
        return 0;
    }

    @Override
    public double magnitude() {
        return 0;
    }

    @Override
    public Geometric2 normalized() {
        return null;
    }

    @Override
    public Geometric2 unaryMinus() {
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
