package juanmanuel.gealma.threedimensional;
public record Scalar(double e0) implements Geometric3 {
    public static Scalar ZERO = new Scalar();
    public static Scalar ONE = new Scalar(1);

    public Scalar() {
        this(0);
    }

    @Override
    public Scalar scalar() {
        return this;
    }

    @Override
    public Vector3 vector() {
        return Vector3.ZERO;
    }

    @Override
    public Bivector3 bivector() {
        return Bivector3.ZERO;
    }

    @Override
    public Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @Override
    public double magnitude() {
        return unaryPlus().e0;
    }

    @Override
    public Scalar plus(double other) {
        return new Scalar(e0 + other);
    }

    @Override
    public Scalar plus(Scalar other) {
        return new Scalar(this.e0 + other.e0);
    }

    @Override
    public Geometric3 plus(Vector3 other) {
        return new Geometric3Object(this, other, bivector(), trivector());
    }

    @Override
    public Rotor3 plus(Bivector3 other) {
        return new Rotor3(this, other);
    }

    @Override
    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(this.plus(other.scalar()), other.bivector());
    }

    @Override
    public Geometric3 plus(Trivector3 other) {
        return new Geometric3Object(this, vector(), bivector(), other);
    }

    @Override
    public Geometric3 minus(double other) {
        return this.minus(new Scalar(other));
    }

    @Override
    public Scalar minus(Scalar other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 minus(Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Rotor3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Scalar inner(double other) {
        return new Scalar(e0 * other);
    }

    @Override
    public Scalar inner(Scalar other) {
        return new Scalar(this.e0 * other.e0);
    }

    @Override
    public Vector3 inner(Vector3 other) {
        return other.inner(this);
    }

    @Override
    public Bivector3 inner(Bivector3 other) {
        return other.inner(this);
    }

    @Override
    public Rotor3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public Trivector3 inner(Trivector3 other) {
        return other.inner(this);
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
    public Rotor3 outer(Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector())).rotor();
    }

    @Override
    public Scalar outer(Trivector3 other) {
        return ZERO;
    }

    @Override
    public Scalar times(double other) {
        return new Scalar(e0 * other);
    }

    @Override
    public Scalar times(Scalar other) {
        return new Scalar(this.e0 * other.e0);
    }

    @Override
    public Vector3 times(Vector3 other) {
        return new Vector3(
                other.e1() * e0,
                other.e2() * e0,
                other.e3() * e0
        );
    }

    @Override
    public Bivector3 times(Bivector3 other) {
        return new Bivector3(
                other.e1e2() * e0,
                other.e2e3() * e0,
                other.e3e1() * e0
        );
    }

    @Override
    public Geometric3 times(Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Trivector3 times(Trivector3 other) {
        return new Trivector3(other.e1e2e3() * e0);
    }

    @Override
    public Scalar reciprocal() {
        return new Scalar(1 / e0);
    }

    @Override
    public Scalar div(double other) {
        return new Scalar(e0 / other);
    }

    @Override
    public Scalar div(Scalar other) {
        return new Scalar(this.e0 / other.e0);
    }

    @Override
    public Geometric3 div(Vector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Bivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Rotor3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Trivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Scalar unaryMinus() {
        return new Scalar(-e0);
    }

    @Override
    public Scalar unaryPlus() {
        return new Scalar(Math.abs(e0));
    }

    @Override
    public Geometric3 normalized() {
        return Scalar.ONE;
    }

    @Override
    public String toString() {
        return e0 + "(e0)";
    }
}
