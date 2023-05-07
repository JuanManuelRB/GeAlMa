package juanmanuel.gealma.nuevo;

public record E1E4(double value) implements Basis4<E1E4> {
    @Override
    public E1E4 plus(E1E4 other) {
        return null;
    }

    @Override
    public E1E4 minus(E1E4 other) {
        return null;
    }

    @Override
    public E1E4 times(double scalar) {
        return null;
    }

    @Override
    public E0 times(E1E4 other) {
        return null;
    }

    @Override
    public E1E4 times(E0 other) {
        return null;
    }

    @Override
    public E1E4 unaryMinus() {
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

    @Override
    public Basis<?> times(E1E2E3 other) {
        return null;
    }
}
