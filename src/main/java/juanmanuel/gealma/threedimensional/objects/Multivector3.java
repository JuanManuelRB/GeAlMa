package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.threedimensional.basis.*;

public record Multivector3(E0 e0, E1 e1, E2 e2, E3 e3, E1E2 e1e2, E2E3 e2e3, E3E1 e3e1,
                           E1E2E3 e1e2e3) implements Geometric3 {
    public Multivector3(Scalar scalar, Vector3 vector3, Bivector3 bivector3, Trivector3 trivector3) {
        this(scalar.e0(), vector3.e1(), vector3.e2(), vector3.e3(), bivector3.e1e2(), bivector3.e2e3(), bivector3.e3e1(), trivector3.e1e2e3());
    }

    public Multivector3(double e0, double e1, double e2, double e3, double e1e2, double e2e3, double e3e1, double e1e2e3) {
        this(new E0(e0), new E1(e1), new E2(e2), new E3(e3), new E1E2(e1e2), new E2E3(e2e3), new E3E1(e3e1), new E1E2E3(e1e2e3));
    }

    @Override
    public Geometric3 normalized() {
        return null;
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
    public Multivector3 unaryMinus() {
        return new Multivector3(scalar().unaryMinus(), vector().unaryMinus(), bivector().unaryMinus(), trivector().unaryMinus());
    }

    @Override
    public Multivector3 inverse() {
        return null;
    }

    @Override
    public Multivector3 plus(double other) {
        return plus(new Scalar(other));
    }

    @Override
    public Multivector3 plus(Scalar other) {
        return new Multivector3(scalar().plus(other), vector(), bivector(), trivector());
    }

    @Override
    public Multivector3 plus(Vector3 other) {
        return new Multivector3(scalar(), vector().plus(other), bivector(), trivector());
    }

    @Override
    public Multivector3 plus(Bivector3 other) {
        return new Multivector3(scalar(), vector(), bivector().plus(other), trivector());
    }

    @Override
    public Multivector3 plus(Rotor3 other) {
        return new Multivector3(
                scalar().plus(other.scalar()),
                vector(),
                bivector().plus(other.bivector()),
                trivector()
        );
    }

    @Override
    public Multivector3 plus(Trivector3 other) {
        return null;
    }

    @Override
    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(
                scalar().plus(other.scalar()),
                vector().plus(other.vector()),
                bivector().plus(other.bivector()),
                trivector().plus(other.trivector())
        );
    }

    @Override
    public Geometric3 minus(Scalar other) {
        return null;
    }

    @Override
    public Geometric3 minus(Vector3 other) {
        return null;
    }

    @Override
    public Geometric3 minus(Bivector3 other) {
        return null;
    }

    @Override
    public Geometric3 minus(Rotor3 other) {
        return null;
    }

    @Override
    public Geometric3 minus(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 minus(Multivector3 other) {
        return null;
    }

    @Override
    public Geometric3 inner(Scalar other) {
        return null;
    }

    @Override
    public Geometric3 inner(Vector3 other) {
        return null;
    }

    @Override
    public Geometric3 inner(Bivector3 other) {
        return null;
    }

    @Override
    public Geometric3 inner(Rotor3 other) {
        return null;
    }

    @Override
    public Geometric3 inner(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 inner(Multivector3 other) {
        return null;
    }

    @Override
    public Geometric3 outer(Scalar other) {
        return null;
    }

    @Override
    public Geometric3 outer(Vector3 other) {
        return null;
    }

    @Override
    public Geometric3 outer(Bivector3 other) {
        return null;
    }

    @Override
    public Geometric3 outer(Rotor3 other) {
        return null;
    }

    @Override
    public Geometric3 outer(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 outer(Multivector3 other) {
        return null;
    }

    @Override
    public Geometric3 times(Scalar other) {
        return null;
    }

    @Override
    public Geometric3 times(Vector3 other) {
        return null;
    }

    @Override
    public Geometric3 times(Bivector3 other) {
        return null;
    }

    @Override
    public Multivector3 times(Rotor3 other) {
        return null;
    }

    @Override
    public Geometric3 times(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 times(Multivector3 other) {
        return null;
    }

    @Override
    public Multivector3 div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Multivector3 div(Scalar other) {
        var otherInv = other.inverse().e0();
        return new Multivector3(
                e0.times(otherInv),
                e1.times(otherInv),
                e2.times(otherInv),
                e3.times(otherInv),
                e1e2.times(otherInv),
                e2e3.times(otherInv),
                e3e1.times(otherInv),
                e1e2e3.times(otherInv)
        );
    }

    @Override
    public Geometric3 div(Vector3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Bivector3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Rotor3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Trivector3 other) {
        return null;
    }

    @Override
    public Geometric3 div(Multivector3 other) {
        return null;
    }
}
