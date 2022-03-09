package com.fk.roman.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumeralUnitTest {

    @Test
    void getValueFromEnum_returnsNumeral(){
        String romanValueOfAHundred = "C";
        int integerValueOfAHundred = 100;

        String roman = Numeral.HUNDRED.getRoman();
        int  digit = Numeral.HUNDRED.getDigit();

        assertEquals(romanValueOfAHundred, roman);
        assertEquals(integerValueOfAHundred, digit);
    }
}