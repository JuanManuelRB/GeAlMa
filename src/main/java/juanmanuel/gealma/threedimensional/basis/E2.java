package juanmanuel.gealma.threedimensional.basis;

public record E2(double value) implements Geometric3Basis {
    public static final E2 ZERO = new E2(0);

    public E2 plus(E2 other) {
        return new E2(this.value + other.value());
    }

    @Override
    public E2 unaryMinus() {
        return new E2(-value);

    }

    @Override
    public E2 times(E0 other) {
        return new E2(this.value * other.value());
    }

    @Override
    public E1E2 times(E1 other) {
        return new E1E2(-this.value * other.value());
    }

    @Override
    public E0 times(E2 other) {
        return new E0(this.value * other.value());
    }

    @Override
    public E2E3 times(E3 other) {
        return new E2E3(this.value * other.value());
    }

    @Override
    public E1 times(E1E2 other) {
        return new E1(-this.value * other.value());
    }

    @Override
    public E3 times(E2E3 other) {
        return new E3(this.value * other.value());
    }

    @Override
    public E1E2E3 times(E3E1 other) {
        return new E1E2E3(this.value * other.value());
    }

    @Override
    public E3E1 times(E1E2E3 other) {
        return new E3E1(this.value * other.value());
    }
}