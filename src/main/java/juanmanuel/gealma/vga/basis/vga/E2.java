package juanmanuel.gealma.vga.basis.vga;

import juanmanuel.gealma.vga.basis.Basis2;
import juanmanuel.gealma.vga.basis.Blade1;

public record E2(double value) implements Basis2<E2>, Blade1<E2> {
    public static final E2 ZERO = new E2(0);
    public static final E2 ONE = new E2(1);

    @Override
    public E2 plus(E2 other) {
        return new E2(value + other.value);
    }

    @Override
    public E2 minus(E2 other) {
        return new E2(value - other.value);
    }

    @Override
    public E2 unaryMinus() {
        return new E2(-value);
    }

    @Override
    public E2 times(double scalar) {
        return new E2(value * scalar);
    }


    @Override
    public E2 inverse() {
        return new E2(1 / value);
    }

    @Override
    public E2 inc() {
        return new E2(value + 1);
    }

    @Override
    public E2 dec() {
        return new E2(value - 1);
    }

    @Override
    public E2 reverse() {
        return this;
    }

    @Override
    public E0 times(E2 other) {
        return new E0(value * other.value);
    }

    public E1E2 times(E1 other) {
        return new E1E2(-this.value * other.value());
    }

    public E2E3 times(E3 other) {
        return new E2E3(this.value * other.value());
    }

    public E2E4 times(E4 other) {
        return new E2E4(this.value * other.value());
    }

    public E1 times(E1E2 other) {
        return new E1(-this.value * other.value());
    }

    public E3 times(E2E3 other) {
        return new E3(this.value * other.value());
    }

    public E1E2E3 times(E3E1 other) {
        return new E1E2E3(this.value * other.value());
    }

    public E4E1E2 times(E1E4 other) {
        return new E4E1E2(-this.value * other.value());
    }

    public E4 times(E2E4 other) {
        return new E4(this.value * other.value());
    }

    public E2E3E4 times(E3E4 other) {
        return new E2E3E4(this.value * other.value());
    }

    public E3E1 times(E1E2E3 other) {
        return new E3E1(this.value * other.value());
    }

    public E3E4 times(E2E3E4 other) {
        return new E3E4(this.value * other.value());
    }

    public E1E2E3E4 times(E3E4E1 other) {
        return new E1E2E3E4(-this.value * other.value());
    }

    public E1E4 times(E4E1E2 other) {
        return new E1E4(this.value * other.value());
    }

    public E3E4E1 times(E1E2E3E4 other) {
        return new E3E4E1(-this.value * other.value());
    }

    @Override
    public int compareTo(E2 o) {
        return Double.compare(value, o.value);
    }
}
