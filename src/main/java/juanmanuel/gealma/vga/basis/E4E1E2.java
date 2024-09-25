package juanmanuel.gealma.vga.basis;


import juanmanuel.gealma.Blade;

import java.util.Objects;

public final class E4E1E2 extends Blade implements BladeDimension4<E4E1E2> {
    public static final E4E1E2 ZERO = new E4E1E2(0);
    public static final E4E1E2 ONE = new E4E1E2(1);

    public E4E1E2(double value) {
        super(value, (byte) 0b1011);
    }

    public E4E1E2 plus(E4E1E2 other) {
        return new E4E1E2(this.value() + other.value());
    }

    public E4E1E2 minus(E4E1E2 other) {
        return new E4E1E2(this.value() - other.value());
    }

    @Override
    public E4E1E2 times(double scalar) {
        return new E4E1E2(this.value() * scalar);
    }

    @Override
    public E0 times(E4E1E2 other) {
        return new E0(this.value() * other.value());
    }

    @Override
    public E4E1E2 inc() {
        return new E4E1E2(this.value() + 1);
    }

    @Override
    public E4E1E2 dec() {
        return new E4E1E2(this.value() - 1);
    }

    @Override
    public E4E1E2 reverse() {
        return this.unaryMinus();
    }

    @Override
    public E4E1E2 unaryMinus() {
        return new E4E1E2(-this.value());
    }

    @Override
    public E4E1E2 inverse() {
        return new E4E1E2(1 / this.value());
    }

    @Override
    public int compareTo(E4E1E2 o) {
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
        var that = (E4E1E2) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return StringTemplate.STR."E4E1E2[\{value()}";
    }

}
