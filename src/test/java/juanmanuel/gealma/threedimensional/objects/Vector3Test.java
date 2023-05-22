package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.Scalar;
import juanmanuel.gealma.basis.*;
import juanmanuel.gealma.threedimensional.Bivector3;
import juanmanuel.gealma.threedimensional.Trivector3;
import juanmanuel.gealma.threedimensional.Vector3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector3Test {
    E0 e0;
    E1 e1_1;
    E2 e2_1;
    E3 e3_1;
    E1 e1_2;
    E2 e2_2;
    E3 e3_2;
    E1E2 e1e2;
    E2E3 e2e3;
    E3E1 e3e1;
    E1E2E3 e1e2e3;
    Vector3Test() {
        e0 = new E0(Math.random() * 1000);
        e1_1 = new E1(Math.random() * 1000);
        e2_1 = new E2(Math.random() * 1000);
        e3_1 = new E3(Math.random() * 1000);
        e1_2 = new E1(Math.random() * 1000);
        e2_2 = new E2(Math.random() * 1000);
        e3_2 = new E3(Math.random() * 1000);
        e1e2 = new E1E2(Math.random() * 1000);
        e2e3 = new E2E3(Math.random() * 1000);
        e3e1 = new E3E1(Math.random() * 1000);
        e1e2e3 = new E1E2E3(Math.random() * 1000);
    }

    @Test
    void unaryMinus() {
    }

    @Test
    void magnitudeSquared() {
    }

    @Test
    void magnitude() {
    }

    @Test
    void inverse() {
    }

    @Test
    void normalized() {
    }

    @Test
    void length() {
    }

    @Test
    void reflectOver() {
    }

    @Test
    void rotated() {
    }

    @Test
    void projection() {
    }

    @Test
    void rejection() {
    }

    @Test
    void plus() {
        var v1 = new Vector3(1, 2, 3);
        var v2 = new Vector3(4, 5, 6);
        assertEquals(new Vector3(5, 7, 9), v1.plus(v2));
    }

    @Test
    void minus() {
    }

    @Test
    void inner() {
        var v1 = new Vector3(e1_1, e2_1, e3_1);

        // Vector inner Scalar
        var s1 = new Scalar(e0);
        var vr = new Vector3(e1_1.times(e0), e2_1.times(e0), e3_1.times(e0));
        assertEquals(vr, v1.inner(s1));

        // Vector inner Vector
        var v2 = new Vector3(e1_2, e2_2, e3_2);
        var sr = new Scalar(e1_1.times(e1_2).plus(e2_1.times(e2_2)).plus(e3_1.times(e3_2)));
        assertEquals(sr, v1.inner(v2));

        // Vector inner Bivector
        var b1 = new Bivector3(e1e2, e2e3, e3e1);
        vr = new Vector3(
                e3_1.times(e3e1).plus(e2_1.times(e1e2)),
                e1_1.times(e1e2).plus(e3_1.times(e2e3)),
                e2_1.times(e2e3).plus(e1_1.times(e3e1))
        );
        assertEquals(vr, v1.inner(b1));

        // Vector inner Trivector
        var t1 = new Trivector3(e1e2e3);
        var br = new Bivector3(
                e3_1.times(e1e2e3),
                e1_1.times(e1e2e3),
                e2_1.times(e1e2e3)
        );
        assertEquals(br, v1.inner(t1));
    }

    @Test
    void outer() {
    }

    @Test
    void times() {
    }

    @Test
    void div() {
    }

    @Test
    void iterator() {
    }

    @Test
    void reverse() {
    }

    @Test
    void e1() {
    }

    @Test
    void e2() {
    }

    @Test
    void e3() {
    }
}