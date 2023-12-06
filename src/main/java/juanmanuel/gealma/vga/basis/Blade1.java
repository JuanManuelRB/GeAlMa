package juanmanuel.gealma.vga.basis;

import juanmanuel.gealma.vga.basis.vga.E1;
import juanmanuel.gealma.vga.basis.vga.E2;
import juanmanuel.gealma.vga.basis.vga.E3;
import juanmanuel.gealma.vga.basis.vga.E4;

public sealed interface Blade1<Self extends Blade1<Self>> extends Blade<Self> permits E1, E2, E3, E4 {

}
