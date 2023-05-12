package juanmanuel.gealma.basis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasisTest {

    @Test
    void plus() {
        var val1 = 1.0;
        var val2 = 2.0;

        var e1_1 = new E1(val1);
        var e1_2 = new E1(val2);
        var e1_sum = e1_1.plus(e1_2);
        assertEquals(val1 + val2, e1_sum.value());

        var e2_1 = new E2(val1);
        var e2_2 = new E2(val2);
        var e2_sum = e2_1.plus(e2_2);
        assertEquals(val1 + val2, e2_sum.value());

        var e3_1 = new E3(val1);
        var e3_2 = new E3(val2);
        var e3_sum = e3_1.plus(e3_2);
        assertEquals(val1 + val2, e3_sum.value());

        var e4_1 = new E4(val1);
        var e4_2 = new E4(val2);
        var e4_sum = e4_1.plus(e4_2);
        assertEquals(val1 + val2, e4_sum.value());

        var e1e2_1 = new E1E2(val1);
        var e1e2_2 = new E1E2(val2);
        var e1e2_sum = e1e2_1.plus(e1e2_2);
        assertEquals(val1 + val2, e1e2_sum.value());

        var e2e3_1 = new E2E3(val1);
        var e2e3_2 = new E2E3(val2);
        var e2e3_sum = e2e3_1.plus(e2e3_2);
        assertEquals(val1 + val2, e2e3_sum.value());

        var e3e1_1 = new E3E1(val1);
        var e3e1_2 = new E3E1(val2);
        var e3e1_sum = e3e1_1.plus(e3e1_2);
        assertEquals(val1 + val2, e3e1_sum.value());

        var e1e4_1 = new E1E4(val1);
        var e1e4_2 = new E1E4(val2);
        var e1e4_sum = e1e4_1.plus(e1e4_2);
        assertEquals(val1 + val2, e1e4_sum.value());

        var e2e4_1 = new E2E4(val1);
        var e2e4_2 = new E2E4(val2);
        var e2e4_sum = e2e4_1.plus(e2e4_2);
        assertEquals(val1 + val2, e2e4_sum.value());

        var e3e4_1 = new E3E4(val1);
        var e3e4_2 = new E3E4(val2);
        var e3e4_sum = e3e4_1.plus(e3e4_2);
        assertEquals(val1 + val2, e3e4_sum.value());

        var e1e2e3_1 = new E1E2E3(val1);
        var e1e2e3_2 = new E1E2E3(val2);
        var e1e2e3_sum = e1e2e3_1.plus(e1e2e3_2);
        assertEquals(val1 + val2, e1e2e3_sum.value());

        var e2e3e4_1 = new E2E3E4(val1);
        var e2e3e4_2 = new E2E3E4(val2);
        var e2e3e4_sum = e2e3e4_1.plus(e2e3e4_2);
        assertEquals(val1 + val2, e2e3e4_sum.value());

        var e3e4e1_1 = new E3E4E1(val1);
        var e3e4e1_2 = new E3E4E1(val2);
        var e3e4e1_sum = e3e4e1_1.plus(e3e4e1_2);
        assertEquals(val1 + val2, e3e4e1_sum.value());

        var e4e1e2_1 = new E4E1E2(val1);
        var e4e1e2_2 = new E4E1E2(val2);
        var e4e1e2_sum = e4e1e2_1.plus(e4e1e2_2);
        assertEquals(val1 + val2, e4e1e2_sum.value());

        var e1e2e3e4_1 = new E1E2E3E4(val1);
        var e1e2e3e4_2 = new E1E2E3E4(val2);
        var e1e2e3e4_sum = e1e2e3e4_1.plus(e1e2e3e4_2);
        assertEquals(val1 + val2, e1e2e3e4_sum.value());
    }

    @Test
    void minus() {
        var val1 = 1.0;
        var val2 = 2.0;

        var e1_1 = new E1(val1);
        var e1_2 = new E1(val2);
        var e1_sum = e1_1.minus(e1_2);
        assertEquals(val1 - val2, e1_sum.value());

        var e2_1 = new E2(val1);
        var e2_2 = new E2(val2);
        var e2_sum = e2_1.minus(e2_2);
        assertEquals(val1 - val2, e2_sum.value());

        var e3_1 = new E3(val1);
        var e3_2 = new E3(val2);
        var e3_sum = e3_1.minus(e3_2);
        assertEquals(val1 - val2, e3_sum.value());

        var e4_1 = new E4(val1);
        var e4_2 = new E4(val2);
        var e4_sum = e4_1.minus(e4_2);
        assertEquals(val1 - val2, e4_sum.value());

        var e1e2_1 = new E1E2(val1);
        var e1e2_2 = new E1E2(val2);
        var e1e2_sum = e1e2_1.minus(e1e2_2);
        assertEquals(val1 - val2, e1e2_sum.value());

        var e2e3_1 = new E2E3(val1);
        var e2e3_2 = new E2E3(val2);
        var e2e3_sum = e2e3_1.minus(e2e3_2);
        assertEquals(val1 - val2, e2e3_sum.value());

        var e3e1_1 = new E3E1(val1);
        var e3e1_2 = new E3E1(val2);
        var e3e1_sum = e3e1_1.minus(e3e1_2);
        assertEquals(val1 - val2, e3e1_sum.value());

        var e1e4_1 = new E1E4(val1);
        var e1e4_2 = new E1E4(val2);
        var e1e4_sum = e1e4_1.minus(e1e4_2);
        assertEquals(val1 - val2, e1e4_sum.value());

        var e2e4_1 = new E2E4(val1);
        var e2e4_2 = new E2E4(val2);
        var e2e4_sum = e2e4_1.minus(e2e4_2);
        assertEquals(val1 - val2, e2e4_sum.value());

        var e3e4_1 = new E3E4(val1);
        var e3e4_2 = new E3E4(val2);
        var e3e4_sum = e3e4_1.minus(e3e4_2);
        assertEquals(val1 - val2, e3e4_sum.value());

        var e1e2e3_1 = new E1E2E3(val1);
        var e1e2e3_2 = new E1E2E3(val2);
        var e1e2e3_sum = e1e2e3_1.minus(e1e2e3_2);
        assertEquals(val1 - val2, e1e2e3_sum.value());

        var e2e3e4_1 = new E2E3E4(val1);
        var e2e3e4_2 = new E2E3E4(val2);
        var e2e3e4_sum = e2e3e4_1.minus(e2e3e4_2);
        assertEquals(val1 - val2, e2e3e4_sum.value());

        var e3e4e1_1 = new E3E4E1(val1);
        var e3e4e1_2 = new E3E4E1(val2);
        var e3e4e1_sum = e3e4e1_1.minus(e3e4e1_2);
        assertEquals(val1 - val2, e3e4e1_sum.value());

        var e4e1e2_1 = new E4E1E2(val1);
        var e4e1e2_2 = new E4E1E2(val2);
        var e4e1e2_sum = e4e1e2_1.minus(e4e1e2_2);
        assertEquals(val1 - val2, e4e1e2_sum.value());

        var e1e2e3e4_1 = new E1E2E3E4(val1);
        var e1e2e3e4_2 = new E1E2E3E4(val2);
        var e1e2e3e4_sum = e1e2e3e4_1.minus(e1e2e3e4_2);
        assertEquals(val1 - val2, e1e2e3e4_sum.value());
    }

    @Test
    void unaryMinus() {
        var val1 = 1.0;

        var e1_1 = new E1(val1);
        assertEquals(-val1, e1_1.unaryMinus().value());

        var e2_1 = new E2(val1);
        assertEquals(-val1, e2_1.unaryMinus().value());

        var e3_1 = new E3(val1);
        assertEquals(-val1, e3_1.unaryMinus().value());

        var e4_1 = new E4(val1);
        assertEquals(-val1, e4_1.unaryMinus().value());

        var e1e2_1 = new E1E2(val1);
        assertEquals(-val1, e1e2_1.unaryMinus().value());

        var e2e3_1 = new E2E3(val1);
        assertEquals(-val1, e2e3_1.unaryMinus().value());

        var e3e1_1 = new E3E1(val1);
        assertEquals(-val1, e3e1_1.unaryMinus().value());

        var e1e4_1 = new E1E4(val1);
        assertEquals(-val1, e1e4_1.unaryMinus().value());

        var e2e4_1 = new E2E4(val1);
        assertEquals(-val1, e2e4_1.unaryMinus().value());

        var e3e4_1 = new E3E4(val1);
        assertEquals(-val1, e3e4_1.unaryMinus().value());

        var e1e2e3_1 = new E1E2E3(val1);
        assertEquals(-val1, e1e2e3_1.unaryMinus().value());

        var e2e3e4_1 = new E2E3E4(val1);
        assertEquals(-val1, e2e3e4_1.unaryMinus().value());

        var e3e4e1_1 = new E3E4E1(val1);
        assertEquals(-val1, e3e4e1_1.unaryMinus().value());

        var e4e1e2_1 = new E4E1E2(val1);
        assertEquals(-val1, e4e1e2_1.unaryMinus().value());

        var e1e2e3e4_1 = new E1E2E3E4(val1);
        assertEquals(-val1, e1e2e3e4_1.unaryMinus().value());
    }

    @Test
    void timesScalar() {
    }

    @Test
    void timesSelf() {
    }

    @Test
    void value() {
    }
}