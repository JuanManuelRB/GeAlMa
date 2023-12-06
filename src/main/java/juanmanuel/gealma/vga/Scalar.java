package juanmanuel.gealma.vga;

import juanmanuel.gealma.Geometric;
import juanmanuel.gealma.vga.basis.vga.*;
import juanmanuel.gealma.vga.vga2.*;
import juanmanuel.gealma.vga.vga3.*;

public record Scalar(E0 e0) implements Geometric<Scalar> {
    public static final Scalar zero = new Scalar(E0.ZERO);
    public static final Scalar one = new Scalar(1);

    public Scalar(double e0) {
        this(new E0(e0));
    }

    public double value() {
        return e0.value();
    }

    public Scalar abs() {
        return new Scalar(absoluteValue());
    }

    public double absoluteValue() {
        return Math.abs(e0.value());
    }

    public Scalar squared() {
        return new Scalar(squaredValue());
    }

    public double squaredValue() {
        return e0.value() * e0.value();
    }

    @Override
    public Scalar unaryMinus() {
        return new Scalar(e0.unaryMinus());
    }

    @Override
    public Scalar reverse() {
        return this;
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

    @Override
    public Scalar inner(double other) {
        return this.times(other);
    }

    @Override
    public Scalar inner(Scalar other) {
        return this.times(other);
    }

    @Override
    public Scalar outer(double other) {
        return this.times(other);
    }

    @Override
    public Scalar outer(Scalar other) {
        return this.times(other);
    }

    @Override
    public Scalar times(double other) {
        return times(new Scalar(other));
    }

    @Override
    public Scalar times(Scalar other) {
        return new Scalar(e0.times(other.e0));
    }

    @Override
    public Scalar div(double other) {
        return div(new Scalar(other));
    }

    @Override
    public Scalar div(Scalar other) {
        return new Scalar(this.e0.value() / other.e0.value());
    }

    // Addition with other blades

    public Scalar plus(double other) {
        return new Scalar(e0.plus(other));
    }

    public Multivector2 plus(Vector2 other) {
        return new Multivector2(e0, other.e1(), other.e2(), E1E2.ZERO);
    }

    public Multivector3 plus(Vector3 other) {
        return new Multivector3(e0, other.e1(), other.e2(), other.e3(), E1E2.ZERO, E2E3.ZERO, E3E1.ZERO, E1E2E3.ZERO);
    }

    public Rotor2 plus(Bivector2 other) {
        return new Rotor2(e0.plus(other.e0()), other.e1e2());
    }

    public Rotor3 plus(Bivector3 other) {
        return new Rotor3(e0, other.e1e2(), other.e2e3(), other.e3e1());
    }

    public Rotor2 plus(Rotor2 other) {
        return new Rotor2(e0.plus(other.e0()), other.e1e2());
    }

    public Rotor3 plus(Rotor3 other) {
        return new Rotor3(e0.plus(other.e0()), other.e1e2(), other.e2e3(), other.e3e1());
    }

    public Multivector3 plus(Trivector3 other) {
        return new Multivector3(e0, E1.ZERO, E2.ZERO, E3.ZERO, E1E2.ZERO, E2E3.ZERO, E3E1.ZERO, other.e1e2e3());
    }

    public Multivector2 plus(Multivector2 other) {
        return new Multivector2(e0.plus(other.e0()), other.e1(), other.e2(), other.e1e2());
    }

    public Multivector3 plus(Multivector3 other) {
        return new Multivector3(e0.plus(other.e0()), other.e1(), other.e2(), other.e3(), other.e1e2(), other.e2e3(), other.e3e1(), other.e1e2e3());
    }

    // Subtraction with other blades

    public Multivector2 minus(Vector2 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Vector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor2 minus(Bivector2 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor3 minus(Bivector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor2 minus(Rotor2 other) {
        return this.plus(other.unaryMinus());
    }

    public Rotor3 minus(Rotor3 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Trivector3 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector2 minus(Multivector2 other) {
        return this.plus(other.unaryMinus());
    }

    public Multivector3 minus(Multivector3 other) {
        return this.plus(other.unaryMinus());
    }

    public <T extends Geometric2<?>> T times(T other) {
        return (T) switch (other) {
            case Vector2 v -> new Vector2(e0.times(v.e1()), e0.times(v.e2()));
            case Bivector2 b -> new Bivector2(e0.times(b.e1e2()));
            case Rotor2 r -> new Rotor2(e0.times(r.e0()), e0.times(r.e1e2()));
            case Multivector2 m -> new Multivector2(e0.times(m.e0()), e0.times(m.e1()), e0.times(m.e2()), e0.times(m.e1e2()));
        };
    }

    public <T extends Geometric3<?>> T times(T other) {
        return (T) switch (other) {
            case Vector3 v -> new Vector3(e0.times(v.e1()), e0.times(v.e2()), e0.times(v.e3()));
            case Bivector3 b -> new Bivector3(e0.times(b.e1e2()), e0.times(b.e2e3()), e0.times(b.e3e1()));
            case Rotor3 r -> new Rotor3(e0.times(r.e0()), e0.times(r.e1e2()), e0.times(r.e2e3()), e0.times(r.e3e1()));
            case Trivector3 t -> new Trivector3(e0.times(t.e1e2e3()));
            case Multivector3 m -> new Multivector3(e0.times(m.e0()), e0.times(m.e1()), e0.times(m.e2()), e0.times(m.e3()), e0.times(m.e1e2()), e0.times(m.e2e3()), e0.times(m.e3e1()), e0.times(m.e1e2e3()));
        };
    }

    public <T extends Geometric2<?>> T inner(T other) {
        return this.times(other);
    }

    public <T extends Geometric3<?>> T inner(T other) {
        return this.times(other);
    }

    public <T extends Geometric2<?>> T outer(T other) {
        return this.times(other);
    }

    public <T extends Geometric3<?>> T outer(T other) {
        return this.times(other);
    }

    // Inner product with other blades

    public Vector2 inner(Vector2 other) {
        return this.times(other);
    }

    public Vector3 inner(Vector3 other) {
        return this.times(other);
    }

    public Bivector2 inner(Bivector2 other) {
        return this.times(other);
    }

    public Bivector3 inner(Bivector3 other) {
        return this.times(other);
    }

    public Rotor2 inner(Rotor2 other) {
        return this.times(other);
    }

    public Rotor3 inner(Rotor3 other) {
        return this.times(other);
    }

    public Trivector3 inner(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

    public Multivector2 inner(Multivector2 other) {
        return this.times(other);
    }

    public Multivector3 inner(Multivector3 other) {
        return inner(other.scalar())
                .plus(inner(other.vector()))
                .plus(inner(other.bivector()))
                .plus(inner(other.trivector()));
    }

    // Outer product with other blades

    public Vector2 outer(Vector2 other) {
        return this.times(other);
    }

    public Vector3 outer(Vector3 other) {
        return this.times(other);
    }

    public Bivector2 outer(Bivector2 other) {
        return this.times(other);
    }

    public Bivector3 outer(Bivector3 other) {
        return this.times(other);
    }

    public Rotor2 outer(Rotor2 other) {
        return this.times(other);
    }

    public Rotor3 outer(Rotor3 other) {
        return this.times(other);
    }

    public Trivector3 outer(Trivector3 other) {
        return this.times(other);
    }

    public Multivector2 outer(Multivector2 other) {
        return this.times(other);
    }

    public Multivector3 outer(Multivector3 other) {
        return this.times(other);
    }

    // Geometric product with other blades

    public Vector2 times(Vector2 other) {
        return new Vector2(e0.times(other.e1()), e0.times(other.e2()));
    }

    public Vector3 times(Vector3 other) {
        var result = new double[Geometric3.vectorSpecies.length()];
        other.toVector().mul(e0.value()).intoArray(result, 0);
        return new Vector3(result[0], result[1], result[2]);
    }

    public Bivector2 times(Bivector2 other) {
        return new Bivector2(e0.times(other.e1e2()));
    }

    public Bivector3 times(Bivector3 other) {
        var result = new double[Geometric3.vectorSpecies.length()];
        other.toVector().mul(e0.value()).intoArray(result, 0);

        return new Bivector3(e0.times(other.e1e2()), e0.times(other.e2e3()), e0.times(other.e3e1()));
    }

    public Rotor2 times(Rotor2 other) {
        // TODO: Refactor this to use SIMD
        return new Rotor2(e0.times(other.e0()), e0.times(other.e1e2()));
    }

    public Rotor3 times(Rotor3 other) {
        var result = new double[Geometric3.vectorSpecies.length()];
        other.toVector().mul(e0.value()).intoArray(result, 0);
        return new Rotor3(result[0], result[1], result[2], result[3]);
    }

    public Trivector3 times(Trivector3 other) {
        return new Trivector3(e0.times(other.e1e2e3()));
    }

    public Multivector3 times(Multivector3 other) {
        var result = new double[Trivector3.vectorSpecies.length()];
        other.toVector().mul(e0.value()).intoArray(result, 0);
        return new Multivector3(result[0], result[1], result[2], result[3], result[4], result[5], result[6], result[7]);
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
        return new Scalar(Math.pow(e0.value(), exponent.e0.value()));
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

    @Override
    public String toString() {
        return "Scalar[" +
                "e0=" + e0.value() + ']';
    }
}
