package juanmanuel.gealma.vga.basis;

import java.util.Objects;

public record E0(double value) implements BladeDimension0<E0>, Grade.Grade0<E0> {
    public static final E0 ZERO = new E0(0);
    public static final E0 ONE = new E0(1);

    public E0 plus(E0 other) {
        return new E0(this.value() + other.value());
    }

    public E0 plus(double value) {
        return new E0(this.value() + value);
    }

    public E0 minus(E0 other) {
        return new E0(this.value() - other.value());
    }

    public E0 minus(double value) {
        return new E0(this.value() - value);
    }

    @Override
    public E0 unaryMinus() {
        return new E0(-value());
    }

    @Override
    public E0 inc() {
        return new E0(this.value() + 1);
    }

    @Override
    public E0 dec() {
        return new E0(this.value() - 1);
    }

    @Override
    public boolean containsBasis(int mask) {
        return mask == 0;
    }

    @Override
    public E0 reverse() {
        return this;
    }

    @Override
    public E0 times(double scalar) {
        return new E0(this.value() * scalar);
    }

    @Override
    public E0 times(Grade0<?> scalar) {
        return null;
    }

    @Override
    public E0 inverse() {
        return new E0(1 / this.value());
    }

    public E0 times(E0 other) {
        return new E0(this.value() * other.value());
    }

    @Override
    public E0 div(E0 other) {
        return times(other.inverse());
    }

    @Override
    public E0 div(double scalar) {
        return new E0(this.value() / scalar);
    }

    @Override
    public E0 div(Grade0 scalar) {
        return null;
    }

    public E1 times(E1 other) {
        return new E1(this.value() * other.value());
    }

    public E2 times(E2 other) {
        return new E2(this.value() * other.value());
    }

    public E3 times(E3 other) {
        return new E3(this.value() * other.value());
    }

    public E4 times(E4 other) {
        return new E4(this.value() * other.value());
    }

    public E1E2 times(E1E2 other) {
        return new E1E2(this.value() * other.value());
    }

    public E2E3 times(E2E3 other) {
        return new E2E3(this.value() * other.value());
    }

    public E3E1 times(E3E1 other) {
        return new E3E1(this.value() * other.value());
    }

    public E1E4 times(E1E4 other) {
        return new E1E4(this.value() * other.value());
    }

    public E2E4 times(E2E4 other) {
        return new E2E4(this.value() * other.value());
    }

    public E3E4 times(E3E4 other) {
        return new E3E4(this.value() * other.value());
    }

    public E1E2E3 times(E1E2E3 other) {
        return new E1E2E3(this.value() * other.value());
    }

    public E2E3E4 times(E2E3E4 other) {
        return new E2E3E4(this.value() * other.value());
    }

    public E3E4E1 times(E3E4E1 other) {
        return new E3E4E1(this.value() * other.value());
    }

    public E4E1E2 times(E4E1E2 other) {
        return new E4E1E2(this.value() * other.value());
    }

    public E1E2E3E4 times(E1E2E3E4 other) {
        return new E1E2E3E4(this.value() * other.value());
    }

    @Override
    public int compareTo(E0 o) {
        return Double.compare(this.value(), o.value());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (E0) obj;
        return Double.doubleToLongBits(this.value()) == Double.doubleToLongBits(that.value());
    }

    @Override
    public String toString() {
        return STR."E0[\{value()}]";
    }

    @Override
    public <E extends BladeDimension0<E>> E0 times(E scalar) {
        return times(scalar.value());
    }

    @Override
    public <E extends BladeDimension0<E>> E0 div(E scalar) {
        return new E0(value() / scalar.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }


    @Override
    public byte positiveBasisMask() {
        return 0;
    }

    @Override
    public boolean hasPositiveBase(int i) {
        return false;
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
    public boolean containsBase(int n) {
        return false;
    }
}
