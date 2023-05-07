package juanmanuel.gealma.nuevo;

public sealed interface Basis<Self extends Basis<Self>> permits Basis1, E0 {
    Self plus(Self other);

    Self minus(Self other);

    Self times(double scalar);

    E0 times(Self other);

    Self times(E0 other);

    Self unaryMinus();

    double value();

/*    Basis<?> times(E1 other);
    Basis<?> times(E2 other);

    Basis<?> times(E3 other);

    Basis<?> times(E1E2 other);

    Basis<?> times(E2E3 other);

    Basis<?> times(E3E1 other);

    Basis<?> times(E1E2E3 other);*/

}
