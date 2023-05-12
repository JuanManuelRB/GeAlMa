package juanmanuel.gealma.basis;

public sealed interface Basis3<Self extends Basis3<Self>> extends Basis4<Self> permits Basis2, E2E3, E3, E3E1, E1E2E3 {
}
