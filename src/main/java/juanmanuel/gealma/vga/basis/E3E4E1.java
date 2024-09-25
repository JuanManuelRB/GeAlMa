package juanmanuel.gealma.vga.basis;


import juanmanuel.gealma.Blade;

import java.util.Objects;

public final class E3E4E1 extends Blade implements BladeDimension4<E3E4E1> {
    public static final E3E4E1 ZERO = new E3E4E1(0);
    public static final E3E4E1 ONE = new E3E4E1(1);

    public E3E4E1(double value) {
        super(value, (byte) 0b1101);
    }

    public E3E4E1 plus(E3E4E1 other) {
        return new E3E4E1(this.value() + other.value());
    }

    public E3E4E1 minus(E3E4E1 other) {
        return new E3E4E1(this.value() - other.value());
    }

    @Override
    public E3E4E1 times(double scalar) {
        return new E3E4E1(this.value() * scalar);
    }

    @Override
    public E0 times(E3E4E1 other) {
        return new E0(this.value() * other.value());
    }

    @Override
    public E3E4E1 inc() {
        return new E3E4E1(this.value() + 1);
    }

    @Override
    public E3E4E1 dec() {
        return new E3E4E1(this.value() - 1);
    }

    @Override
    public E3E4E1 reverse() {
        return this.unaryMinus();
    }

    @Override
    public E3E4E1 unaryMinus() {
        return new E3E4E1(-this.value());
    }

    @Override
    public E3E4E1 inverse() {
        return new E3E4E1(1 / this.value());
    }

    @Override
    public int compareTo(E3E4E1 o) {
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
        var that = (E3E4E1) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return StringTemplate.STR."E3E4E1[\{value()}";
    }

}

