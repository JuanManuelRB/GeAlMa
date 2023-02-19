package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.*;

public interface GeometricProduct3 {
    //    default  <T extends Geometric3> Geometric3 times(T other) {
//        return switch (other) {
//            case Scalar scalar -> this.times(scalar);
//            case Vector3 vector3 -> null;
//            case Bivector3 bivector3 -> null;
//            case Trivector3 trivector3 -> null;
//        };
//    }
    Geometric3 times(double other);

    Geometric3 times(Scalar other);

    Geometric3 times(Vector3 other);

    Geometric3 times(Bivector3 other);

    Geometric3 times(Rotor3 other);

    Geometric3 times(Trivector3 other);

    Geometric3 times(Multivector3 other);


}
