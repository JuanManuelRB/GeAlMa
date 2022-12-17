package juanmanuel.gealma.threedimensional;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Vector3Test {
    Random rnd = new Random();

    @Test
    void length() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(new Vector3(i, j, k).length(), new Vector3(i, j, k).length());
        assertEquals(Math.sqrt(i*i + j*j + k*k), new Vector3(i, j, k).length());

        assertEquals(new Vector3(3, 3, 3).length(), new Vector3(3, 3, 3).length());


        assertEquals(Math.sqrt(3), Vector3.ONE.length());
        assertEquals(Math.sqrt(3*3 + 3*3 + 3*3), new Vector3(3, 3, 3).length());
        assertEquals(new Vector3(3, 3, 3).magnitude(), new Vector3(3, 3, 3).length());

    }

    @Test
    void magnitude() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(new Vector3(i, j, k).magnitude(), new Vector3(i, j, k).magnitude());
        assertEquals(new Vector3(3, 3, 3).magnitude(), new Vector3(3, 3, 3).magnitude());

        assertEquals(Math.sqrt(i*i + j*j + k*k), new Vector3(i, j, k).magnitude());

        assertEquals(Math.sqrt(3), Vector3.ONE.magnitude());
        assertEquals(Math.sqrt(3*3 + 3*3 + 3*3), new Vector3(3, 3, 3).magnitude());

    }

    @Test
    void unaryMinus() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(new Vector3(i, j, k).unaryMinus(), new Vector3(i, j, k).unaryMinus());
        assertEquals(new Vector3(-i, -j, -k), new Vector3(i, j, k).unaryMinus());

//        assertEquals(new Vector3(0, 0, 0), Vector3.ZERO.unaryMinus());
//        assertEquals(new Vector3(-1, -1, -1), Vector3.ONE.unaryMinus());
//        assertEquals(new Vector3(-1, 0 , 0), Vector3.I.unaryMinus());
//        assertEquals(new Vector3(0, -1 , 0), Vector3.J.unaryMinus());
//        assertEquals(new Vector3(0, 0 , -1), Vector3.K.unaryMinus());

    }

    @Test
    void unaryPlus() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();
        var vec = new Vector3(i, j, k).unaryPlus();

        assertEquals(Math.abs(i), vec.i());
        assertEquals(Math.abs(j), vec.j());
        assertEquals(Math.abs(k), vec.k());

        assertEquals(new Vector3(Math.abs(i), Math.abs(j), Math.abs(k)), vec);
        assertEquals(Vector3.ONE, new Vector3(1, -1, -1).unaryPlus());
    }

    @Test
    void scalar() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(0, new Vector3(i, j, k).scalar());
    }

    @Test
    void vector() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(new Vector3(i, j, k), new Vector3(i, j, k).vector());
    }

    @Test
    void bivector() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(Bivector3.ZERO, new Vector3(i, j, k).bivector());
    }

    @Test
    void trivector() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(Trivector3.ZERO, new Vector3(i, j, k).trivector());
    }

    @Test
    void plus() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();
        var l = rnd.nextDouble();
        var m = rnd.nextDouble();
        var n = rnd.nextDouble();

        assertEquals(new Vector3(i + l, j + m, k + n), new Vector3(i, j, k).plus(new Vector3(l, m, n)));

        assertEquals(Vector3.ONE, Vector3.ONE);
        assertEquals(new Vector3(2, 2, 2), Vector3.ONE.plus(Vector3.ONE));

    }

    @Test
    void minus() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();
        var l = rnd.nextDouble();
        var m = rnd.nextDouble();
        var n = rnd.nextDouble();

        assertEquals(new Vector3(i - l, j - m, k - n), new Vector3(i, j, k).minus(new Vector3(l, m, n)));

        assertEquals(Vector3.ONE, Vector3.ONE.minus(Vector3.ZERO));
        assertEquals(Vector3.ZERO, Vector3.ONE.minus(Vector3.ONE));
    }

    @Test
    void times() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();
        var l = rnd.nextDouble();
        var m = rnd.nextDouble();
        var n = rnd.nextDouble();

        var v1 = new Vector3(i, j, k);
        var v2 = new Vector3(l, m, n);

        assertEquals(v1.inner(v2).plus(v1.outer(v2)), v1.times(v2));

        assertEquals(Geometric3Object.ZERO, Vector3.ONE.times(Vector3.ZERO));
        assertEquals(Vector3.ONE.outer(Vector3.ONE), Vector3.ONE.times(Vector3.ONE).bivector());
        assertEquals(Vector3.ONE.inner(Vector3.ONE).scalar(), Vector3.ONE.times(Vector3.ONE).scalar());
    }

    @Test
    void div() {
//        var i = rnd.nextDouble();
//        var j = rnd.nextDouble();
//        var k = rnd.nextDouble();
//
//        var vec = new Vector3(i, j, k);
//        assertEquals(Geometric3Object.ZERO.plus(1), vec.div(vec));
//        assertEquals(1,vec.div(vec).scalar());
    }

    @Test
    void inner() {

    }

    @Test
    void outer() {
    }

    @Test
    void inverse() {
//        var i = rnd.nextDouble();
//        var j = rnd.nextDouble();
//        var k = rnd.nextDouble();
//
//        var vec = new Vector3(i, j, k);
//        assertEquals(Geometric3Object.ZERO.plus(1), vec.times(vec.inverse()));
//        assertEquals(1,vec.times(vec.inverse()).scalar());
    }

    @Test
    void unitary() {
//        var i = rnd.nextDouble();
//        var j = rnd.nextDouble();
//        var k = rnd.nextDouble();
//
//        var vec = new Vector3(i, j, k);
//        assertEquals(1, vec.unitary().magnitude());
    }

    @Test
    void i() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(i, new Vector3(i, j, k).i());

        assertEquals(Vector3.I, new Vector3(1, 0, 0));
    }

    @Test
    void j() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(j, new Vector3(i, j, k).j());

        assertEquals(Vector3.J, new Vector3(0, 1, 0));
    }

    @Test
    void k() {
        var i = rnd.nextDouble();
        var j = rnd.nextDouble();
        var k = rnd.nextDouble();

        assertEquals(k, new Vector3(i, j, k).k());

        assertEquals(Vector3.K, new Vector3(0, 0, 1));
    }
}