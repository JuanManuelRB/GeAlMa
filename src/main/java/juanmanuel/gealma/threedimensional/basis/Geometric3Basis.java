package juanmanuel.gealma.threedimensional.basis;

public sealed interface Geometric3Basis permits E0, E1, E1E2, E1E2E3, E2, E2E3, E3, E3E1 {

    double value();

    Geometric3Basis unaryMinus();

    Geometric3Basis times(E0 other);

    Geometric3Basis times(E1 other);

    Geometric3Basis times(E2 other);

    Geometric3Basis times(E3 other);

    Geometric3Basis times(E1E2 other);

    Geometric3Basis times(E2E3 other);

    Geometric3Basis times(E3E1 other);

    Geometric3Basis times(E1E2E3 other);

}


