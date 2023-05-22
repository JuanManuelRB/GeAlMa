package juanmanuel.gealma;

import juanmanuel.gealma.basis.*;
import juanmanuel.gealma.threedimensional.*;
import juanmanuel.gealma.twodimensional.Bivector2;
import juanmanuel.gealma.twodimensional.Multivector2;
import juanmanuel.gealma.twodimensional.Rotor2;
import juanmanuel.gealma.twodimensional.Vector2;

import java.util.Objects;

public record Scalar(E0 e0) implements Geometric<Scalar> {
    public static final Scalar ZERO = new Scalar(E0.ZERO);
    public static final Scalar ONE = new Scalar(1);

    public Scalar {
        Objects.requireNonNull(e0);
    }

    public Scalar(double e0) {
        this(new E0(e0));
    }

    public double value() {
        return e0.value();
    }

    public double magnitude() {
        return Math.abs(value());
    }

    public double magnitudeSquared() {
        return value() * value();
    }

    public Scalar inc() {
        return new Scalar(e0.inc());
    }

    public Scalar dec() {
        return new Scalar(e0.dec());
    }

    @Override
    public Scalar reverse() {
        return this;
    }

    @Override
    public Scalar normalized() {
        return new Scalar(1);
    }

    @Override
    public Scalar unaryMinus() {
        return new Scalar(e0.unaryMinus());
    }

    public Scalar plus(double other) {
        return new Scalar(e0.value() + other);
    }

    @Override
    public Scalar plus(Scalar other) {
        return new Scalar(e0.plus(other.e0()));
    }

    @Override
    public Scalar minus(Scalar other) {
        return new Scalar(e0.minus(other.e0()));
    }

    @Override
    public Scalar inverse() {
        return new Scalar(e0.inverse());
    }

    public Multivector2 plus(Vector2 other) {
        return new Multivector2(e0, other.e1(), other.e2(), E1E2.ZERO);
    }

    public Rotor2 plus(Bivector2 other) {
        return new Rotor2(e0.plus(other.e0()), other.e1e2());
    }

    public Multivector2 plus(Multivector2 other) {
        return new Multivector2(e0.plus(other.e0()), other.e1(), other.e2(), other.e1e2());
    }

    public Rotor2 plus(Rotor2 other) {
        return new Rotor2(e0.plus(other.e0()), other.e1e2());
    }

    public Multivector3 plus(Vector3 other) {
        return new Multivector3(e0, other.e1(), other.e2(), other.e3(), E1E2.ZERO, E2E3.ZERO, E3E1.ZERO, E1E2E3.ZERO);
    }

    public Rotor3 plus(Bivector3 other) {
        return new Rotor3(e0, other.e1e2(), other.e2e3(), other.e3e1());
    }

    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(e0.plus(other.e0()), other.e1e2(), other.e2e3(), other.e3e1());
    }

    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(e0, E1.ZERO, E2.ZERO, E3.ZERO, E1E2.ZERO, E2E3.ZERO, E3E1.ZERO, other.e1e2e3());
    }

    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(e0.plus(other.e0()), other.e1(), other.e2(), other.e3(), other.e1e2(), other.e2e3(), other.e3e1(), other.e1e2e3());
    }

    public Multivector2 minus(Vector2 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor2 minus(Bivector2 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor2 minus(Rotor2 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector2 minus(Multivector2 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor3 minus(Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Trivector3 other) {
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

    public Vector3 inner(Vector3 other) {
        return new Vector3(e0.times(other.e1()), e0.times(other.e2()), e0.times(other.e3()));
    }

    public Bivector3 inner(Bivector3 other) {
        return new Bivector3(e0.times(other.e1e2()), e0.times(other.e2e3()), e0.times(other.e3e1()));
    }

    public Rotor3 inner(Rotor3 other) {
        return inner(other.scalar()).plus(inner(other.bivector()));
    }

    public Trivector3 inner(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

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

    public Scalar outer(Vector3 other) {
        return ZERO;
    }

    public Scalar outer(Bivector3 other) {
        return ZERO;
    }

    public Scalar outer(Rotor3 other) {
        return ZERO;
    }

    public Scalar outer(Trivector3 other) {
        return ZERO;
    }

    public Multivector3 outer(Multivector3 other) {
        return Multivector3.ZERO; // TODO: implement
    }

    @Override
    public Scalar times(double other) {
        return times(new Scalar(other));
    }

    @Override
    public Scalar times(Scalar other) {
        return new Scalar(this.e0.times(other.e0));
    }

    public Vector3 times(Vector3 other) {
        return new Vector3(e0.times(other.e1()), e0.times(other.e2()), e0.times(other.e3()));
    }

    public Bivector3 times(Bivector3 other) {
        return new Bivector3(e0.times(other.e1e2()), e0.times(other.e2e3()), e0.times(other.e3e1()));
    }

    public Rotor3 times(Rotor3 other) {
        return new Rotor3(this.times(other.scalar()), this.times(other.bivector()));
    }

    public Trivector3 times(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

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

    public Vector3 div(Vector3 other) {
        return this.times(other.inverse());
    }

    public Bivector3 div(Bivector3 other) {
        return this.times(other.inverse());
    }

    public Rotor3 div(Rotor3 other) {
        return this.times(other.inverse());
    }

    public Trivector3 div(Trivector3 other) {
        return this.times(other.inverse());
    }

    public Multivector3 div(Multivector3 other) {
        return this.times(other.inverse());
    }

    public Scalar pow(int exponent) {
        return new Scalar(Math.pow(e0.value(), exponent));
    }

    public Scalar pow(double exponent) {
        return new Scalar(Math.pow(e0.value(), exponent));
    }

    public Scalar pow(Scalar exponent) {
        return new Scalar(Math.pow(e0.value(), exponent.value()));
    }

    public Scalar sqrt() {
        return new Scalar(Math.sqrt(e0.value()));
    }

    public Scalar cbrt() {
        return new Scalar(Math.cbrt(e0.value()));
    }

    public Scalar exp() {
        return new Scalar(Math.exp(e0.value()));
    }

    public Scalar log() {
        return new Scalar(Math.log(e0.value()));
    }

    public Scalar log10() {
        return new Scalar(Math.log10(e0.value()));
    }

    public Scalar log1p() {
        return new Scalar(Math.log1p(e0.value()));
    }

    public Scalar log2() {
        return new Scalar(Math.log(e0.value()) / Math.log(2));
    }

    public Scalar sin() {
        return new Scalar(Math.sin(e0.value()));
    }

    public Scalar cos() {
        return new Scalar(Math.cos(e0.value()));
    }

    public Scalar tan() {
        return new Scalar(Math.tan(e0.value()));
    }

    public Scalar asin() {
        return new Scalar(Math.asin(e0.value()));
    }

    public Scalar acos() {
        return new Scalar(Math.acos(e0.value()));
    }

    public Scalar atan() {
        return new Scalar(Math.atan(e0.value()));
    }

    public Scalar sinh() {
        return new Scalar(Math.sinh(e0.value()));
    }

    public Scalar cosh() {
        return new Scalar(Math.cosh(e0.value()));
    }

    public Scalar tanh() {
        return new Scalar(Math.tanh(e0.value()));
    }
}
