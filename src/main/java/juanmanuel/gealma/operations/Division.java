package juanmanuel.gealma.operations;

import juanmanuel.gealma.Scalar;

public interface Division<Self extends Division<Self>> extends MultiplicativeInverse<Self> {

    Division<?> div(Self other) throws ArithmeticException;

    Division<?> div(double other);

    Division<?> div(Scalar other);
//
//    R div(Vector3 other);
//
//    R div(Bivector3 other);
//
//    R div(Rotor3 other);
//
//    R div(Trivector3 other);
//
//    R div(Multivector3 other);
}
