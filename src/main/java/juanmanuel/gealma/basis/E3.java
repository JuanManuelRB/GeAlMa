package juanmanuel.gealma.basis;

public record E3(double value) implements Basis3<E3>, Blade1<E3> {
    public static final E3 ZERO = new E3(0);
    public static final E3 ONE = new E3(1);

    @Override
    public E3 plus(E3 other) {
        return new E3(this.value + other.value);
    }

    @Override
    public E3 minus(E3 other) {
        return new E3(this.value - other.value);
    }

    @Override
    public E3 unaryMinus() {
        return new E3(-this.value);
    }

    @Override
    public E3 inverse() {
        return new E3(1 / this.value);
    }

    @Override
    public E3 inc() {
        return new E3(this.value + 1);
    }

    @Override
    public E3 dec() {
        return new E3(this.value - 1);
    }

    @Override
    public E3 reverse() {
        return this;
    }

    @Override
    public E3 times(double scalar) {
        return new E3(this.value * scalar);
    }

    public E3E1 times(E1 other) {
        return new E3E1(this.value * other.value());
    }

    public E2E3 times(E2 other) {
        return new E2E3(this.value * other.value());
    }

    @Override
    public E0 times(E3 other) {
        return new E0(this.value * other.value);
    }

    public E3E4 times(E4 other) {
        return new E3E4(this.value * other.value());
    }

    public E1E2E3 times(E1E2 other) {
        return new E1E2E3(this.value * other.value());
    }

    public E2 times(E2E3 other) {
        return new E2(-this.value * other.value());
    }

    public E1 times(E3E1 other) {
        return new E1(this.value * other.value());
    }

    public E3E4E1 times(E1E4 other) {
        return new E3E4E1(-this.value * other.value());
    }

    public E2E3E4 times(E2E4 other) {
        return new E2E3E4(-this.value * other.value());
    }

    public E4 times(E3E4 other) {
        return new E4(this.value * other.value());
    }

    public E1E2 times(E1E2E3 other) {
        return new E1E2(this.value * other.value());
    }

    public E2E4 times(E2E3E4 other) {
        return new E2E4(-this.value * other.value());
    }

    public E1E4 times(E3E4E1 other) {
        return new E1E4(-this.value * other.value());
    }

    public E1E2E3E4 times(E4E1E2 other) {
        return new E1E2E3E4(this.value * other.value());
    }

    public E4E1E2 times(E1E2E3E4 other) {
        return new E4E1E2(this.value * other.value());
    }

    @Override
    public int compareTo(E3 o) {
        return Double.compare(this.value, o.value);
    }
}
