package juanmanuel.gealma.threedimensional.basis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E0Test {

    /*
     * Test for the plus method. Tests the following properties: - Commutative property - Associative property - Identity
     */
    @Test
    void plus() {
        // Random number between 0 and 1000
        double a = Math.random() * 1000;
        double b = Math.random() * 1000;

        // Test with Identity
        assertEquals(new E0(a), new E0(a).plus(new E0(0)));

        // Commutative property
        assertEquals(new E0(a + b), new E0(a).plus(new E0(b)));
        assertEquals(new E0(a + b), new E0(b).plus(new E0(a)));

        // Associative property
        assertEquals(new E0(a + a), new E0(a).plus(new E0(a)));
        assertEquals(new E0(b + b), new E0(b).plus(new E0(b)));
    }

    /*
     */
    @Test
    void unaryMinus() {
        // Random number between 0 and 1000
        double a = Math.random() * 1000;

        // Test with 0
        assertEquals(new E0(0), new E0(0).unaryMinus());

        // Test with random number
        assertEquals(new E0(-a), new E0(a).unaryMinus());
    }

    /*
     * Test for the times method. Tests the following properties: - Commutative property - Associative property - Distributive
     * property - Identity
     */
    @Test
    void times() {
        // Random number between 0 and 1000
        double a = Math.random() * 1000;
        double b = Math.random() * 1000;
        double c = Math.random() * 1000;

        // Test with 0
        assertEquals(new E0(0), new E0(0).times(new E0(0)));
        assertEquals(new E0(0), new E0(0).times(new E0(a)));
        assertEquals(new E0(0), new E0(a).times(new E0(0)));

        // Test with Identity
        assertEquals(new E0(1), new E0(1).times(new E0(1)));
        assertEquals(new E0(a), new E0(1).times(new E0(a)));
        assertEquals(new E0(a), new E0(a).times(new E0(1)));

        // Commutative property
        assertEquals(new E0(a * b), new E0(a).times(new E0(b)));
        assertEquals(new E0(a * b), new E0(b).times(new E0(a)));

        // Associative property
        assertEquals(new E0(a * a), new E0(a).times(new E0(a)));
        assertEquals(new E0(b * b), new E0(b).times(new E0(b)));

        // Distributive property
        assertEquals(new E0(a * (b + c)), new E0(a).times(new E0(b).plus(new E0(c))));

    }

    @Test
    void timesGeometricBasis() {
        // Basis E1
        // Random number between 0 and 1000
        double a = Math.random() * 1000;
        double b = Math.random() * 1000;

        // Commutative property
        assertEquals(new E1(a * b), new E0(a).times(new E1(b)));
        assertEquals(new E1(a * b), new E1(b).times(new E0(a)));

        // Associative property
        assertEquals(new E1(a * a), new E0(a).times(new E1(a)));
        assertEquals(new E1(b * b), new E1(b).times(new E0(b)));

        // Basis E2
        // Random number between 0 and 1000
        a = Math.random() * 1000;
        b = Math.random() * 1000;

        // Commutative property
        assertEquals(new E2(a * b), new E0(a).times(new E2(b)));
        assertEquals(new E2(a * b), new E2(b).times(new E0(a)));

        // Associative property
        assertEquals(new E2(a * a), new E0(a).times(new E2(a)));
        assertEquals(new E2(b * b), new E2(b).times(new E0(b)));

        // Basis E3
        // Random number between 0 and 1000
        a = Math.random() * 1000;
        b = Math.random() * 1000;

        // Commutative property
        assertEquals(new E3(a * b), new E0(a).times(new E3(b)));
        assertEquals(new E3(a * b), new E3(b).times(new E0(a)));

        // Associative property
        assertEquals(new E3(a * a), new E0(a).times(new E3(a)));
        assertEquals(new E3(b * b), new E3(b).times(new E0(b)));

        // Basis E1E2
        // Random number between 0 and 1000
        a = Math.random() * 1000;
        b = Math.random() * 1000;

        // Commutative property
        assertEquals(new E1E2(a * b), new E0(a).times(new E1E2(b)));
        assertEquals(new E1E2(a * b), new E1E2(b).times(new E0(a)));

        // Associative property
        assertEquals(new E1E2(a * a), new E0(a).times(new E1E2(a)));
        assertEquals(new E1E2(b * b), new E1E2(b).times(new E0(b)));


    }

    @Test
    void value() {
        // Random number between 0 and 1000
        double a = Math.random() * 1000;

        // Test with 0
        assertEquals(0, new E0(0).value());

        // Test with random number
        assertEquals(a, new E0(a).value());
    }
}