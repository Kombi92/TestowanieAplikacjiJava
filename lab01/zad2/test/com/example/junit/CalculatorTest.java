package com.example.junit;

import static org.junit.Assert.*;

import org.junit.matchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * Created by Konrad on 15.02.2016.
 */
public class CalculatorTest {

    private Calculator calc = new Calculator();


    @Test
    public void addCheck(){

        assertEquals(6,calc.add(3.4,2.6),0);

    }

    @Test
    public void subCheck(){

        assertEquals(0.9,calc.sub(3.1,2.2),0.00000001);
    }

    @Test
    public void multiCheck(){

        assertEquals(6,calc.multi(3,2),0);
    }

    @Test
    public void divCheck(){

        assertEquals(3.0,calc.div(6,2),0);
    }

    @Test
    public void greaterCheck(){

        assertTrue(calc.greater(6,2));
    }

}
