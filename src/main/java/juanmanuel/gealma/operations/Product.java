package juanmanuel.gealma.operations;

import juanmanuel.gealma.vga.Scalar;

public interface Product<T extends Product<T>> {

    Product<?> times(T other);

    Product<?> times(double other);

    Product<?> times(Scalar other);

//    R times(Vector3 other);
//
//    R times(Bivector3 other);
//
//    R times(Rotor3 other);
//
//    R times(Trivector3 other);
//
//    R times(Multivector3 other);


}
