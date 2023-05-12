package juanmanuel.gealma.basis;

public sealed interface Basis<Self extends Basis<Self>> extends Comparable<Self> permits Basis4 {
    Basis<?> ZERO = null;
    Basis<?> ONE = null;

    Self plus(Self other);

    Self minus(Self other);

    Self unaryMinus();

    Self times(double scalar);

    E0 times(Self other);

    Self times(E0 other);

    Self inc();

    Self dec();

    double value();

/*    Basis<?> times(E1 other);
    Basis<?> times(E2 other);

    Basis<?> times(E3 other);

    Basis<?> times(E1E2 other);

    Basis<?> times(E2E3 other);

    Basis<?> times(E3E1 other);

    Basis<?> times(E1E2E3 other);*/

}
