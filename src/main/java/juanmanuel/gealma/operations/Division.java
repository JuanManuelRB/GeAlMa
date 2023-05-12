package juanmanuel.gealma.operations;

import juanmanuel.gealma.threedimensional.*;

public interface Division<Self extends Division<Self, ?>, R> extends MultiplicativeInverse<Self> {

    Division<?, ?> div(Self other) throws ArithmeticException;

    R div(double other);

    R div(Scalar other);

    R div(Vector3 other);

    R div(Bivector3 other);

    R div(Rotor3 other);

    R div(Trivector3 other);

    R div(Multivector3 other);
}
