package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.threedimensional.basis.*;
import juanmanuel.gealma.threedimensional.operations.*;


public sealed interface Geometric3 extends Addition, Subtraction, GeometricProduct3, InnerProduct, OuterProduct, Division permits Bivector3, Multivector3, Rotor3, Scalar, Trivector3, Vector3 {
    /**
     * @return the basis e0.
     */
    default E0 e0() {
        return E0.ZERO;
    }

    /**
     * @return the basis e1.
     */
    default E1 e1() {
        return E1.ZERO;
    }

    /**
     * @return the basis e2.
     */
    default E2 e2() {
        return E2.ZERO;
    }

    /**
     * @return the basis e3.
     */
    default E3 e3() {
        return E3.ZERO;
    }

    /**
     * @return the basis e1e2.
     */
    default E1E2 e1e2() {
        return E1E2.ZERO;
    }

    /**
     * @return the basis e2e3.
     */
    default E2E3 e2e3() {
        return E2E3.ZERO;
    }

    /**
     * @return the basis e3e1.
     */
    default E3E1 e3e1() {
        return E3E1.ZERO;
    }

    /**
     * @return the basis e1e2e3.
     */
    default E1E2E3 e1e2e3() {
        return E1E2E3.ZERO;
    }

    default Scalar scalar() {
        return new Scalar(this.e0());
    }

    default Vector3 vector() {
        return new Vector3(this.e1(), this.e2(), this.e3());
    }

    default Bivector3 bivector() {
        return new Bivector3(this.e1e2(), this.e2e3(), this.e3e1());
    }

    default Trivector3 trivector() {
        return new Trivector3(this.e1e2e3());
    }

    default Multivector3 multivector() {
        return new Multivector3(scalar(), vector(), bivector(), trivector());
    }

    /**
     * @return the scalar subspace of the object.
     */
    default Geometric3 scalarSubspace() {
        return scalar().plus(trivector());
    }

    /**
     * @return the vector subspace of the object.
     */
    default Geometric3 vectorSubspace() {
        return vector().plus(bivector());
    }

    /**
     * @return the real subspace of the object.
     */

    default Geometric3 realSubspace() {
        return scalar().plus(vector());
    }

    /**
     * @return the imaginary subspace of the object.
     */
    default Geometric3 imaginarySubspace() {
        return bivector().plus(trivector());
    }

//    /**
//     *
//     * @return a Paravector composed of the scalar and vector of the element.
//     */
//    default Paravector toParavector() {
//        return new Paravector(e0(), e1(), e2(), e3());
//    }

    /**
     * @return a Rotor composed of the scalar and bivector of the element.
     */
    default Rotor3 toRotor() {
        return bivector().plus(scalar()).normalized();
    }

    Geometric3 normalized();

    double magnitudeSquared();

    double magnitude();

    default Geometric3 plus(Geometric3 other) {
        return new Multivector3(
                scalar().plus(other.scalar()),
                vector().plus(other.vector()),
                bivector().plus(other.bivector()),
                trivector().plus(other.trivector())
        );
    }

    default Geometric3 minus(Geometric3 other) {
        return new Multivector3(
                scalar().minus(other.scalar()),
                vector().minus(other.vector()),
                bivector().minus(other.bivector()),
                trivector().minus(other.trivector())
        );
    }

//    default Geometric3 inner(Geometric3 other) {
//        return scalar().inner()
//    }
//
//    default Geometric3 outer(Geometric3 other) {
//        return new Multivector3(
//                scalar().minus(other.scalar()),
//                vector().minus(other.vector()),
//                bivector().minus(other.bivector()),
//                trivector().minus(other.trivector())
//        );
//    }
//
//    default Geometric3 times(Geometric3 other) {
//        return this.inner(other).plus(this.outer(other));
//    }
}
