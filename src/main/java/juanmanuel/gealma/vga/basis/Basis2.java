package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.vga.basis.vga.E0;
import juanmanuel.gealma.vga.basis.vga.E1E2;
import juanmanuel.gealma.vga.basis.vga.E2;

public sealed interface Basis2<Self extends Basis2<Self>> extends Basis3<Self> permits Basis1, E1E2, E2 {
    @Override
    default Basis0<?> times(Self other) {
        return new E0(-this.value() * other.value());
    }

    @Override
    default Basis0<?> div(Self other) {
        return new E0(-this.value() / other.value());
    }
}
