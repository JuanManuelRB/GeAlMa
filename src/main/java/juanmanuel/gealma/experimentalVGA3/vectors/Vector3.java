package juanmanuel.gealma.experimentalVGA3.vectors;

import juanmanuel.gealma.experimentalVGA3.basis.E1;
import juanmanuel.gealma.experimentalVGA3.basis.E2;
import juanmanuel.gealma.experimentalVGA3.basis.E3;
import juanmanuel.gealma.experimentalVGA3.basis.PositiveBase;

import java.util.Iterator;
import java.util.Objects;

public class Vector3<Self extends Vector3<Self>> implements Vector<Self> {
    private final E1 e1;
    private final E2 e2;
    private final E3 e3;

    public Vector3(E1 e1, E2 e2, E3 e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    @Override
    public Self times(double scalar) {
        return (Self) new Vector3<Self>(e1.times(scalar), e2.times(scalar), e3.times(scalar));
    }

    @Override
    public Self inverse() {
        return this.div(this.moduleSquared())
    }

    @Override
    public double module() {
        return 0; // TODO
    }

    @Override
    public int dimension() {
        return 0;
    }

    @Override
    public Iterator<PositiveBase<?>> iterator() {
        return null;
    }

    public E1 e1() {
        return e1;
    }

    public E2 e2() {
        return e2;
    }

    public E3 e3() {
        return e3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Vector3) obj;
        return Objects.equals(this.e1, that.e1) &&
                Objects.equals(this.e2, that.e2) &&
                Objects.equals(this.e3, that.e3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e1, e2, e3);
    }

    @Override
    public String toString() {
        return "Vector3[" +
                "e1=" + e1 + ", " +
                "e2=" + e2 + ", " +
                "e3=" + e3 + ']';
    }

}
