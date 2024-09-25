package juanmanuel.gealma.vga;

import juanmanuel.gealma.experimentalVGA3.basis.PositiveBase;

public non-sealed class PositiveBlade implements PositiveBase<PositiveBlade> {
    private final double value;
    private final byte positiveMask;

    public PositiveBlade(double value, byte positiveMask) {
        this.value = value;
        this.positiveMask = positiveMask;
    }

    @Override
    public double value() {
        return value;
    }

    @Override
    public byte positiveBasisMask() {
        return positiveMask;
    }

    @Override
    public PositiveBlade reverse() {
        var n = baseCount();
        return new PositiveBlade(
                value * (double) (((n * (n - 1)) / 2) % 2 * 2) - 1, // Calculate the sign of the reverse
                positiveMask
        );
    }

    @Override
    public PositiveBlade inc() {
        return new PositiveBlade(value + 1, positiveMask);
    }

    @Override
    public PositiveBlade dec() {
        return new PositiveBlade(value - 1, positiveMask);
    }

    @Override
    public PositiveBlade times(double scalar) {
        return new PositiveBlade(value * scalar, positiveMask);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PositiveBlade times(PositiveBlade other) {
        return new PositiveBlade(
                value * other.value(),
                (byte) (positiveMask ^ other.positiveMask)
        );
    }

    @Override
    public boolean containsBase(int n) {
        return (positiveMask & (1 << n)) != 0; // TODO: Check if this is correct
    }

    @Override
    public boolean hasPositiveBase(int base) {
        return true;
    }

    @Override
    public boolean isNegativeQuadraticFormBase(int i) {
        return false;
    }

    @Override
    public boolean isZeroQuadraticFormBase(int i) {
        return false;
    }

    @Override
    public boolean containsBasis(int mask) {
        return (positiveMask & mask) == mask;
    }
}
