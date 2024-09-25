package juanmanuel.gealma.experimentalVGA3.basis;

import juanmanuel.gealma.Blade;
import juanmanuel.gealma.Bladed;
import juanmanuel.gealma.Numeric;

public sealed interface ZeroQuadraticForm<Self extends ZeroQuadraticForm<Self>> extends Numeric, Bladed<Self> permits Blade {
    byte zeroMask();

    boolean isZeroBase(int i);

    @Override
    default int baseCount() {
        return Integer.bitCount(zeroMask());
    }
}
