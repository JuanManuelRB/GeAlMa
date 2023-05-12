package juanmanuel.gealma.basis;

public record E1E2(double value) implements Basis2<E1E2> {
    public static final E1E2 ZERO = new E1E2(0);
    public static final E1E2 ONE = new E1E2(1);

    @Override
    public E1E2 plus(E1E2 other) {
        return new E1E2(this.value + other.value);
    }

    @Override
    public E1E2 minus(E1E2 other) {
        return new E1E2(this.value - other.value);
    }

    @Override
    public E1E2 unaryMinus() {
        return new E1E2(-this.value);
    }

    @Override
    public E1E2 inc() {
        return new E1E2(this.value + 1);
    }

    @Override
    public E1E2 dec() {
        return new E1E2(this.value - 1);
    }

    @Override
    public E1E2 times(double scalar) {
        return new E1E2(this.value * scalar);
    }

    @Override
    public E1E2 times(E0 other) {
        return new E1E2(this.value * other.value());
    }

    public E2 times(E1 other) {
        return new E2(-this.value * other.value());
    }

    public E1 times(E2 other) {
        return new E1(this.value * other.value());
    }

    public E1E2E3 times(E3 other) {
        return new E1E2E3(this.value * other.value());
    }

    public E4E1E2 times(E4 other) {
        return new E4E1E2(this.value * other.value());
    }

    @Override
    public E0 times(E1E2 other) {
        return new E0(-this.value * other.value());
    }

    public E3E1 times(E2E3 other) {
        return new E3E1(this.value * other.value());
    }

    public E2E3 times(E3E1 other) {
        return new E2E3(this.value * other.value());
    }

    public E2E4 times(E1E4 other) {
        return new E2E4(-this.value * other.value());
    }

    public E1E4 times(E2E4 other) {
        return new E1E4(this.value * other.value());
    }

    public E1E2E3E4 times(E3E4 other) {
        return new E1E2E3E4(this.value * other.value());
    }

    public E3 times(E1E2E3 other) {
        return new E3(-this.value * other.value());
    }

    public E3E4E1 times(E2E3E4 other) {
        return new E3E4E1(this.value * other.value());
    }

    public E2E3E4 times(E3E4E1 other) {
        return new E2E3E4(-this.value * other.value());
    }

    public E4 times(E4E1E2 other) {
        return new E4(-this.value * other.value());
    }

    public E3E4 times(E1E2E3E4 other) {
        return new E3E4(-this.value * other.value());
    }

    @Override
    public int compareTo(E1E2 o) {
        return Double.compare(this.value, o.value);
    }
}
