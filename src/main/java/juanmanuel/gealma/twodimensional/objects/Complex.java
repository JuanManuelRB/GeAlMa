package juanmanuel.gealma.twodimensional.objects;

import juanmanuel.gealma.twodimensional.basis.E0;
import juanmanuel.gealma.twodimensional.basis.E1E2;

public record Complex(E0 real, E1E2 imaginary) implements Geometric2 {
    public Complex(Scalar scalar, Bivector2 bivector) {
        this(scalar.e0(), bivector.e1e2());
    }

    public Complex(double real, double imaginary) {
        this(new E0(real), new E1E2(imaginary));
    }

    @Override
    public double magnitudeSquared() {
        return Math.abs(real.times(real).plus(imaginary.times(imaginary)).value());
    }

    @Override
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    @Override
    public Geometric2 normalized() {
        return this.div(magnitudeSquared());
    }

    @Override
    public Complex unaryMinus() {
        return new Complex(real.unaryMinus(), imaginary.unaryMinus());
    }

    @Override
    public Complex inverse() {
        return;
    }

    @Override
    public Complex plus(double other) {
        return new Complex(real.plus(new E0(other)), imaginary);
    }

    @Override
    public Complex plus(Scalar other) {
        return new Complex(real.plus(other.e0()), imaginary);
    }

    @Override
    public Geometric2 plus(Vector2 other) {
        return null;
    }

    @Override
    public Complex plus(Bivector2 other) {
        return new Complex(real, imaginary.plus(other.e1e2()));
    }
}
