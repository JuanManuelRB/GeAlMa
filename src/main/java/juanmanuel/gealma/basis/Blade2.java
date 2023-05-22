package juanmanuel.gealma.basis;

public sealed interface Blade2<Self extends Blade2<Self>> extends Blade<Self> permits E1E2, E2E3, E3E1, E1E4, E2E4, E3E4 {

}
