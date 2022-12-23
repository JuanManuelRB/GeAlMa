package juanmanuel.gealma.threedimensional;

public record Bivector3(double e1e2, double e2e3, double e3e1) implements Geometric3 {
    public static final Bivector3 ZERO = new Bivector3();
    public static final Bivector3 IJ = new Bivector3(1, 0, 0);
    public static final Bivector3 JK = new Bivector3(0, 1, 0);
    public static final Bivector3 KI = new Bivector3(0, 0, 1);
    public static final Bivector3 ONE = new Bivector3(1, 1, 1);

    public Bivector3() {
        this(0, 0, 0);
    }

    public double area() {
        return magnitude();
    }

    @Override
    public double magnitude() {
        return Math.sqrt(inner(this).unaryPlus().e0());
    }

    @Override
    public Bivector3 normalized() {
        return this.div(this.magnitude());
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
        return this;
    }

    @Override
    public Trivector3 trivector() {
        return Trivector3.ZERO;
    }

    @Override
    public Bivector3 unaryMinus() {
        return new Bivector3(-e1e2, -e2e3, -e3e1);
    }

    @Override
    public Bivector3 unaryPlus() {
        return new Bivector3(Math.abs(this.e1e2), Math.abs(this.e2e3), Math.abs(this.e3e1));
    }

    @Override
    public Bivector3 reciprocal() {
        return this.div(this.magnitude() * this.magnitude());
    }

    @Override
    public Rotor3 plus(double other) {
        return new Rotor3(other, this);
    }

    @Override
    public Rotor3 plus(Scalar other) {
        return new Rotor3(other, this);
    }

    @Override
    public Geometric3 plus(Vector3 other) {
        return new Geometric3Object(scalar(), other, this, trivector());
    }

    @Override
    public Bivector3 plus(Bivector3 other) {
        return new Bivector3(this.e1e2 + other.e1e2, this.e2e3 + other.e2e3, this.e3e1 + other.e3e1);
    }

    @Override
    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(other.scalar(), this.plus(other.bivector()));
    }

    @Override
    public Geometric3 plus(Trivector3 other) {
        return new Geometric3Object(scalar(), vector(), this, other);
    }

    @Override
    public Rotor3 minus(double other) {
        return this.plus(-other);
    }

    @Override
    public Geometric3 minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Bivector3 minus(Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Bivector3 inner(double other) {
        return new Bivector3(e1e2 * other, e2e3 * other, e3e1 * other);
    }

    @Override
    public Bivector3 inner(Scalar other) {
        return new Bivector3(this.e1e2 * other.e0(), this.e2e3 * other.e0(), this.e3e1 * other.e0());
    }

    @Override
    public Trivector3 inner(Vector3 other) {
        return new Trivector3(this.e1e2 * other.e3() + this.e2e3 * other.e1() + this.e3e1 * other.e2());
    }

    @Override
    public Scalar inner(Bivector3 other) {
        return new Scalar(-(this.e1e2 * other.e1e2 + this.e2e3 * other.e2e3 + this.e3e1 * other.e3e1));
    }

    @Override
    public Rotor3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public Vector3 inner(Trivector3 other) {
        return new Vector3(this.e2e3 * other.e1e2e3(), -(this.e3e1 * other.e1e2e3()), -(this.e1e2 * other.e1e2e3()));
    }

    @Override
    public Scalar outer(double other) {
        return scalar();
    }

    @Override
    public Scalar outer(Scalar other) {
        return scalar();
    }

    @Override
    public Vector3 outer(Vector3 other) {
        return new Vector3(
                this.e1e2 * other.e2() - this.e3e1 * other.e3(),
                this.e2e3 * other.e3() - this.e1e2 * other.e1(),
                this.e3e1 * other.e1() - this.e2e3 * other.e2()
        );
    }

    @Override
    public Bivector3 outer(Bivector3 other) {
        return new Bivector3(
                this.e3e1 * other.e2e3 - this.e2e3 * other.e3e1,
                this.e1e2 * other.e3e1 - this.e3e1 * other.e1e2,
                this.e2e3 * other.e1e2 - this.e1e2 * other.e2e3
        );
    }

    @Override
    public Rotor3 outer(Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    @Override
    public Scalar outer(Trivector3 other) {
        return Scalar.ZERO;
    }

    @Override
    public Bivector3 times(double other) {
        return this.inner(other);
    }

    @Override
    public Bivector3 times(Scalar other) {
        return this.inner(other);
    }

    @Override
    public Geometric3 times(Vector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Rotor3 times(Bivector3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Rotor3 times(Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Vector3 times(Trivector3 other) {
        return this.inner(other);
    }

    @Override
    public Bivector3 div(double other) {
        return new Bivector3(e1e2 / other, e2e3 / other, e3e1 / other);
    }

    @Override
    public Bivector3 div(Scalar other) {
        return new Bivector3(this.e1e2 / other.e0(), this.e2e3 / other.e0(), this.e3e1 / other.e0());
    }

    @Override
    public Geometric3 div(Vector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Rotor3 div(Bivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Rotor3 div(Rotor3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Trivector3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public String toString() {
        return "Bivector: " + e1e2 + "(e1e2) + " + e2e3 + "(e2e3) + " + e3e1 + "(e3e1)";
    }
}
