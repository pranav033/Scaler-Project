package org.example.productcatalogservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testAdd_2Integers_RunSuccessfully() {
        //arrange
        Calculator cal = new Calculator();
        //act
        int added = cal.add(2, 3);
        //assert
        assert(added==5);
    }

    @Test
    public void testDivide_ByZero_ArihtmeticExceptionExpected()
    {
        //assert
        Calculator cal = new Calculator();

        assertThrows(ArithmeticException.class,()->cal.divide(2,0));
    }

}