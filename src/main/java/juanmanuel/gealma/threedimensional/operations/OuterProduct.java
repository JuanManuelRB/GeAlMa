package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.*;

public interface OuterProduct {
    //    <T extends Geometric3> Geometric3 outer(T other);
    Geometric3 outer(double other);

    Geometric3 outer(Scalar other);

    Geometric3 outer(Vector3 other);

    Geometric3 outer(Bivector3 other);

    Geometric3 outer(Rotor3 other);

    Geometric3 outer(Trivector3 other);

    Geometric3 outer(Multivector3 other);

}
