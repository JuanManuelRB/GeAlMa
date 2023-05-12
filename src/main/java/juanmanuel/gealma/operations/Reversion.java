package juanmanuel.gealma.operations;

/**
 * Reversion of an object.
 *
 * @param <T> the type of the object.
 */
public interface Reversion<T extends Reversion<T>> {
    T reverse();
}
