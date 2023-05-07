package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.Geometric3;

public interface AdditiveInverse<T extends AdditiveInverse<T>> {
    T unaryMinus();
}
