package com.example.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Konrad on 15.02.2016.
 */
public class LiczbaRzymskaTest {


    @Test
    public void chceckRoman(){

        assertEquals(LiczbaRzymska.toString(10) , "X" );
        assertEquals(LiczbaRzymska.toString(11) , "XI" );
        assertEquals(LiczbaRzymska.toString(4) , "IV" );
        assertEquals(LiczbaRzymska.toString(1410) , "MCDX" );

    }

    @Test
    public void chceckRange(){

        assertEquals(LiczbaRzymska.toString(0) , "Przekroczono zakres." );
        assertEquals(LiczbaRzymska.toString(-3) , "Przekroczono zakres." );
        assertEquals(LiczbaRzymska.toString(5000) , "Przekroczono zakres." );

    }

}
