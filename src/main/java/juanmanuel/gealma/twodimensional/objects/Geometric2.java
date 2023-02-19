package juanmanuel.gealma.twodimensional.objects;

import juanmanuel.gealma.twodimensional.basis.E0;
import juanmanuel.gealma.twodimensional.basis.E1;
import juanmanuel.gealma.twodimensional.basis.E1E2;
import juanmanuel.gealma.twodimensional.basis.E2;

public sealed interface Geometric2 permits Scalar, Vector2, Bivector2, Complex, Multivector2 {
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
     * @return the basis e1e2.
     */
    default E1E2 e1e2() {
        return E1E2.ZERO;
    }

    default Scalar scalar() {
        return new Scalar(e0());
    }

    default Vector2 vector() {
        return new Vector2(e1(), e2());
    }

    default Bivector2 bivector() {
        return new Bivector2(e1e2());
    }

    default Complex toComplex() {
        return new Complex(e0(), e1e2());
    }

    double magnitudeSquared();

    double magnitude();

    Geometric2 normalized();

    Geometric2 unaryMinus();

    Geometric2 inverse();

    Geometric2 plus(double other);

    Geometric2 plus(Scalar other);

    Geometric2 plus(Vector2 other);

    Geometric2 plus(Bivector2 other);

    Geometric2 plus(Complex other);

    Geometric2 plus(Multivector2 other);


    Geometric2 minus(double other);

    Geometric2 minus(Scalar other);

    Geometric2 minus(Vector2 other);

    Geometric2 minus(Bivector2 other);

    Geometric2 minus(Complex other);

    Geometric2 minus(Multivector2 other);
}
