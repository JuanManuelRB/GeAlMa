package juanmanuel.gealma.basis;

public sealed interface Basis4<Self extends Basis4<Self>> extends Basis<Self> permits Basis3, E1E2E3E4, E1E4, E2E3E4, E2E4, E3E4, E3E4E1, E4, E4E1E2 {
}

