package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.Blade;

import java.util.Objects;

public final class E2E4 extends Blade implements BladeDimension4<E2E4> {
    public static final E2E4 ZERO = new E2E4(0);
    public static final E2E4 ONE = new E2E4(1);

    public E2E4(double value) {
        super(value, (byte) 0b1010);
    }

    public E2E4 plus(E2E4 other) {
        return new E2E4(this.value() + other.value());
    }

    public E2E4 minus(E2E4 other) {
        return new E2E4(this.value() - other.value());
    }

    @Override
    public E2E4 unaryMinus() {
        return new E2E4(-this.value());
    }

    @Override
    public E2E4 inverse() {
        return new E2E4(1 / this.value());
    }

    @Override
    public E0 times(E2E4 other) {
        return new E0(this.value() * other.value());
    }

    @Override
    public E2E4 times(double scalar) {
        return new E2E4(this.value() * scalar);
    }

    public E2E4 times(E0 other) {
        return times(other.value());
    }

    @Override
    public E2E4 inc() {
        return new E2E4(this.value() + 1);
    }

    @Override
    public E2E4 dec() {
        return new E2E4(this.value() - 1);
    }

    @Override
    public E2E4 reverse() {
        return this.unaryMinus();
    }

    @Override
    public int compareTo(E2E4 o) {
        return Double.compare(this.value(), o.value());
    }

    @Override
    public double value() {
        return super.value();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (E2E4) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return StringTemplate.STR."E2E4[\{value()}";
    }

}
