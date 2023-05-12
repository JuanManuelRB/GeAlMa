package juanmanuel.gealma.operations;

import juanmanuel.gealma.threedimensional.*;

public interface OuterProduct<T extends OuterProduct<T, ?>, R extends OuterProduct<?, R>> {
    //    <T extends Geometric3> Geometric3 outer(T other);

    R outer(T other);

    R outer(double other);

    R outer(Scalar other);

    R outer(Vector3 other);

    R outer(Bivector3 other);

    R outer(Rotor3 other);

    R outer(Trivector3 other);

    R outer(Multivector3 other);

}
