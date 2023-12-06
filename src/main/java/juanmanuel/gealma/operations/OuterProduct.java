package juanmanuel.gealma.operations;

import juanmanuel.gealma.vga.Scalar;

public interface OuterProduct<T extends OuterProduct<T>> {
    //    <T extends Geometric3> Geometric3 outer(T other);

    OuterProduct<?> outer(T other);

    OuterProduct<?> outer(double other);

    OuterProduct<?> outer(Scalar other);

//    R outer(Vector3 other);
//
//    R outer(Bivector3 other);
//
//    R outer(Rotor3 other);
//
//    R outer(Trivector3 other);
//
//    R outer(Multivector3 other);

}
