package juanmanuel.gealma.nuevo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Multivector implements Iterable<GeometricPositiveBase> {
    TreeSet<GeometricPositiveBase> bases = new TreeSet<>(GeometricPositiveBase.baseComparator());

    public Set<GeometricPositiveBase> bases() {
        return Set.copyOf(bases);
    }

    @Override
    public Iterator<GeometricPositiveBase> iterator() {
        return bases.stream()
                .sorted(GeometricPositiveBase.gradeComparator())
                .iterator(); // The resulting bases should be in an order like 1, 2, 3, 4, 12, 13, 23, 123
    }
}
