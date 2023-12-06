package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.vga.basis.vga.*;

public sealed interface Basis3<Self extends Basis3<Self>> extends Basis4<Self> permits Basis2, E2E3, E3, E3E1, E1E2E3 {
    @Override
    default Basis0<?> times(Self other) {
        return new E0(-this.value() * other.value());
    }

    @Override
    default Basis0<?> div(Self other) {
        return new E0(-this.value() / other.value());
    }
}
