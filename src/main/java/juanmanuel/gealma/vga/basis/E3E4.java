package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.Blade;

import java.util.Objects;

public final class E3E4 extends Blade implements BladeDimension4<E3E4> {
    public static final E3E4 ZERO = new E3E4(0);
    public static final E3E4 ONE = new E3E4(1);

    public E3E4(double value) {
        super(value, (byte) 0b1100);
    }

    public E3E4 plus(E3E4 other) {
        return new E3E4(this.value() + other.value());
    }

    public E3E4 minus(E3E4 other) {
        return new E3E4(this.value() - other.value());
    }

    @Override
    public E3E4 times(double scalar) {
        return new E3E4(this.value() * scalar);
    }

    public E3E4 times(E0 other) {
        return times(other.value());
    }

    @Override
    public E0 times(E3E4 other) {
        return new E0(this.value() * other.value());
    }

    @Override
    public E3E4 inc() {
        return new E3E4(this.value() + 1);
    }

    @Override
    public E3E4 dec() {
        return new E3E4(this.value() - 1);
    }

    @Override
    public E3E4 inverse() {
        return new E3E4(1 / this.value());
    }

    @Override
    public E3E4 reverse() {
        return this.unaryMinus();
    }

    @Override
    public E3E4 unaryMinus() {
        return new E3E4(-this.value());
    }

    @Override
    public int compareTo(E3E4 o) {
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
        var that = (E3E4) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return StringTemplate.STR."E3E4[\{value()}";
    }

}
