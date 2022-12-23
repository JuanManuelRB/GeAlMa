package juanmanuel.gealma.threedimensional;

public record Geometric3Object(double e0, double e1, double e2, double e3, double e1e2, double e2e3, double e3e1, double e1e2e3) implements Geometric3 {
    public static final Geometric3Object ZERO = new Geometric3Object();
    public Geometric3Object(Scalar scalar, Vector3 vector, Bivector3 bivector, Trivector3 trivector) {
        this(scalar.e0(), vector.e1(), vector.e2(), vector.e3(), bivector.e1e2(), bivector.e2e3(), bivector.e3e1(), trivector.e1e2e3());
    }

    public Geometric3Object(double scalar, Vector3 vector, Bivector3 bivector, Trivector3 trivector) {
        this(new Scalar(scalar), vector, bivector, trivector);
    }

    public Geometric3Object() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    @Override
    public Geometric3Object unaryMinus() {
        return new Geometric3Object(scalar().unaryMinus(), vector().unaryMinus(), bivector().unaryMinus(), trivector().unaryMinus());
    }

    @Override
    public Geometric3Object unaryPlus() {
        return new Geometric3Object(scalar().unaryPlus(), vector().unaryPlus(), bivector().unaryPlus(), trivector().unaryPlus());
    }

    @Override
    public Geometric3 normalized() {
        return div(magnitude());
    }

    @Override
    public Geometric3 reciprocal() {
//        return Geometric3Object.ZERO.plus(1).div(this); TODO
        return null;
    }

    @Override
    public Scalar scalar() {
        return new Scalar(e0);
    }

    @Override
    public Vector3 vector() {
        return new Vector3(e1, e2, e3);
    }

    @Override
    public Bivector3 bivector() {
        return new Bivector3(e1e2, e2e3, e3e1);
    }

    @Override
    public Trivector3 trivector() {
        return new Trivector3(e1e2e3);
    }

    @Override
    public double magnitude() {
        return MathGeometric3.hypot(e0, e1, e2, e3, e1e2, e2e3, e3e1, e1e2e3);
    }

    @Override
    public Geometric3Object plus(double other) {
        return new Geometric3Object(e0 + other, vector(), bivector(), trivector());
    }

    @Override
    public Geometric3Object plus(Scalar other) {
        return new Geometric3Object(other.plus(e0), vector(), bivector(), trivector());
    }

    @Override
    public Geometric3Object plus(Vector3 other) {
        return new Geometric3Object(scalar(), vector().plus(other), bivector(), trivector());
    }

    @Override
    public Geometric3Object plus(Bivector3 other) {
        return new Geometric3Object(scalar(), vector(), bivector().plus(other), trivector());
    }

    @Override
    public Geometric3 plus(Rotor3 other) {
        return new Geometric3Object(this.scalar().plus(other.scalar()), this.vector(), this.bivector().plus(other.bivector()), this.trivector());
    }

    @Override
    public Geometric3Object plus(Trivector3 other) {
        return new Geometric3Object(scalar(), vector(), bivector(), trivector().plus(other));
    }

    @Override
    public Geometric3Object minus(double other) {
        return this.plus(-other);
    }

    @Override
    public Geometric3Object minus(Scalar other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3Object minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3Object minus(Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3Object minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    @Override
    public Geometric3 times(double other) {
        var g = scalar().times(other)
                .plus(vector().times(other))
                .plus(bivector().times(other))
                .plus(trivector().times(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3Object times(Vector3 other) {
        var g = scalar().times(other)
                .plus(vector().times(other))
                .plus(bivector().times(other))
                .plus(trivector().times(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 times(Bivector3 other) {
        var g = scalar().times(other)
                .plus(vector().times(other))
                .plus(bivector().times(other))
                .plus(trivector().times(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 times(Rotor3 other) {
        return this.inner(other).plus(this.outer(other));
    }

    @Override
    public Geometric3 times(Trivector3 other) {
        var g = scalar().times(other)
                .plus(vector().times(other))
                .plus(bivector().times(other))
                .plus(trivector().times(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 inner(double other) {
        var g = scalar().inner(other)
                .plus(vector().inner(other))
                .plus(bivector().inner(other))
                .plus(trivector().inner(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 inner(Scalar other) {
        var g = scalar().inner(other)
                .plus(vector().inner(other))
                .plus(bivector().inner(other))
                .plus(trivector().inner(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 inner(Vector3 other) {
        var g = scalar().inner(other)
                .plus(vector().inner(other))
                .plus(bivector().inner(other))
                .plus(trivector().inner(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 inner(Bivector3 other) {
        var g = scalar().inner(other)
                .plus(vector().inner(other))
                .plus(bivector().inner(other))
                .plus(trivector().inner(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 inner(Rotor3 other) {
        return this.inner(other.scalar()).plus(this.inner(other.bivector()));
    }

    @Override
    public Geometric3 inner(Trivector3 other) {
        var g = scalar().inner(other)
                .plus(vector().inner(other))
                .plus(bivector().inner(other))
                .plus(trivector().inner(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 outer(double other) {
        var g = scalar().outer(other)
                .plus(vector().outer(other))
                .plus(bivector().outer(other))
                .plus(trivector().outer(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 outer(Scalar other) {
        var g = scalar().outer(other)
                .plus(vector().outer(other))
                .plus(bivector().outer(other))
                .plus(trivector().outer(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 outer(Vector3 other) {
        var g = scalar().outer(other)
                .plus(vector().outer(other))
                .plus(bivector().outer(other))
                .plus(trivector().outer(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 outer(Bivector3 other) {
        var g = scalar().outer(other)
                .plus(vector().outer(other))
                .plus(bivector().outer(other))
                .plus(trivector().outer(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 outer(Rotor3 other) {
        return this.outer(other.scalar()).plus(this.outer(other.bivector()));
    }

    @Override
    public Geometric3 outer(Trivector3 other) {
        var g = scalar().outer(other)
                .plus(vector().outer(other))
                .plus(bivector().outer(other))
                .plus(trivector().outer(other));
        return new Geometric3Object(g.scalar(), g.vector(), g.bivector(), g.trivector());
    }

    @Override
    public Geometric3 div(double other) {
        return new Geometric3Object(
                this.scalar().div(other),
                this.vector().div(other),
                this.bivector().div(other),
                this.trivector().div(other)
        );
    }

    @Override
    public Geometric3 div(Scalar other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Vector3 other) {
//        return other.inverse().times(other).plus(this.vector.div(other)).plus(this.bivector.div(other)).plus(this.trivector.div(other));TODO
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Bivector3 other) {
//        return other.inverse().times(other).plus(this.vector.div(other)).plus(this.bivector.div(other)).plus(this.trivector.div(other));TODO
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Rotor3 other) {
        return this.times(other.reciprocal());
    }

    @Override
    public Geometric3 div(Trivector3 other) {
//        return other.inverse().times(other).plus(this.vector.div(other)).plus(this.bivector.div(other)).plus(this.trivector.div(other));TODO
        return this.times(other.reciprocal());
    }

    @Override
    public String toString() {
        return "Geometric: " + e0 + "(e0) + " + e1 + "(e1) + " + e2 + "(e2) + " + e3 + "(e3) + " + e1e2 + "(e1e2) + " + e2e3 + "(e2e3) + " + e3e1 + "(e3e1) + " + e1e2e3 + "(e1e2e3)";
    }
}
