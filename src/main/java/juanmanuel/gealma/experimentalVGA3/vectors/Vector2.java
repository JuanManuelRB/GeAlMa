package juanmanuel.gealma.experimentalVGA3.vectors;

import juanmanuel.gealma.experimentalVGA3.basis.E1;
import juanmanuel.gealma.experimentalVGA3.basis.E2;
import juanmanuel.gealma.experimentalVGA3.basis.E3;

public class Vector2<Self extends Vector2<Self>> extends Vector3<Self> implements Vector<Self> {
    public Vector2(E1 e1, E2 e2, E3 e3) {
        super(e1, e2, e3);
    }

    public Vector2(E1 e1, E2 e2) {
        super(e1, e2, new E3(0));
    }
}
