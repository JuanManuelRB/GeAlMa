package juanmanuel.gealma.experimentalVGA3;

import juanmanuel.gealma.experimentalVGA3.basis.PositiveBase;

public record Scalar(double value) implements PositiveBase<Scalar> {

    public Scalar plus(Scalar other) {
        return new Scalar(this.value + other.value);
    }

    @Override
    public Scalar unaryMinus() {
        return new Scalar(-this.value);
    }

    @Override
    public Scalar times(double scalar) {
        return new Scalar(this.value * scalar);
    }

    @Override
    public Scalar times(Scalar other) {
        return new Scalar(this.value * other.value);
    }

    @Override
    public Scalar inverse() {
        return new Scalar(1 / this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Scalar) obj;
        return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(that.value);
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public byte positiveBasisMask() {
        return 0;
    }

    @Override
    public boolean hasPositiveBase(int base) {
        return base == 0;
    }
}
