package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.Blade;

import java.util.Objects;

public final class E1E4 extends Blade implements BladeDimension4<E1E4> {
    public static final E1E4 ZERO = new E1E4(0);
    public static final E1E4 ONE = new E1E4(1);

    public E1E4(double value) {
        super(value, (byte) 0b1001);
    }

    public E1E4 plus(E1E4 other) {
        return new E1E4(this.value() + other.value());
    }

    public E1E4 minus(E1E4 other) {
        return new E1E4(this.value() - other.value());
    }

    @Override
    public E1E4 unaryMinus() {
        return new E1E4(-this.value());
    }

    @Override
    public E1E4 inverse() {
        return new E1E4(1 / this.value());
    }

    @Override
    public E0 times(E1E4 other) {
        return new E0(this.value() * other.value());
    }

    @Override
    public E1E4 times(double scalar) {
        return new E1E4(this.value() * scalar);
    }

    public E1E4 times(E0 other) {
        return times(other.value());
    }

    @Override
    public E1E4 inc() {
        return new E1E4(this.value() + 1);
    }

    @Override
    public E1E4 dec() {
        return new E1E4(this.value() - 1);
    }

    @Override
    public E1E4 reverse() {
        return this.unaryMinus();
    }

    @Override
    public int compareTo(E1E4 o) {
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
        var that = (E1E4) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return StringTemplate.STR."E1E4[\{value()}]";
    }

}
