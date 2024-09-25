package juanmanuel.gealma.vga.basis;

public sealed interface BladeDimension1<Self extends BladeDimension1<Self>> extends BladeDimension2<Self> permits BladeDimension0, E1 {
    @Override
    default BladeDimension0<?> times(Self other) {
        return new E0(this.value() * other.value());
    }

    @Override
    default BladeDimension0<?> div(Self other) {
        return new E0(this.value() / other.value());
    }
}
