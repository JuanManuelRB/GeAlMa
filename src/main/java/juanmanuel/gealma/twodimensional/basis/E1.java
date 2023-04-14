package juanmanuel.gealma.twodimensional.basis;

public record E1(double value) implements Geometric2Basis {
    public static final E1 ZERO = new E1(0);

    public E1 plus(E1 other) {
        return new E1(this.value + other.value);
    }

    @Override
    public E1 unaryMinus() {
        return new E1(-value);

    }

    @Override
    public E1 times(E0 other) {
        return new E1(this.value * other.value());
    }

    @Override
    public E0 times(E1 other) {
        return new E0(this.value * other.value());
    }

    @Override
    public E1E2 times(E2 other) {
        return new E1E2(this.value * other.value());
    }

    @Override
    public E2 times(E1E2 other) {
        return new E2(this.value * other.value());
    }

}
