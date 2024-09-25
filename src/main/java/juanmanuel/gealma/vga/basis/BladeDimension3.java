package juanmanuel.gealma.vga.basis;

public sealed interface BladeDimension3<Self extends BladeDimension3<Self>> extends BladeDimension4<Self> permits BladeDimension2, E2E3, E3, E3E1, E1E2E3 {
    @Override
    default BladeDimension0<?> times(Self other) {
        return new E0(-this.value() * other.value());
    }

    @Override
    default BladeDimension0<?> div(Self other) {
        return new E0(-this.value() / other.value());
    }
}
