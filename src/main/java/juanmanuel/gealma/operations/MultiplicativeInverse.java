package juanmanuel.gealma.threedimensional.operations;

import juanmanuel.gealma.threedimensional.objects.Geometric3;

public interface MultiplicativeInverse<T extends MultiplicativeInverse<T>> {
    T inverse();

}
