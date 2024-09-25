package juanmanuel.gealma.vga.basis;

import java.util.Objects;

public record E2(double value) implements BladeDimension2<E2> {
    public static final E2 ZERO = new E2(0);
    public static final E2 ONE = new E2(1);

    public E2 plus(E2 other) {
        return new E2(value() + other.value());
    }

    public E2 minus(E2 other) {
        return new E2(value() - other.value());
    }

    @Override
    public <E extends BladeDimension0<E>> E2 times(E scalar) {
        return null;
    }

    @Override
    public E2 unaryMinus() {
        return new E2(-value());
    }

    @Override
    public E2 times(double scalar) {
        return new E2(value() * scalar);
    }

    public E2 times(E0 other) {
        return times(other.value());
    }

    @Override
    public E2 inverse() {
        return new E2(1 / value());
    }

    @Override
    public E2 inc() {
        return new E2(value() + 1);
    }

    @Override
    public E2 dec() {
        return new E2(value() - 1);
    }

    @Override
    public E2 reverse() {
        return this;
    }

    @Override
    public E0 times(E2 other) {
        return new E0(value() * other.value());
    }

    public E1E2 times(E1 other) {
        return new E1E2(-this.value() * other.value());
    }

    public E2E3 times(E3 other) {
        return new E2E3(this.value() * other.value());
    }

    public E2E4 times(E4 other) {
        return new E2E4(this.value() * other.value());
    }

    public E1 times(E1E2 other) {
        return new E1(-this.value() * other.value());
    }

    public E3 times(E2E3 other) {
        return new E3(this.value() * other.value());
    }

    public E1E2E3 times(E3E1 other) {
        return new E1E2E3(this.value() * other.value());
    }

    public E4E1E2 times(E1E4 other) {
        return new E4E1E2(-this.value() * other.value());
    }

    public E4 times(E2E4 other) {
        return new E4(this.value() * other.value());
    }

    public E2E3E4 times(E3E4 other) {
        return new E2E3E4(this.value() * other.value());
    }

    public E3E1 times(E1E2E3 other) {
        return new E3E1(this.value() * other.value());
    }

    public E3E4 times(E2E3E4 other) {
        return new E3E4(this.value() * other.value());
    }

    public E1E2E3E4 times(E3E4E1 other) {
        return new E1E2E3E4(-this.value() * other.value());
    }

    public E1E4 times(E4E1E2 other) {
        return new E1E4(this.value() * other.value());
    }

    public E3E4E1 times(E1E2E3E4 other) {
        return new E3E4E1(-this.value() * other.value());
    }

    @Override
    public E2 div(double scalar) {
        return new E2(value() / scalar);
    }

    @Override
    public boolean containsBase(int n) {
        return false;
    }

    @Override
    public E0 div(E2 other) {
        return times(other.inverse());
    }

    @Override
    public int compareTo(E2 o) {
        return Double.compare(value(), o.value());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (E2) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return StringTemplate.STR."E2[\{value()}]";
    }

    @Override
    public byte positiveBasisMask() {
        return 2;
    }

    @Override
    public boolean hasPositiveBase(int base) {
        return base == 2;
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
        return mask == 2;
    }
}
