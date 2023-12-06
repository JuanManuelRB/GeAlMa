package juanmanuel.gealma.vga.basis.vga;

import juanmanuel.gealma.vga.basis.Basis4;
import juanmanuel.gealma.vga.basis.Blade2;

public record E1E4(double value) implements Basis4<E1E4>, Blade2<E1E4> {
    public static final E1E4 ZERO = new E1E4(0);
    public static final E1E4 ONE = new E1E4(1);

    @Override
    public E1E4 plus(E1E4 other) {
        return new E1E4(this.value + other.value);
    }

    @Override
    public E1E4 minus(E1E4 other) {
        return new E1E4(this.value - other.value);
    }

    @Override
    public E1E4 unaryMinus() {
        return new E1E4(-this.value);
    }

    @Override
    public E1E4 inverse() {
        return new E1E4(1 / this.value);
    }

    @Override
    public E0 times(E1E4 other) {
        return new E0(this.value * other.value);
    }

    @Override
    public E1E4 times(double scalar) {
        return new E1E4(this.value * scalar);
    }

    @Override
    public E1E4 inc() {
        return new E1E4(this.value + 1);
    }

    @Override
    public E1E4 dec() {
        return new E1E4(this.value - 1);
    }

    @Override
    public E1E4 reverse() {
        return this.unaryMinus();
    }

    @Override
    public int compareTo(E1E4 o) {
        return Double.compare(this.value, o.value);
    }
}