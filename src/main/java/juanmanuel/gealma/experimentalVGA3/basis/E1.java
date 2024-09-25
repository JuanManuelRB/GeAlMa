package juanmanuel.gealma.experimentalVGA3.basis;

import juanmanuel.gealma.experimentalVGA3.Scalar;
import org.jspecify.annotations.NullMarked;

@NullMarked
public record E1(double value) implements PositiveBase<E1>, Blade1 {

    @Override
    public byte basis() {
        return 0b1;
    }

    @Override
    public byte positiveBasisMask() {
        return 0b1;
    }

    @Override
    public boolean hasPositiveBase(int base) {
        return base == 1;
    }

    @Override
    public E1 plus(E1 other) {
        return new E1(value + other.value);
    }

    @Override
    public E1 unaryMinus() {
        return new E1(-value);
    }

    @Override
    public Scalar times(E1 other) {
        return new Scalar(value * other.value);
    }

    @Override
    public E1 inverse() {
        return new E1(1 / value);
    }

    @Override
    public E1 times(double scalar) {
        return new E1(value * scalar);
    }

    @Override
    public E1 times(Scalar scalar) {
        return new E1(value * scalar.value());
    }
}
