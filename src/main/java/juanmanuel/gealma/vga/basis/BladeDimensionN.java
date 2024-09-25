package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.experimentalVGA3.basis.PositiveBase;

public sealed interface BladeDimensionN<Self extends BladeDimensionN<Self>>
        extends PositiveBase<Self>, Comparable<Self> permits BladeDimension4 {
    double value();

    Self plus(Self other);
    Self unaryMinus();
    default Self minus(Self other) {
        return this.plus(other.unaryMinus());
    }

    <E extends BladeDimension0<E>> Self times(E scalar);
    default <E extends BladeDimension0<E>> Self div(E scalar) {
        return times(scalar.inverse());
    }

    default <E extends BladeDimension0<E>> E div(Self other) {
        return times(other.inverse());
    }


}
