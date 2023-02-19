package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.*;

public interface Subtraction extends AdditiveInverse {
    //    default <T extends Geometric3> Geometric3 minus(T other) {
//        return switch (other) {
//            case Scalar scalar -> null;
//            case Vector3 vector3 -> null;
//            case Bivector3 bivector3 -> null;
//            case Trivector3 trivector3 -> null;
//        };
//    }
    Geometric3 minus(double other);

    Geometric3 minus(Scalar other);

    Geometric3 minus(Vector3 other);

    Geometric3 minus(Bivector3 other);

    Geometric3 minus(Rotor3 other);

    Geometric3 minus(Trivector3 other);

    Geometric3 minus(Multivector3 other);
}
