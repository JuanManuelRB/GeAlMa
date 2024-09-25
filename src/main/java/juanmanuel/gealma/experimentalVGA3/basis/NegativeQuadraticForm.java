package juanmanuel.gealma.experimentalVGA3.basis;

import juanmanuel.gealma.Blade;
import juanmanuel.gealma.Bladed;
import juanmanuel.gealma.Numeric;

public sealed interface NegativeQuadraticForm<Self extends NegativeQuadraticForm<Self>> extends Numeric, Bladed<Self> permits Blade {
    byte negativeMask();

    boolean isNegativeBase(int i);

    @Override
    default int baseCount() {
        return Integer.bitCount(negativeMask());
    }
}
