package juanmanuel.gealma.vga.basis.vga;

import juanmanuel.gealma.vga.basis.Basis4;
import juanmanuel.gealma.vga.basis.Blade3;

public record E2E3E4(double value) implements Basis4<E2E3E4>, Blade3<E2E3E4> {
    public static final E2E3E4 ZERO = new E2E3E4(0);
    public static final E2E3E4 ONE = new E2E3E4(1);

    @Override
    public E2E3E4 plus(E2E3E4 other) {
        return new E2E3E4(this.value + other.value);
    }

    @Override
    public E2E3E4 minus(E2E3E4 other) {
        return new E2E3E4(this.value - other.value);
    }

    @Override
    public E2E3E4 unaryMinus() {
        return new E2E3E4(-this.value);
    }

    @Override
    public E2E3E4 inverse() {
        return new E2E3E4(1 / this.value);
    }

    @Override
    public E0 times(E2E3E4 other) {
        return new E0(this.value * other.value);
    }

    @Override
    public E2E3E4 times(double scalar) {
        return new E2E3E4(this.value * scalar);
    }

    @Override
    public E2E3E4 inc() {
        return new E2E3E4(this.value + 1);
    }

    @Override
    public E2E3E4 dec() {
        return new E2E3E4(this.value - 1);
    }

    @Override
    public E2E3E4 reverse() {
        return this.unaryMinus();
    }

    @Override
    public int compareTo(E2E3E4 o) {
        return Double.compare(this.value, o.value);
    }
}
