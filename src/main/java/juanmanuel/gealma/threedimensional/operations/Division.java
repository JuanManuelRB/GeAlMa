package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.*;

public interface Division extends MultiplicativeInverse {
    Geometric3 div(double other);

    Geometric3 div(Scalar other);

    Geometric3 div(Vector3 other);

    Geometric3 div(Bivector3 other);

    Geometric3 div(Rotor3 other);

    Geometric3 div(Trivector3 other);

    Geometric3 div(Multivector3 other);
}
