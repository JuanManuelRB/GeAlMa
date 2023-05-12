package juanmanuel.gealma.basis;

public sealed interface Basis1<Self extends Basis1<Self>> extends Basis2<Self> permits Basis0, E1 {
}
