package juanmanuel.gealma.threedimensional.operations;

public interface Normalization<T extends Normalization<T>> {

    /**
     * @return the normalized object.
     */
    T normalized();
}
