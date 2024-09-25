package juanmanuel.gealma.vga.basis;

public sealed interface BladeDimension2<Self extends BladeDimension2<Self>> extends BladeDimension3<Self> permits BladeDimension1, E1E2, E2 {
    @Override
    default BladeDimension0<?> times(Self other) {
        return new E0(-this.value() * other.value());
    }

    @Override
    default BladeDimension0<?> div(Self other) {
        return new E0(-this.value() / other.value());
    }
}
