package juanmanuel.gealma.vga.basis.vga;

import juanmanuel.gealma.vga.basis.Basis4;
import juanmanuel.gealma.vga.basis.Blade3;

public record E3E4E1(double value) implements Basis4<E3E4E1>, Blade3<E3E4E1> {
    public static final E3E4E1 ZERO = new E3E4E1(0);
    public static final E3E4E1 ONE = new E3E4E1(1);

    @Override
    public E3E4E1 plus(E3E4E1 other) {
        return new E3E4E1(this.value + other.value);
    }

    @Override
    public E3E4E1 minus(E3E4E1 other) {
        return new E3E4E1(this.value - other.value);
    }

    @Override
    public E3E4E1 times(double scalar) {
        return new E3E4E1(this.value * scalar);
    }

    @Override
    public E0 times(E3E4E1 other) {
        return new E0(this.value * other.value);
    }

    @Override
    public E3E4E1 inc() {
        return new E3E4E1(this.value + 1);
    }

    @Override
    public E3E4E1 dec() {
        return new E3E4E1(this.value - 1);
    }

    @Override
    public E3E4E1 reverse() {
        return this.unaryMinus();
    }

    @Override
    public E3E4E1 unaryMinus() {
        return new E3E4E1(-this.value);
    }

    @Override
    public E3E4E1 inverse() {
        return new E3E4E1(1 / this.value);
    }

    @Override
    public int compareTo(E3E4E1 o) {
        return Double.compare(this.value, o.value);
    }
}

