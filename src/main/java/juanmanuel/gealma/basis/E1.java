package juanmanuel.gealma.nuevo;

public record E1(double value) implements Basis1<E1> {
    @Override
    public E1 plus(E1 other) {
        return new E1(value + other.value);
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
    public E0 times(E1 other) {
        return new E0(value * other.value);
    }

    @Override
    public E1 times(E0 other) {
        return new E1(value * other.value());
    }

    @Override
    public E1 unaryMinus() {
        return new E1(-value);
    }

    public E1E2 times(E2 other) {
        return new E1E2(value * other.value());
    }

    @Override
    public E3E1 times(E3 other) {
        return new E3E1(-value * other.value());
    }

    @Override
    public E2 times(E1E2 other) {
        return new E2(value * other.value());
    }

    @Override
    public E1E2E3 times(E2E3 other) {
        return new E1E2E3(value * other.value());
    }

    @Override
    public E3 times(E3E1 other) {
        return new E3(-value * other.value());
    }

    @Override
    public E2E3 times(E1E2E3 other) {
        return new E2E3(value * other.value());
    }
}
