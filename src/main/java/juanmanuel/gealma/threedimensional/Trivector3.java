package juanmanuel.gealma.threedimensional;

public record Trivector3(double e1e2e3) implements Geometric3 {
    public static final Trivector3 ZERO = new Trivector3();
    public static final Trivector3 ONE = new Trivector3(1);

    public Trivector3() {
        this(0);
    }

    @Override
    public Scalar scalar() {
        return Scalar.ZERO;
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
        return this;
    }

    @Override
    public Trivector3 unaryMinus() {
        return new Trivector3(-this.e1e2e3);
    }

    @Override
    public Trivector3 unaryPlus() {
        return new Trivector3(Math.abs(this.e1e2e3));
    }

    @Override
    public double magnitude() {
        return e1e2e3;
    }

    public Trivector3 normalized() {
        return Trivector3.ONE;
    }

    @Override
    public Trivector3 reciprocal() {
        return this.unaryMinus();
    }

    @Override
    public Geometric3 plus(double other) {
        return new Geometric3Object(other, vector(), bivector(), this);
    }

    @Override
    public Geometric3 plus(Scalar other) {
        return new Geometric3Object(other, vector(), bivector(), this);
    }

    @Override
    public Geometric3 plus(Vector3 other) {
        return new Geometric3Object(scalar(), other, bivector(), this);
    }

    @Override
    public Geometric3 plus(Bivector3 other) {
        return new Geometric3Object(scalar(), vector(), other, this);
    }

    @Override
    public Geometric3 plus(Rotor3 other) {
        return new Geometric3Object(other.scalar(), vector(), other.bivector(), this);
    }

    @Override
    public Trivector3 plus(Trivector3 other) {
        return new Trivector3(this.e1e2e3 + other.e1e2e3);
    }

    @Override
    public Geometric3 minus(double other) {
        return this.plus(-other);
    }

    @Override
    public Geometric3 minus(Scalar other) {
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
    public Geometric3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Trivector3 minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Trivector3 inner(double other) {
        return new Trivector3(e1e2e3 * other);
    }

    @Override
    public Trivector3 inner(Scalar other) {
        return new Trivector3(this.e1e2e3 * other.e0());
    }

    @Override
    public Bivector3 inner(Vector3 other) {
        return new Bivector3(this.e1e2e3 * other.e3(), this.e1e2e3 * other.e1(), -(this.e1e2e3 * other.e2()));
    }

    @Override
    public Vector3 inner(Bivector3 other) {
        return new Vector3(this.e1e2e3 * other.e2e3(), -(this.e1e2e3 * other.e3e1()), -(this.e1e2e3 * other.e1e2()));
    }

    @Override
    public Geometric3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public Scalar inner(Trivector3 other) {
        return new Scalar(-(this.e1e2e3 * other.e1e2e3));
    }

    @Override
    public Scalar outer(double other) {
        return Scalar.ZERO;
    }

    @Override
    public Scalar outer(Scalar other) {
        return Scalar.ZERO;
    }

    @Override
    public Scalar outer(Vector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public Scalar outer(Bivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public Geometric3 outer(Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    @Override
    public Geometric3 outer(Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public Trivector3 times(double other) {
        return this.inner(other);
    }

    @Override
    public Trivector3 times(Scalar other) {
        return this.inner(other);
    }

    @Override
    public Bivector3 times(Vector3 other) {
        return this.inner(other);
    }

    @Override
    public Vector3 times(Bivector3 other) {
        return this.inner(other);
    }

    @Override
    public Geometric3 times(Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Scalar times(Trivector3 other) {
        return this.inner(other);
    }

    @Override
    public Trivector3 div(double other) {
        return new Trivector3(e1e2e3 / other);
    }

    @Override
    public Trivector3 div(Scalar other) {
        return new Trivector3(this.e1e2e3 / other.e0());
    }

    @Override
    public Bivector3 div(Vector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Vector3 div(Bivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Rotor3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Scalar div(Trivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public String toString() {
        return  "Trivector: " + e1e2e3 + "(e1e2e3)";
    }
}
