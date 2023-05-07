package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.*;

public interface GeometricProduct3<T extends GeometricProduct3<T, ?>, R extends GeometricProduct3<?, R>> {

    R times(T other);

    R times(double other);

    R times(Scalar other);

    R times(Vector3 other);

    R times(Bivector3 other);

    R times(Rotor3 other);

    R times(Trivector3 other);

    R times(Multivector3 other);


}
