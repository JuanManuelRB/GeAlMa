package juanmanuel.gealma.vga.vga3;

import juanmanuel.gealma.vga.Scalar;
import juanmanuel.gealma.vga.basis.vga.*;
import juanmanuel.gealma.vga.vga3.Bivector3;
import juanmanuel.gealma.vga.vga3.Trivector3;
import juanmanuel.gealma.vga.vga3.Vector3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector3Test {

    @Test
    void newVector3() {
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;

        var e1 = new E1(b1);
        var e2 = new E2(b2);
        var e3 = new E3(b3);

        // Create a vector from three random basis elements
        var vec1 = new Vector3(e1, e2, e3);
        assertEquals(e1, vec1.e1());
        assertEquals(e2, vec1.e2());
        assertEquals(e3, vec1.e3());

        // Create a vector from the three scalar values of the basis elements
        var vec2 = new Vector3(b1, b2, b3);
        assertEquals(e1, vec2.e1());
        assertEquals(e2, vec2.e2());
        assertEquals(e3, vec2.e3());

        // Check that both vectors are equal
        assertEquals(vec1, vec2);

        // Check that the value of the vector is zero for non-1-blade elements
        assertEquals(0, vec1.e0().value()); // 0-blade
        assertEquals(0, vec1.e1e2().value()); // 2-blade
        assertEquals(0, vec1.e2e3().value()); // 2-blade
        assertEquals(0, vec1.e3e1().value()); // 2-blade
        assertEquals(0, vec1.e1e2e3().value()); // 3-blade

        assertEquals(Vector3.ZERO, new Vector3(0, 0, 0));
        assertEquals(Vector3.ONE, new Vector3(1, 1, 1));
    }

    @Test
    void unaryMinus() {
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;

        var vec1 = new Vector3(b1, b2, b3).unaryMinus();
        assertEquals(-b1, vec1.e1().value());
        assertEquals(-b2, vec1.e2().value());
        assertEquals(-b3, vec1.e3().value());
    }

    @Test
    void magnitudeSquared() {
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;

        var vec1 = new Vector3(b1, b2, b3);
        assertEquals(b1 * b1 + b2 * b2 + b3 * b3, vec1.magnitudeSquared(), 1e-10);
    }

    @Test
    void magnitude() {
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;

        var vec1 = new Vector3(b1, b2, b3);
        assertEquals(Math.sqrt(b1 * b1 + b2 * b2 + b3 * b3), vec1.magnitude(), 1e-10);
    }

    @Test
    void inverse() {
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;

        var vec1 = new Vector3(b1, b2, b3);
        var res = vec1.times(vec1.inverse());

        assertEquals(1, res.e0().value(), 1e-10);
        assertEquals(0, res.e1().value(), 1e-10);
        assertEquals(0, res.e2().value(), 1e-10);
        assertEquals(0, res.e3().value(), 1e-10);
        assertEquals(0, res.e1e2().value(), 1e-10);
        assertEquals(0, res.e2e3().value(), 1e-10);
        assertEquals(0, res.e3e1().value(), 1e-10);
        assertEquals(0, res.e1e2e3().value(), 1e-10);
    }

    @Test
    void normalized() {
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;

        var vec1 = new Vector3(b1, b2, b3);
        var res = vec1.normalized();

        assertEquals(1, res.magnitude(), 1e-10);
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
        var b0 = Math.random() * 1000;
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;
        var b4 = Math.random() * 1000;
        var b5 = Math.random() * 1000;
        var b6 = Math.random() * 1000;

        var e0 = new E0(b0);

        var e1_1 = new E1(b1);
        var e2_1 = new E2(b2);
        var e3_1 = new E3(b3);

        var e1_2 = new E1(b4);
        var e2_2 = new E2(b5);
        var e3_2 = new E3(b6);

        var v1 = new Vector3(e1_1, e2_1, e3_1);

        // Vector plus Scalar
        var s1 = new Scalar(e0);
        var m1 = new Multivector3(e0, e1_1, e2_1, e3_1, E1E2.ZERO, E2E3.ZERO, E3E1.ZERO, E1E2E3.ZERO);
        assertEquals(m1, v1.plus(s1));

        // Vector plus Vector
        var v2 = new Vector3(e1_2, e2_2, e3_2);
        var vr = new Vector3(e1_1.plus(e1_2), e2_1.plus(e2_2), e3_1.plus(e3_2));
        assertEquals(vr, v1.plus(v2));
    }

    @Test
    void minus() {
    }

    @Test
    void inner() {
        var b0 = Math.random() * 1000;
        var b1 = Math.random() * 1000;
        var b2 = Math.random() * 1000;
        var b3 = Math.random() * 1000;
        var b4 = Math.random() * 1000;
        var b5 = Math.random() * 1000;
        var b6 = Math.random() * 1000;

        var e0 = new E0(b0);

        var e1_1 = new E1(b1);
        var e2_1 = new E2(b2);
        var e3_1 = new E3(b3);

        var e1_2 = new E1(b4);
        var e2_2 = new E2(b5);
        var e3_2 = new E3(b6);

        var v1 = new Vector3(e1_1, e2_1, e3_1);

        // Vector inner Scalar
        var s1 = new Scalar(e0);
        var vr = new Vector3(e1_1.times(e0), e2_1.times(e0), e3_1.times(e0));
        assertEquals(vr, v1.inner(s1));

        // Vector inner Vector
        var v2 = new Vector3(e1_2, e2_2, e3_2);
        var sr = new Scalar(e1_1.times(e1_2).plus(e2_1.times(e2_2)).plus(e3_1.times(e3_2)));
        assertEquals(sr, v1.inner(v2));

//        // Vector inner Bivector
//        var b1 = new Bivector3(e1e2, e2e3, e3e1);
//        vr = new Vector3(
//                e3_1.times(e3e1).plus(e2_1.times(e1e2)),
//                e1_1.times(e1e2).plus(e3_1.times(e2e3)),
//                e2_1.times(e2e3).plus(e1_1.times(e3e1))
//        );
//        assertEquals(vr, v1.inner(b1));
//
//        // Vector inner Trivector
//        var t1 = new Trivector3(e1e2e3);
//        var br = new Bivector3(
//                e3_1.times(e1e2e3),
//                e1_1.times(e1e2e3),
//                e2_1.times(e1e2e3)
//        );
//        assertEquals(br, v1.inner(t1));
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