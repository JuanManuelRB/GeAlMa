package juanmanuel.gealma.basis;

public sealed interface Basis2<Self extends Basis2<Self>> extends Basis3<Self> permits Basis1, E1E2, E2 {

}
