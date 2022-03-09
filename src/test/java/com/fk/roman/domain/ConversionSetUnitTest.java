package com.fk.roman.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionSetUnitTest {
    ConversionSet blankConversionSet = new ConversionSet(0, "");

    @Test
    void getNumerals_withoutNumeralsOrDigits_shouldReturnValue() {
        assertNotNull(blankConversionSet.digits());
        assertNotNull(blankConversionSet.numerals());
    }
}