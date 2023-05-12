package juanmanuel.gealma.operations;

public interface Normalization<T extends Normalization<T>> {

    /**
     * @return the normalized object.
     */
    T normalized();
}
