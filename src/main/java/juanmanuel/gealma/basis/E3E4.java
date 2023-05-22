package juanmanuel.gealma.basis;

public record E3E4(double value) implements Basis4<E3E4>, Blade2<E3E4> {
    public static final E3E4 ZERO = new E3E4(0);
    public static final E3E4 ONE = new E3E4(1);

    @Override
    public E3E4 plus(E3E4 other) {
        return new E3E4(this.value + other.value);
    }

    @Override
    public E3E4 minus(E3E4 other) {
        return new E3E4(this.value - other.value);
    }

    @Override
    public E3E4 times(double scalar) {
        return new E3E4(this.value * scalar);
    }

    @Override
    public E0 times(E3E4 other) {
        return new E0(this.value * other.value);
    }

    @Override
    public E3E4 inc() {
        return new E3E4(this.value + 1);
    }

    @Override
    public E3E4 dec() {
        return new E3E4(this.value - 1);
    }

    @Override
    public E3E4 inverse() {
        return new E3E4(1 / this.value);
    }

    @Override
    public E3E4 reverse() {
        return this.unaryMinus();
    }

    @Override
    public E3E4 unaryMinus() {
        return new E3E4(-this.value);
    }

    @Override
    public int compareTo(E3E4 o) {
        return Double.compare(this.value, o.value);
    }
}
