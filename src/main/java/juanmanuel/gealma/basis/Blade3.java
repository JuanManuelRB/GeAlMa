package juanmanuel.gealma.basis;

public sealed interface Blade3<Self extends Blade3<Self>> extends Blade<Self> permits E1E2E3, E2E3E4, E3E4E1, E4E1E2 {

}
