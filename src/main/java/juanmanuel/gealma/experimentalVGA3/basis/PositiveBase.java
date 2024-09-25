package juanmanuel.gealma.experimentalVGA3.basis;

import juanmanuel.gealma.Numeric;
import juanmanuel.gealma.experimentalVGA3.Base;

public interface PositiveBase<Self extends PositiveBase<Self>> extends Numeric, Base<Self> {
    byte positiveBasisMask();
    boolean hasPositiveBase(int base);

    @Override
    default int grade() {
        return Integer.bitCount(positiveBasisMask());
    }
}
