package juanmanuel.gealma.vga.basis;

public sealed interface Basis<Self extends Basis<Self>> extends Comparable<Self> permits Basis4 {
    double value();
}
