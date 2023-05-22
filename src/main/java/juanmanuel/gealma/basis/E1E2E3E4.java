package juanmanuel.gealma.basis;

public record E1E2E3E4(double value) implements Basis4<E1E2E3E4>, Blade4<E1E2E3E4> {

    @Override
    public E1E2E3E4 plus(E1E2E3E4 other) {
        return new E1E2E3E4(this.value + other.value);
    }

    @Override
    public E1E2E3E4 minus(E1E2E3E4 other) {
        return new E1E2E3E4(this.value - other.value);
    }

    @Override
    public E1E2E3E4 unaryMinus() {
        return new E1E2E3E4(-this.value);
    }

    @Override
    public E1E2E3E4 inverse() {
        return new E1E2E3E4(1 / this.value);
    }

    @Override
    public E0 times(E1E2E3E4 other) {
        return new E0(this.value * other.value);
    }

    @Override
    public E1E2E3E4 times(double scalar) {
        return new E1E2E3E4(this.value * scalar);
    }

    @Override
    public E1E2E3E4 inc() {
        return new E1E2E3E4(this.value + 1);
    }

    @Override
    public E1E2E3E4 dec() {
        return new E1E2E3E4(this.value - 1);
    }

    @Override
    public E1E2E3E4 reverse() {
        return this;
    }

    @Override
    public int compareTo(E1E2E3E4 o) {
        return Double.compare(this.value, o.value);
    }
}
