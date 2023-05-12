package juanmanuel.gealma.threedimensional.objects;

import juanmanuel.gealma.threedimensional.Scalar;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScalarTest {

    @Test
    void magnitudeSquared() {
        var rnd = new Random();
        var value = rnd.nextDouble();
        assertEquals(value * value, new Scalar(value).magnitudeSquared());
    }

    @Test
    void magnitude() {
    }

    @Test
    void value() {
    }

    @Test
    void normalized() {
    }

    @Test
    void unaryMinus() {
    }

    @Test
    void reciprocal() {
    }

    @Test
    void plus() {
    }

    @Test
    void minus() {
    }

    @Test
    void inner() {
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
    void e0() {
    }
}