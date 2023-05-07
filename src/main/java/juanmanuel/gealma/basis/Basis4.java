package juanmanuel.gealma.nuevo;

public sealed interface Basis4<Self extends Basis4<Self>> extends Basis3<Self> permits E1E2E3E4, E1E4, E2E3E4, E2E4, E3E4, E3E4E1, E4, E4E1E2 {
}

