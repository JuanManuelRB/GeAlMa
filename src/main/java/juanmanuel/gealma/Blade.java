package juanmanuel.gealma;

import juanmanuel.gealma.experimentalVGA3.basis.NegativeQuadraticForm;
import juanmanuel.gealma.experimentalVGA3.basis.PositiveBase;
import juanmanuel.gealma.experimentalVGA3.basis.ZeroQuadraticForm;
import juanmanuel.gealma.vga.basis.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public sealed class Blade
        implements PositiveBase<Blade>, NegativeQuadraticForm<Blade>, ZeroQuadraticForm<Blade> permits GeneralBlade, E1E2E3, E1E2E3E4, E1E4, E2E3, E2E3E4, E2E4, E3E1, E3E4, E3E4E1, E4E1E2 {
    public static final Blade zero  = new Blade(0, 0, 0, 0);
    public static final Blade one   = new Blade(1, 0, 0, 0);
    public static final Blade e1    = new Blade(1, 0b0001, 0, 0);
    public static final Blade e2    = new Blade(1, 0b0010, 0, 0);
    public static final Blade e3    = new Blade(1, 0b0100, 0, 0);
    public static final Blade e4    = new Blade(1, 0b1000, 0, 0);
    public static final Blade e12   = new Blade(1, 0b0011, 0, 0);
    public static final Blade e23   = new Blade(1, 0b0110, 0, 0);
    public static final Blade e31   = new Blade(-1, 0b0101, 0, 0);
    public static final Blade e14   = new Blade(1, 0b1001, 0, 0);
    public static final Blade e24   = new Blade(1, 0b1010, 0, 0);
    public static final Blade e34   = new Blade(1, 0b1100, 0, 0);
    public static final Blade e123  = new Blade(1, 0b0111, 0, 0);
    public static final Blade e124  = new Blade(1, 0b1011, 0, 0);
    public static final Blade e134  = new Blade(1, 0b1101, 0, 0);
    public static final Blade e234  = new Blade(1, 0b1110, 0, 0);
    public static final Blade e1234 = new Blade(1, 0b1111, 0, 0);
    private final double value;
    private final byte positiveMask;
    private final byte negativeMask;
    private final byte zeroMask;

    public Blade(double value, byte positiveMask, byte negativeMask, byte zeroMask) {
        if ((positiveMask & negativeMask) != 0)
            throw new IllegalArgumentException(STR."Duplicated Base in positive and negative masks: \{positiveMask & negativeMask}");

        if ((positiveMask & zeroMask) != 0)
            throw new IllegalArgumentException(STR."Duplicated Base in positive and zero masks: \{positiveMask & zeroMask}");

        if ((negativeMask & zeroMask) != 0)
            throw new IllegalArgumentException(STR."Duplicated Base in negative and zero masks: \{negativeMask & zeroMask}");
        this.value = value;
        this.positiveMask = positiveMask;
        this.negativeMask = negativeMask;
        this.zeroMask = zeroMask;
    }

    public Blade(double num, byte p) {
        this(num, p, (byte) 0, (byte) 0);
    }

    public Blade(double num, byte p, byte n) {
        this(num, p, n, (byte) 0);
    }

    public Blade(double value, Integer p, Integer n, Integer z) {
        this(value, p.byteValue(), n.byteValue(), z.byteValue());
    }

    public Blade(double num) {
        this(num, (byte) 0b0, (byte) 0b0, (byte) 0b0);
    }

    public byte calculateSign(int other) {
        byte sign = 1;
        int mask = positiveMask | negativeMask | zeroMask;
        while (mask != 0) {
            int shiftedA = mask >>> 1;
            int hammingWeight = Integer.bitCount(shiftedA & other);
            sign *= (byte) Math.pow(-1, hammingWeight);
            mask = shiftedA;
        }
        return sign;
    }

    public int negativeMultiplier(int other) {
        return Integer.bitCount(negativeMask & other) % 2 == 0 ? 1 : -1;
    }

    public int zeroMultiplier(int other) {
        return Integer.bitCount(zeroMask & other) == 0 ? 1 : 0;
    }

    @SuppressWarnings("unchecked")
    public Blade times(Blade other) {
        if (((positiveMask & other.negativeMask()) != 0) || (positiveMask & other.zeroMask()) != 0 ||
                ((negativeMask & other.positiveBasisMask()) != 0) || (negativeMask & other.zeroMask()) != 0 ||
                ((zeroMask & other.positiveBasisMask()) != 0) || (zeroMask & other.negativeMask()) != 0)
            throw new IllegalArgumentException("Incompatible basis");

        if (zeroMultiplier(other.zeroMask()) == 0)
            return new Blade(0, 0, 0, 0);

        var permutationSign = calculateSign((other.positiveBasisMask() ^ other.negativeMask() ^ other.zeroMask()));
        return new Blade(
                value * other.value() * permutationSign * negativeMultiplier(other.negativeMask()),
                (byte) (positiveMask ^ other.positiveBasisMask()),
                (byte) (negativeMask ^ other.negativeMask()),
                (byte) (zeroMask ^ other.zeroMask())
        );
    }

    public Blade div(Blade other) {
        return this.times(other.inverse());
    }

    private static Set<Integer> getBitPositions(int number) {
        LinkedHashSet<Integer> positions = new LinkedHashSet<>();
        int position = 1;

        while (number != 0) {
            if ((number & 1) == 1) {
                positions.add(position);
            }
            number >>= 1;
            position++;
        }
        return positions;
    }

    public Set<Integer> positiveBasis() {
        return getBitPositions(positiveMask);
    }

    public Set<Integer> negativeBasis() {
        return getBitPositions(negativeMask);
    }

    public Set<Integer> zeroBasis() {
        return getBitPositions(zeroMask);
    }

    public Set<Integer> basis() {
        return getBitPositions(positiveMask ^ negativeMask ^ zeroMask);
    }

    @Override
    public boolean containsBasis(int mask) {
        return ((positiveMask ^ negativeMask ^ zeroMask) & mask) == mask;
    }

    @Override
    public boolean hasPositiveBase(int i) {
        return positiveBasis().contains(i);
    }

    @Override
    public int baseCount() {
        return Integer.bitCount(positiveMask | negativeMask | zeroMask);
    }

    @Override
    public boolean isNegativeQuadraticFormBase(int i) {
        return negativeBasis().contains(i);
    }

    @Override
    public boolean isZeroQuadraticFormBase(int i) {
        return zeroBasis().contains(i);
    }

    @Override
    public boolean isNegativeBase(int i) {
        return negativeBasis().contains(i);
    }

    @Override
    public boolean isZeroBase(int i) {
        return zeroBasis().contains(i);
    }

    public boolean hasBase(int i) {
        return basis().contains(i);
    }

    public boolean hasPositiveBase() {
        return positiveMask != 0;
    }

    public boolean hasNegativeBase() {
        return negativeMask != 0;
    }

    public boolean hasZeroBase() {
        return zeroMask != 0;
    }

    public boolean isScalar() {
        return (positiveMask | negativeMask | zeroMask) == 0;
    }

    public boolean isVector() {
        return Integer.bitCount(positiveMask | negativeMask | zeroMask) == 1;
    }

    public boolean isBivector() {
        return Integer.bitCount(positiveMask | negativeMask | zeroMask) == 2;
    }

    public boolean isTrivector() {
        return Integer.bitCount(positiveMask | negativeMask | zeroMask) == 3;
    }

    public boolean isCuadravector() {
        return Integer.bitCount(positiveMask | negativeMask | zeroMask) == 4;
    }

    @Override
    public boolean containsBase(int n) {
        return Integer.bitCount(positiveMask | negativeMask | zeroMask) == n;
    }

    public Blade plus(Blade other) {
        if (((positiveMask | negativeMask | zeroMask) & ~(other.positiveMask | other.negativeMask | other.zeroMask)) != 0)
            throw new IllegalArgumentException("The other blade is not compatible");

        return new Blade(value + other.value, positiveMask, negativeMask, zeroMask);
    }

    @Override
    public Blade times(double scalar) {
        return new Blade(value * scalar, positiveMask, negativeMask, zeroMask);
    }

    @Override
    public Blade unaryMinus() {
        return new Blade(-value, positiveMask, negativeMask, zeroMask);
    }

    @Override
    public Blade inverse() {
        return new Blade(1 / value, positiveMask, negativeMask, zeroMask);
    }

    @Override
    public Blade inc() {
        return new Blade(value + 1, positiveMask, negativeMask, zeroMask);
    }

    @Override
    public Blade dec() {
        return new Blade(value - 1, positiveMask, negativeMask, zeroMask);
    }

    @Override
    public Blade reverse() {
        var n = baseCount();
        return new Blade(value * (double) (((n * (n - 1)) / 2) % 2 * 2) - 1, positiveMask, negativeMask, zeroMask);
    }

//    @Override
//    public <E extends Blade0<E>> Blade times(E scalar) {
//        return new Blade(value * scalar.value(), positiveMask, negativeMask, zeroMask);
//    }
//
//    @Override
//    public <E extends Blade0<E>> Blade div(E scalar) {
//        return new Blade(value / scalar.value(), positiveMask, negativeMask, zeroMask);
//    }

//    public int bitCount() {
//        return Integer.bitCount(positiveMask | negativeMask | zeroMask);
//    }

    @Override
    public double value() {
        return value;
    }

    @Override
    public byte positiveBasisMask() {
        return positiveMask;
    }

    @Override
    public byte negativeMask() {
        return negativeMask;
    }

    @Override
    public byte zeroMask() {
        return zeroMask;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Blade) obj;
        return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(that.value) &&
                this.positiveMask == that.positiveMask &&
                this.negativeMask == that.negativeMask &&
                this.zeroMask == that.zeroMask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, positiveMask, negativeMask, zeroMask);
    }

    @Override
    public String toString() {
        return StringTemplate.STR."Blade[value=\{value}, positiveMask=\{positiveMask}, negativeMask=\{negativeMask}, zeroMask=\{zeroMask}\{']'}";
    }
}
