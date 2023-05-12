package juanmanuel.gealma.basis;


public record E4(double value) implements Basis4<E4> {
    public static final E4 ZERO = new E4(0);
    public static final E4 ONE = new E4(1);

    @Override
    public E4 plus(E4 other) {
        return new E4(this.value + other.value);
    }

    @Override
    public E4 minus(E4 other) {
        return new E4(this.value - other.value);
    }

    @Override
    public E4 unaryMinus() {
        return new E4(-this.value);
    }

    @Override
    public E0 times(E4 other) {
        return new E0(this.value * other.value);
    }

    @Override
    public E4 times(double scalar) {
        return new E4(this.value * scalar);
    }

    @Override
    public E4 times(E0 other) {
        return new E4(this.value * other.value());
    }

    @Override
    public E4 inc() {
        return new E4(this.value + 1);
    }

    @Override
    public E4 dec() {
        return new E4(this.value - 1);
    }

    @Override
    public int compareTo(E4 o) {
        return Double.compare(this.value, o.value);
    }
}
