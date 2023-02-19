package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.*;

public interface Addition {
    Geometric3 plus(double other);

    Geometric3 plus(Scalar other);

    Geometric3 plus(Vector3 other);

    Geometric3 plus(Bivector3 other);

    Geometric3 plus(Rotor3 other);

    Geometric3 plus(Trivector3 other);

    Geometric3 plus(Multivector3 other);

}
