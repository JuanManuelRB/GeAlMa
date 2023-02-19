package juanmanuel.gealma.twodimensional.objects;

import juanmanuel.gealma.twodimensional.basis.E0;
import juanmanuel.gealma.twodimensional.basis.E1;
import juanmanuel.gealma.twodimensional.basis.E1E2;
import juanmanuel.gealma.twodimensional.basis.E2;

public record Multivector2(E0 e0, E1 e1, E2 e2, E1E2 e1e2) implements Geometric2 {
    public Multivector2(Scalar scalar, Vector2 vector, Bivector2 bivector) {
        this(scalar.e0(), vector.e1(), vector.e2(), bivector.e1e2());
    }
}
