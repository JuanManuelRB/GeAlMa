package juanmanuel.gealma.nuevo;

public record E0(double value) implements Basis<E0> {
    public static final E0 ZERO = new E0(0);

    @Override
    public E0 plus(E0 other) {
        return new E0(this.value + other.value);
    }

    @Override
    public E0 minus(E0 other) {
        return new E0(this.value - other.value);
    }

    @Override
    public E0 times(double scalar) {
        return new E0(this.value * scalar);
    }

    @Override
    public E0 unaryMinus() {
        return new E0(-value);
    }

    @Override
    public E0 times(E0 other) {
        return new E0(this.value * other.value);
    }

    public E1 times(E1 other) {
        return new E1(this.value * other.value());
    }

    public E2 times(E2 other) {
        return new E2(this.value * other.value());
    }

    public E3 times(E3 other) {
        return new E3(this.value * other.value());
    }

    public E1E2 times(E1E2 other) {
        return new E1E2(this.value * other.value());
    }

    public E2E3 times(E2E3 other) {
        return new E2E3(this.value * other.value());
    }

    public E3E1 times(E3E1 other) {
        return new E3E1(this.value * other.value());
    }

    public E1E4 times(E1E4 other) {
        return new E1E4(this.value * other.value());
    }

    public E2E4 times(E2E4 other) {
        return new E2E4(this.value * other.value());
    }

    public E3E4 times(E3E4 other) {
        return new E3E4(this.value * other.value());
    }

    public E1E2E3 times(E1E2E3 other) {
        return new E1E2E3(this.value * other.value());
    }

    public E2E3E4 times(E2E3E4 other) {
        return new E2E3E4(this.value * other.value());
    }

    public E3E4E1 times(E3E4E1 other) {
        return new E3E4E1(this.value * other.value());
    }

    public E4E1E2 times(E4E1E2 other) {
        return new E4E1E2(this.value * other.value());
    }

    public E1E2E3E4 times(E1E2E3E4 other) {
        return new E1E2E3E4(this.value * other.value());
    }
}
