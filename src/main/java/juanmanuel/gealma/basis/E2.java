package juanmanuel.gealma.nuevo;

public record E2(double value) implements Basis2<E2> {
    @Override
    public E2 plus(E2 other) {
        return new E2(value + other.value);
    }

    @Override
    public E2 minus(E2 other) {
        return new E2(value - other.value);
    }

    @Override
    public E2 times(double scalar) {
        return new E2(value * scalar);
    }

    @Override
    public E0 times(E2 other) {
        return new E0(value * other.value);
    }

    @Override
    public E2E3 times(E3 other) {
        return new E2E3(value * other.value());
    }

    @Override
    public E1 times(E1E2 other) {
        return new E1(-value * other.value());
    }

    @Override
    public E3 times(E2E3 other) {
        return new E3(value * other.value());
    }

    @Override
    public E1E2E3 times(E3E1 other) {
        return new E1E2E3(-value * other.value());
    }

    @Override
    public E3E1 times(E1E2E3 other) {
        return new E3E1(value * other.value());
    }

    @Override
    public E2 times(E0 other) {
        return new E2(value * other.value());
    }

    @Override
    public E2 unaryMinus() {
        return new E2(-value);
    }

    @Override
    public E1E2 times(E1 other) {
        return new E1E2(-value * other.value());
    }
}
