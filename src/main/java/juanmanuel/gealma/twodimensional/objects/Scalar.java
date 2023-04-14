package juanmanuel.gealma.twodimensional.objects;

import juanmanuel.gealma.twodimensional.basis.E0;

public record Scalar(@Override E0 e0) implements Geometric2 {
    public static final Scalar ZERO = new Scalar(E0.ZERO);
    public static final Scalar ONE = new Scalar(1);

    public Scalar(double e0) {
        this(new E0(e0));
    }

    @Override
    public String toString() {
        return "(" + e0.value() + ")e0";
    }

    @Override
    public double magnitudeSquared() {
//        return inner(this).value();
        return 0;
    }

    @Override
    public double magnitude() {
        return e0.value();
    }

    double value() {
        return magnitude();
    }

    @Override
    public Scalar normalized() {
        return ONE;
    }

    @Override
    public Scalar unaryMinus() {
        return new Scalar(-value());
    }

    @Override
    public Scalar inverse() {
        return new Scalar(1 / value());
    }

    @Override
    public Scalar plus(double other) {
        return plus(new Scalar(other));
    }

    @Override
    public Scalar plus(Scalar other) {
        return new Scalar(this.value() + other.value());
    }

    @Override
    public Multivector2 plus(Vector2 other) {
        return new Multivector2(this, other, Bivector2.ZERO);
    }

    @Override
    public Complex plus(Bivector2 other) {
        return new Complex(this, other);
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
    public Scalar minus(double other) {
        return minus(new Scalar(other));
    }

    @Override
    public Scalar minus(Scalar other) {
        return new Scalar(e0.plus(other.e0.unaryMinus()));
    }

    @Override
    public Multivector2 minus(Vector2 other) {
        return this.plus(other.unaryMinus());
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

    /*

    @Override
    public Rotor3 minus(Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Rotor3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Multivector3 minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Multivector3 minus(Multivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Scalar inner(double other) {
        return inner(new Scalar(other));
    }

    @Override
    public Scalar inner(Scalar other) {
        return new Scalar(this.e0.times(other.e0));
    }

    @Override
    public Vector3 inner(Vector3 other) {
        return new Vector3(e0.times(other.e1()), e0.times(other.e2()), e0.times(other.e3()));
    }

    @Override
    public Bivector3 inner(Bivector3 other) {
        return new Bivector3(e0.times(other.e1e2()), e0.times(other.e2e3()), e0.times(other.e3e1()));
    }

    @Override
    public Rotor3 inner(Rotor3 other) {
        return inner(other.scalar()).plus(inner(other.bivector()));
    }

    @Override
    public Trivector3 inner(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

    @Override
    public Multivector3 inner(Multivector3 other) {
        return inner(other.scalar())
                .plus(inner(other.vector()))
                .plus(inner(other.bivector()))
                .plus(inner(other.trivector()));
    }

    @Override
    public Scalar outer(double other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Scalar other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Vector3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Bivector3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Rotor3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Trivector3 other) {
        return ZERO;
    }

    @Override
    public Scalar outer(Multivector3 other) {
        return ZERO;
    }

    @Override
    public Scalar times(double other) {
        return times(new Scalar(other));
    }

    @Override
    public Scalar times(Scalar other) {
        return new Scalar(this.e0.times(other.e0));
    }

    @Override
    public Vector3 times(Vector3 other) {
        return new Vector3(e0.times(other.e1()), e0.times(other.e2()), e0.times(other.e3()));
    }

    @Override
    public Bivector3 times(Bivector3 other) {
        return new Bivector3(e0.times(other.e1e2()), e0.times(other.e2e3()), e0.times(other.e3e1()));
    }

    @Override
    public Rotor3 times(Rotor3 other) {
        return new Rotor3(this.times(other.scalar()), this.times(other.bivector()));
    }

    @Override
    public Trivector3 times(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

    @Override
    public Multivector3 times(Multivector3 other) {
        return new Multivector3(
                this.times(other.scalar()),
                this.times(other.vector()),
                this.times(other.bivector()),
                this.times(other.trivector())
        );
    }

    @Override
    public Scalar div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Scalar div(Scalar other) {
        return new Scalar(this.value() / other.value());
    }

    @Override
    public Vector3 div(Vector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Bivector3 div(Bivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Rotor3 div(Rotor3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Trivector3 div(Trivector3 other) {
        return this.times(other.inverse());
    }

    @Override
    public Geometric3 div(Multivector3 other) {
        return this.times(other.inverse());
    }*/
}