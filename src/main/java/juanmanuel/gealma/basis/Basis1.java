package juanmanuel.gealma.nuevo;

public sealed interface Basis1<Self extends Basis1<Self>> extends Basis<Self> permits Basis2, E1 {
}
