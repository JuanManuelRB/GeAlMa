package juanmanuel.gealma.experimentalVGA3.vectors;

import juanmanuel.gealma.experimentalVGA3.GeometricElement;
import juanmanuel.gealma.experimentalVGA3.basis.PositiveBase;

public interface Vector<Self extends Vector<Self>> extends GeometricElement<Self>, Iterable<PositiveBase<?>> {
    double moduleSquared();

    default double module() {
        return Math.sqrt(moduleSquared());
    }

    int dimension();

    default int grade() {
        return 1;
    }
}
