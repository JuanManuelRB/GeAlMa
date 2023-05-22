package juanmanuel.gealma.basis;

public record E1(double value) implements Basis1<E1>, Blade1<E1> {
    public static final E1 ZERO = new E1(0);
    public static final E1 ONE = new E1(1);

    @Override
    public E1 plus(E1 other) {
        return new E1(value + other.value);
    }

    @Override
    public E1 unaryMinus() {
        return new E1(-value);
    }

    @Override
    public E1 minus(E1 other) {
        return new E1(value - other.value);
    }

    @Override
    public E1 times(double scalar) {
        return new E1(value * scalar);
    }

    @Override
    public E1 times(Blade0<?> other) {
        return new E1(value * other.value());
    }

    @Override
    public E1 inverse() {
        return new E1(1 / value);
    }

    @Override
    public E1 div(double scalar) {
        return new E1(value / scalar);
    }

    @Override
    public E1 div(Blade0<?> other) {
        return new E1(value / other.value());
    }

    @Override
    public E1 inc() {
        return new E1(value + 1);
    }

    @Override
    public E1 dec() {
        return new E1(value - 1);
    }

    @Override
    public E1 reverse() {
        return this;
    }

    @Override
    public E0 times(E1 other) {
        return new E0(value * other.value);
    }

    @Override
    public E0 div(E1 other) {
        return this.times(other.inverse());
    }

    public E1E2 times(E2 other) {
        return new E1E2(this.value * other.value());
    }

    public E3E1 times(E3 other) {
        return new E3E1(-this.value * other.value());
    }

    public E1E4 times(E4 other) {
        return new E1E4(this.value * other.value());
    }

    public E2 times(E1E2 other) {
        return new E2(this.value * other.value());
    }

    public E1E2E3 times(E2E3 other) {
        return new E1E2E3(this.value * other.value());
    }

    public E3 times(E3E1 other) {
        return new E3(-this.value * other.value());
    }

    public E4 times(E1E4 other) {
        return new E4(this.value * other.value());
    }

    public E4E1E2 times(E2E4 other) {
        return new E4E1E2(this.value * other.value());
    }

    public E3E4E1 times(E3E4 other) {
        return new E3E4E1(this.value * other.value());
    }

    public E2E3 times(E1E2E3 other) {
        return new E2E3(this.value * other.value());
    }

    public E1E2E3E4 times(E2E3E4 other) {
        return new E1E2E3E4(this.value * other.value());
    }

    public E3E4 times(E3E4E1 other) {
        return new E3E4(this.value * other.value());
    }

    public E2E4 times(E4E1E2 other) {
        return new E2E4(this.value * other.value());
    }

    public E2E3E4 times(E1E2E3E4 other) {
        return new E2E3E4(this.value * other.value());
    }

    @Override
    public int compareTo(E1 o) {
        return Double.compare(this.value, o.value);
    }
}
