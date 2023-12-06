package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.vga.basis.vga.E1E2E3;
import juanmanuel.gealma.vga.basis.vga.E2E3E4;
import juanmanuel.gealma.vga.basis.vga.E3E4E1;
import juanmanuel.gealma.vga.basis.vga.E4E1E2;

public sealed interface Blade3<Self extends Blade3<Self>> extends Blade<Self> permits E1E2E3, E2E3E4, E3E4E1, E4E1E2 {

}
