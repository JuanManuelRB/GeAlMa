package juanmanuel.gealma.vga.basis;

import java.util.Objects;

public final class E4 implements BladeDimension4<E4> {
    public static final E4 ZERO = new E4(0);
    public static final E4 ONE = new E4(1);

    private final double value;

    public E4(double value) {
        this.value = value;
    }

    public E4 plus(E4 other) {
        return new E4(this.value() + other.value());
    }

    public E4 minus(E4 other) {
        return new E4(this.value() - other.value());
    }

    @Override
    public <E extends BladeDimension0<E>> E4 times(E scalar) {
        return new E4(value() * scalar.value());
    }

    @Override
    public E4 unaryMinus() {
        return new E4(-this.value());
    }

    @Override
    public E4 inverse() {
        return new E4(1 / this.value());
    }

    @Override
    public boolean containsBase(int n) {
        return n == 4;
    }

    @Override
    public E0 times(E4 other) {
        return new E0(this.value() * other.value());
    }

    @Override
    public E4 times(double scalar) {
        return new E4(this.value() * scalar);
    }

    public E4 times(E0 other) {
        return times(other.value());
    }

    @Override
    public E4 inc() {
        return new E4(this.value() + 1);
    }

    @Override
    public E4 dec() {
        return new E4(this.value() - 1);
    }

    @Override
    public E4 reverse() {
        return this;
    }

    @Override
    public int compareTo(E4 o) {
        return Double.compare(this.value(), o.value());
    }

    @Override
    public double value() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (E4) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return StringTemplate.STR."E4[\{value()}]";
    }

    @Override
    public byte positiveBasisMask() {
        return 0b1000;
    }

    @Override
    public boolean hasPositiveBase(int base) {
        return true;
    }

    @Override
    public boolean isNegativeQuadraticFormBase(int i) {
        return false;
    }

    @Override
    public boolean isZeroQuadraticFormBase(int i) {
        return false;
    }

    @Override
    public boolean containsBasis(int mask) {
        return mask == 8;
    }
}
