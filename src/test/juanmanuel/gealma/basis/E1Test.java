package juanmanuel.gealma.basis;

import juanmanuel.gealma.vga.basis.vga.E0;
import juanmanuel.gealma.vga.basis.vga.E1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E1Test {

    /*
     * Test for the plus method. Tests the following properties: - Commutative property - Associative property - Identity
     */
    @Test
    void plus() {
        // Random number between 0 and 1000
        double a = Math.random() * 1000;
        double b = Math.random() * 1000;

        // Test with Identity
        assertEquals(new E1(a), new E1(a).plus(new E1(0)));

        // Commutative property
        assertEquals(new E1(a + b), new E1(a).plus(new E1(b)));
        assertEquals(new E1(a + b), new E1(b).plus(new E1(a)));

        // Associative property
        assertEquals(new E1(a + a), new E1(a).plus(new E1(a)));
        assertEquals(new E1(b + b), new E1(b).plus(new E1(b)));

    }

    /*
     * Test for the unaryMinus method. Tests the following properties: - Identity
     */
    @Test
    void unaryMinus() {
        // Random number between 0 and 1000
        double a = Math.random() * 1000;

        // Test with 0
        assertEquals(new E1(0), new E1(0).unaryMinus());

        // Test with one
        assertEquals(new E1(-1), new E1(1).unaryMinus());

        // Test with random number
        assertEquals(new E1(-a), new E1(a).unaryMinus());

        // Test with negative number
        assertEquals(new E1(1).times(new E0(-1)), new E1(1).unaryMinus());
    }

    /**
     * Test for the times method. Tests the following properties: - Identity - 0 - Commutative property - Associative property
     */
    @Test
    void times() {
        // Random number between 0 and 1000
        double a = Math.random() * 1000;
        double b = Math.random() * 1000;
        double c = Math.random() * 1000;

        // Test with Identity
        assertEquals(new E0(a), new E1(a).times(new E1(1)));
        assertEquals(new E0(b), new E1(b).times(new E1(1)));

        // Test with 0
        assertEquals(new E0(0), new E1(a).times(new E1(0)));
        assertEquals(new E0(0), new E1(b).times(new E1(0)));

        // Commutative property
        assertEquals(new E0(a * b), new E1(a).times(new E1(b)));
        assertEquals(new E0(b * a), new E1(b).times(new E1(a)));
        assertEquals(new E1(a).times(new E1(b)), new E1(b).times(new E1(a)));

        // Associative property
        assertEquals(new E1(a * (b * c)), new E1(a).times(new E1(b).times(new E1(c))));
    }

    @Test
    void value() {
    }
}