package com.fk.roman.domain;

import java.util.Arrays;
import java.util.Optional;
import lombok.Getter;

@Getter
public enum Numeral {
    THOUSAND(1000, "M"),
    NINE_HUNDRED(900, "CM"),
    FIVE_HUNDRED(500, "D"),
    FOUR_HUNDRED(400, "CD"),
    HUNDRED(100, "C"),
    NINETY(90, "XC"),
    FIFTY(50, "L"),
    FORTY(40, "XL"),
    TEN(10, "X"),
    NINE(9, "IX"),
    FIVE(5, "V"),
    FOUR(4, "IV"),
    ONE(1, "I");

    public static final Integer HARD_LIMIT = 10000;
    private final int digit;
    private final String roman;

    Numeral(int digit, String roman) {
        this.digit = digit;
        this.roman = roman;
    }

    public static Optional<Numeral> fromDigit(int digit) {
        return Arrays.stream(Numeral.values())
                .filter(numeral -> numeral.getDigit() == digit)
                .findFirst();
    }
}
