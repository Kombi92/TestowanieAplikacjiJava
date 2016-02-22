package com.example.junit;

/**
 * Created by Konrad on 15.02.2016.
 */
public class LiczbaRzymska {

    private int liczba;

    public LiczbaRzymska(int liczba) {
        this.liczba = liczba;
    }

    private static final int arabic[] = {1000, 500, 100, 50, 10, 5, 1};
    private static final char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private static final int ROMAN_N = arabic.length;

    //Converts arabic <number> to roman <result>
//Returns <result> or "", if an ERROR occurs.
    public static String toString(int number)
    {
        int i = 0; //position in arabic and roman arrays

        String result = "";

        if ((number > 3999) || (number <= 0))
        {
            return "Przekroczono zakres.";
        }

        while ((number > 0) && (i < ROMAN_N))
        {
            if(number >= arabic[i])
            {
                number -= arabic[i];
                result += roman[i];
            }
            else if ((i%2 == 0) &&
                    (i<ROMAN_N-2) && // 9xx condition
                    (number >= arabic[i] - arabic[i+2]) &&
                    (arabic[i+2] != arabic[i] - arabic[i+2]))
            {
                number -= arabic[i] - arabic[i+2];
                result += roman[i+2];
                result += roman[i];
                i++;
            }
            else if ((i%2 == 1) &&
                    (i<ROMAN_N-1) && //4xx condition
                    (number >= arabic[i] - arabic[i+1]) &&
                    (arabic[i+1] != arabic[i] - arabic[i+1]))
            {
                number -= arabic[i] - arabic[i+1];
                result += roman[i+1];
                result += roman[i];
                i++;
            }
            else
            {
                i++;
            }
        }

        return result;
    }
}
