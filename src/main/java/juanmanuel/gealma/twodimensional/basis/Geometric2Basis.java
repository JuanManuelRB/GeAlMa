package juanmanuel.gealma.twodimensional.basis;

public sealed interface Geometric2Basis permits E0, E1, E1E2, E2 {

    double value();

    Geometric2Basis unaryMinus();

    Geometric2Basis times(E0 other);

    Geometric2Basis times(E1 other);

    Geometric2Basis times(E2 other);

    Geometric2Basis times(E1E2 other);

}


