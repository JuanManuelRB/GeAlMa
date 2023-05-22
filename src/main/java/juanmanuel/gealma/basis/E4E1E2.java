package juanmanuel.gealma.basis;

public record E4E1E2(double value) implements Basis4<E4E1E2>, Blade3<E4E1E2> {
    public static final E4E1E2 ZERO = new E4E1E2(0);
    public static final E4E1E2 ONE = new E4E1E2(1);

    @Override
    public E4E1E2 plus(E4E1E2 other) {
        return new E4E1E2(this.value + other.value);
    }

    @Override
    public E4E1E2 minus(E4E1E2 other) {
        return new E4E1E2(this.value - other.value);
    }

    @Override
    public E4E1E2 times(double scalar) {
        return new E4E1E2(this.value * scalar);
    }

    @Override
    public E0 times(E4E1E2 other) {
        return new E0(this.value * other.value);
    }

    @Override
    public E4E1E2 inc() {
        return new E4E1E2(this.value + 1);
    }

    @Override
    public E4E1E2 dec() {
        return new E4E1E2(this.value - 1);
    }

    @Override
    public E4E1E2 reverse() {
        return this.unaryMinus();
    }

    @Override
    public E4E1E2 unaryMinus() {
        return new E4E1E2(-this.value);
    }

    @Override
    public E4E1E2 inverse() {
        return new E4E1E2(1 / this.value);
    }

    @Override
    public int compareTo(E4E1E2 o) {
        return Double.compare(this.value, o.value);
    }
}
