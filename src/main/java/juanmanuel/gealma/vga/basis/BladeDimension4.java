package juanmanuel.gealma.vga.basis;

public sealed interface BladeDimension4<Self extends BladeDimension4<Self>> extends BladeDimensionN<Self> permits BladeDimension3, E1E2E3E4, E1E4, E2E3E4, E2E4, E3E4, E3E4E1, E4, E4E1E2 {
    default BladeDimension0<?> times(Self other) {
        return new E0(this.value() * other.value());
    }

    default BladeDimension0<?> div(Self other) {
        return new E0(this.value() / other.value());
    }
}

