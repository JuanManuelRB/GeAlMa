package juanmanuel.gealma.operations;

import juanmanuel.gealma.threedimensional.*;

public interface Product<T extends Product<T, ?>, R extends Product<?, R>> {

    Product<?, ?> times(T other);

    R times(double other);

    R times(Scalar other);

    R times(Vector3 other);

    R times(Bivector3 other);

    R times(Rotor3 other);

    R times(Trivector3 other);

    R times(Multivector3 other);


}
