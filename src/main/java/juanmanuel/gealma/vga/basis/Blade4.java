package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.vga.basis.vga.E1E2E3E4;

public sealed interface Blade4<Self extends Blade4<Self>> extends Blade<Self> permits E1E2E3E4 {

}
