package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.*;

public interface InnerProduct {
//    <T extends Geometric3> Geometric3 inner(T other);

    Geometric3 inner(double other);

    Geometric3 inner(Scalar other);

    Geometric3 inner(Vector3 other);

    Geometric3 inner(Bivector3 other);

    Geometric3 inner(Rotor3 other);

    Geometric3 inner(Trivector3 other);

    Geometric3 inner(Multivector3 other);
}
