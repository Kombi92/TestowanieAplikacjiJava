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

        assertEquals(5,calc.add(3,2));
    }

    @Test
    public void subCheck(){

        assertEquals(1,calc.sub(3,2));
    }

    @Test
    public void multiCheck(){

        assertEquals(6,calc.multi(3,2));
    }

    @Test
    public void divCheck(){

        assertEquals(3,calc.div(6,2));
    }

    @Test
    public void greaterCheck(){

        assertTrue(calc.greater(6,2));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    /*
    @Test
    public void divZeroCheck() throws ArithmeticException{

        calc.div(5,0);
        thrown.expect(ArithmeticException.class);
        //thrown.expectMessage("/ by zero ");
    }
    */
    @Test(expected = ArithmeticException.class)
    public void empty() {
        calc.div(5,0);
    }
}
