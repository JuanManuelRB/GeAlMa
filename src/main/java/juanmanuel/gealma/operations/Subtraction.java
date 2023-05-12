package juanmanuel.gealma.operations;

public interface Subtraction<T extends Subtraction<T>> extends AdditiveInverse<T> {

    T minus(T other);

//    Geometric3 minus(double other);
//
//    Geometric3 minus(Scalar other);
//
//    Geometric3 minus(Vector3 other);
//
//    Geometric3 minus(Bivector3 other);
//
//    Geometric3 minus(Rotor3 other);
//
//    Geometric3 minus(Trivector3 other);
//
//    Geometric3 minus(Multivector3 other);
}
