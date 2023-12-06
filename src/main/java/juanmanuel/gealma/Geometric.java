package juanmanuel.gealma;

import juanmanuel.gealma.operations.*;

public interface Geometric<T extends Geometric<T>> extends Addition<T>, Subtraction<T>, Reversion<T>,
        InnerProduct<T>, OuterProduct<T>, Product<T>, Division<T> {
}
