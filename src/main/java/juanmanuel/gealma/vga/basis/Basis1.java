package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.vga.basis.vga.E0;
import juanmanuel.gealma.vga.basis.vga.E1;

public sealed interface Basis1<Self extends Basis1<Self>> extends Basis2<Self> permits Basis0, E1 {
    @Override
    default Basis0<?> times(Self other) {
        return new E0(this.value() * other.value());
    }

    @Override
    default Basis0<?> div(Self other) {
        return new E0(this.value() / other.value());
    }
}
