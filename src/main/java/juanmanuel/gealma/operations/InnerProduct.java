package juanmanuel.gealma.operations;

import juanmanuel.gealma.Scalar;

public interface InnerProduct<Self extends InnerProduct<Self>> {
    //<T extends Geometric3<?>> Geometric3<?> inner(T other);

    InnerProduct<?> inner(Self other);
    InnerProduct<?> inner(double other);
    InnerProduct<?> inner(Scalar other);

//    Return inner(double other);
//
//    Return inner(Scalar other);
//
//    Return inner(Vector3 other);
//
//    Return inner(Bivector3 other);
//
//    Return inner(Rotor3 other);
//
//    Return inner(Trivector3 other);
//
//    Return inner(Multivector3 other);
}
