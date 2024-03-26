package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import org.junit.Test;

public class CalculatriceTest {

    private Calculatrice calculatrice;

    @Before
    public void setUp() {
        calculatrice = new Calculatrice();
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculatrice.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, calculatrice.subtract(2, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculatrice.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculatrice.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculatrice.divide(1, 0);
        });
    }
}
