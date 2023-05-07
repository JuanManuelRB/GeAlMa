package juanmanuel.gealma.nuevo;

public record E1E2E3(double value) implements Basis3<E1E2E3> {
    @Override
    public E1E2E3 plus(E1E2E3 other) {
        return null;
    }

    @Override
    public E1E2E3 minus(E1E2E3 other) {
        return null;
    }

    @Override
    public E1E2E3 times(double scalar) {
        return null;
    }

    @Override
    public E0 times(E1E2E3 other) {
        return null;
    }

    @Override
    public E1E2E3 times(E0 other) {
        return null;
    }

    @Override
    public E1E2E3 unaryMinus() {
        return null;
    }

    @Override
    public Basis<?> times(E1 other) {
        return null;
    }

    @Override
    public Basis<?> times(E2 other) {
        return null;
    }

    @Override
    public Basis<?> times(E3 other) {
        return null;
    }

    @Override
    public Basis<?> times(E1E2 other) {
        return null;
    }

    @Override
    public Basis<?> times(E2E3 other) {
        return null;
    }

    @Override
    public Basis<?> times(E3E1 other) {
        return null;
    }
}
