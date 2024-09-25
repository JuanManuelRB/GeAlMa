package juanmanuel.gealma.nuevo;

import java.util.Comparator;

public record GeometricPositiveBase(double value, byte basis) {
    public byte positiveBasisMask() {
        return basis;
    }

    public boolean hasPositiveBase(int base) {
        return (basis & (1 << base)) != 0;
    }

    public int grade() {
        return Integer.bitCount(basis);
    }

    public GeometricPositiveBase unaryMinus() {
        return new GeometricPositiveBase(-value, basis);
    }

    public GeometricPositiveBase times(GeometricPositiveBase other) {
        return new GeometricPositiveBase(value * other.value, (byte) (basis ^ other.basis));
    }

    public GeometricPositiveBase times(double scalar) {
        return new GeometricPositiveBase(value * scalar, basis);
    }

    public GeometricPositiveBase inverse() {
        return null;
    }

    static public Comparator<GeometricPositiveBase> baseComparator() {
        return Comparator.comparingInt(GeometricPositiveBase::basis);
    }

    static public Comparator<GeometricPositiveBase> valueComparator() {
        return Comparator.comparingDouble(GeometricPositiveBase::value);
    }

    static public Comparator<GeometricPositiveBase> gradeComparator() {
        return Comparator.comparingInt(GeometricPositiveBase::grade);
    }
}
