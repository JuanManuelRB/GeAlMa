package juanmanuel.gealma;

import juanmanuel.gealma.vga.Scalar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScalarTest {
    private static Scalar scalarTest;
    private Scalar scalarRHS;

    private static Scalar randomScalar() {
        return new Scalar(Math.random() * 1_000_000);
    }

    @BeforeEach
    void setScalarTest() {
        scalarTest = new Scalar(Math.random() * 1_000_000);
    }

    @BeforeEach
    void setScalarRHS() {
        scalarRHS = new Scalar(Math.random() * 1_000_000);
    }

    @Test
    void value() {
        assertEquals(Double.MAX_VALUE, new Scalar(Double.MAX_VALUE).value());
        assertEquals(Double.MIN_VALUE, new Scalar(Double.MIN_VALUE).value());
    }

    @RepeatedTest(100)
    void randomValue() {
        var random = Math.random() * 1_000_000;
        var scalar = new Scalar(random);
        assertEquals(random, scalar.value(), () -> STR."Scalar value is not the same as the one passed to the constructor.");
        assertEquals(scalar.e0().value(), scalar.value());
    }

    @Test
    void squared() {
        assertTrue(scalarTest.squared().value() >= 0, () -> STR."Magnitude is negative: \{scalarTest.squared()}");
        assertEquals(Math.abs(scalarTest.value()), scalarTest.squared());
    }

    @Test
    void magnitudeSquared() {
        assertEquals(scalarTest.value() * scalarTest.value(), scalarTest.squaredValue());
    }

    @Test
    void absoluteValue() {
        assertTrue(scalarTest.absoluteValue() >= 0, () -> STR."Magnitude is negative: \{scalarTest.absoluteValue()}");
        assertEquals(Math.abs(scalarTest.value()), scalarTest.absoluteValue());
    }

    @Test
    void unaryMinus() {
        assertEquals(-scalarTest.value(), scalarTest.unaryMinus().value());
    }

    @Test
    void inverse() {
        assertEquals(1 / scalarTest.value(), scalarTest.inverse().value());
        assertEquals(Scalar.one.div(scalarTest), scalarTest.inverse());
    }

    @Test
    void plus() {
        assertEquals(scalarTest.value() + scalarRHS.value(), scalarTest.plus(scalarRHS).value());
        assertEquals(scalarTest.plus(0), scalarTest);
    }

    @Test
    void minus() {
        assertEquals(scalarTest.value() - scalarRHS.value(), scalarTest.minus(scalarRHS).value());
    }

    @Test
    void inner() {
        assertEquals(scalarTest.value() * scalarRHS.value(), scalarTest.inner(scalarRHS).value());
    }

    @Test
    void outer() {
        assertEquals(0, scalarTest.outer(scalarRHS).value());
    }

    @Test
    void times() {
        assertEquals(scalarTest.value() * scalarRHS.value(), scalarTest.times(scalarRHS).value());
        assertEquals(scalarTest.times(0), Scalar.zero);
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