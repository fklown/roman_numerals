package com.fk.roman.domain;

import org.junit.jupiter.api.Test;

import static com.fk.roman.domain.Converter.*;
import static com.fk.roman.domain.Numeral.*;
import static org.junit.jupiter.api.Assertions.*;

class ConverterUnitTest {
    private final String romanTwo = ONE.getRoman() + ONE.getRoman();
    private final String romanThree = romanTwo + ONE.getRoman();
    private final String romanEight = FIVE.getRoman() + romanThree;
    private final String romanEleven = TEN.getRoman() + ONE.getRoman();
    private final String romanFourteen = TEN.getRoman() + FOUR.getRoman();
    private final String romanFifteen = TEN.getRoman() + FIVE.getRoman();
    private final String romanNineteen = TEN.getRoman() + NINE.getRoman();
    private final String romanTwenty = TEN.getRoman() + TEN.getRoman();
    private final String romanThirtyNine = romanTwenty + romanNineteen;
    private final String romanForty = TEN.getRoman() + FIFTY.getRoman();
    private final String romanFortyOne = romanForty + ONE.getRoman();
    private final String romanFortyFour = romanForty + FOUR.getRoman();
    private final String romanFortyFive = romanForty + FIVE.getRoman();
    private final String romanFortyEight = romanForty + romanEight;
    private final String romanFortyNine = romanForty + NINE.getRoman();
    private final String romanFiftyOne = FIFTY.getRoman() + ONE.getRoman();
    private final String romanSixtyFive = FIFTY.getRoman() + TEN.getRoman() + FIVE.getRoman();
    private final String romanSeventyFour = FIFTY.getRoman() + romanTwenty + FOUR.getRoman();
    private final String romanEightyNine = FIFTY.getRoman() + romanTwenty + romanNineteen;
    private final String romanNinety = TEN.getRoman() + HUNDRED.getRoman();
    private final String romanNinetyOne = romanNinety + ONE.getRoman();
    private final String romanNinetyFour = romanNinety + FOUR.getRoman();
    private final String romanNinetyFive = romanNinety + FIVE.getRoman();
    private final String romanNinetyNine = romanNinety + NINE.getRoman();
    private final String romanTwoHundred = HUNDRED.getRoman() + HUNDRED.getRoman();
    private final String romanThreeHundredAndOne = romanTwoHundred + HUNDRED.getRoman() + ONE.getRoman();
    private final String romanFourHundredAndFour = HUNDRED.getRoman() + FIVE_HUNDRED.getRoman() + FOUR.getRoman();
    private final String romanEightHundredAndFive = FIVE_HUNDRED.getRoman() + romanTwoHundred + HUNDRED.getRoman() + FIVE.getRoman();
    private final String romanNineHundredAndNinetyNine = HUNDRED.getRoman() + THOUSAND.getRoman() + romanNinetyNine;
    private final String romanTwoThousandNinetyNine = THOUSAND.getRoman() + THOUSAND.getRoman() + romanNinetyNine;
    private final String romanThreeThousand = THOUSAND.getRoman() + THOUSAND.getRoman() + THOUSAND.getRoman();
    private final String romanFourThousandFourHundredTwentyFour =
            romanThreeThousand + THOUSAND.getRoman() + HUNDRED.getRoman() + FIVE_HUNDRED.getRoman() + romanTwenty + FOUR.getRoman();
    private final String romanNineThousand = romanThreeThousand + romanThreeThousand + romanThreeThousand;

    @Test
    void convert_digitZero_doesNotReturnNumeral() {
        assertEquals("", toRoman(0));
    }

    @Test
    void convert_digitExceedsLimit_doesNotReturnNumeral() {
        assertEquals("Limit has been reached. Will not convert over " + HARD_LIMIT, toRoman(10001));
    }

    @Test
    void convert_digitAboveZeroLessThanFour_returnRoman() {
        assertEquals(ONE.getRoman(), toRoman(1));
        assertEquals(romanTwo, toRoman(2));
        assertEquals(romanThree, toRoman(3));
    }

    @Test
    void convert_digitAboveThreeLessThanNine_returnRoman() {
        assertEquals(FOUR.getRoman(), toRoman(4));
        assertEquals(FIVE.getRoman(), toRoman(5));
        assertEquals(romanEight, toRoman(8));
    }

    @Test
    void convert_digitAboveEightLessThanEleven_returnRoman() {
        assertEquals(NINE.getRoman(), toRoman(9));
        assertEquals(TEN.getRoman(), toRoman(10));
    }

    @Test
    void convert_digitAboveTenLessThanForty_returnRoman() {
        assertEquals(romanEleven, toRoman(11));
        assertEquals(romanFourteen, toRoman(14));
        assertEquals(romanFifteen, toRoman(15));
        assertEquals(romanNineteen, toRoman(19));
        assertEquals(romanTwenty, toRoman(20));
        assertEquals(romanThirtyNine, toRoman(39));
    }

    @Test
    void convert_digitAboveThirtyNineLessThanFifty_returnRoman() {
        assertEquals(romanForty, toRoman(40));
        assertEquals(romanFortyOne, toRoman(41));
        assertEquals(romanFortyFour, toRoman(44));
        assertEquals(romanFortyFive, toRoman(45));
        assertEquals(romanFortyEight, toRoman(48));
        assertEquals(romanFortyNine, toRoman(49));
    }

    @Test
    void convert_digitAboveFortyNineLessThanNinety_returnRoman() {
        assertEquals(FIFTY.getRoman(), toRoman(50));
        assertEquals(romanFiftyOne, toRoman(51));
        assertEquals(romanSixtyFive, toRoman(65));
        assertEquals(romanSeventyFour, toRoman(74));
        assertEquals(romanEightyNine, toRoman(89));
    }

    @Test
    void convert_digitAboveEightyNineLessThanAHundred_returnRoman() {
        assertEquals(romanNinety, toRoman(90));
        assertEquals(romanNinetyOne, toRoman(91));
        assertEquals(romanNinetyFour, toRoman(94));
        assertEquals(romanNinetyFive, toRoman(95));
        assertEquals(romanNinetyNine, toRoman(99));
    }

    @Test
    void convert_digitAboveNinetyNineLessThanAThousand_returnRoman() {
        assertEquals(HUNDRED.getRoman(), toRoman(100));
        assertEquals(romanThreeHundredAndOne, toRoman(301));
        assertEquals(romanFourHundredAndFour, toRoman(404));
        assertEquals(FIVE_HUNDRED.getRoman(), toRoman(500));
        assertEquals(romanEightHundredAndFive, toRoman(805));
        assertEquals(romanNineHundredAndNinetyNine, toRoman(999));
    }

    @Test
    void convert_digitAboveAThousandLessThanTenThousand_returnRoman() {
        assertEquals(THOUSAND.getRoman(), toRoman(1000));
        assertEquals("MCDXCIX", toRoman(1499));
        assertEquals("MCMLXXXVII", toRoman(1987));
        assertEquals(romanTwoThousandNinetyNine, toRoman(2099));
        assertEquals(romanThreeThousand, toRoman(3000));
        assertEquals(romanFourThousandFourHundredTwentyFour, toRoman(4424));
        assertEquals(romanNineThousand, toRoman(9000));
    }

}