package com.fk.roman.domain;

import java.util.ArrayList;
import java.util.List;

import static com.fk.roman.domain.Numeral.*;

public class Converter {
    public static String toRoman(Integer digit) {
        ConversionSet toConvert = new ConversionSet(digit, "");

        if (digit > HARD_LIMIT) {
            return "Limit has been reached. Will not convert over " + HARD_LIMIT;
        }

        List<Integer> bounds = new ArrayList<>();
        for (Numeral numeral : Numeral.values()) {
            bounds.add(numeral.getDigit());
        }

        for (int boundCompare = 0; boundCompare < bounds.size() - 1; boundCompare++) {
            if (0 == boundCompare) {
                toConvert = addRomanNumeralsForBounds(toConvert, THOUSAND.getDigit(), HARD_LIMIT);
            }
            toConvert = addRomanNumeralsForBounds(toConvert, bounds.get(boundCompare + 1), bounds.get(boundCompare));
        }

        return toConvert.numerals();
    }

    private static ConversionSet addRomanNumeralsForBounds(ConversionSet pair, Integer lowerBound, Integer higherBound) {
        ConversionSet newPair = new ConversionSet(pair.digits(), pair.numerals());

        int euclideanRemainder = Math.floorDiv(newPair.digits(), lowerBound);

        for (int index = 0; index < euclideanRemainder; index++) {
            newPair = new ConversionSet(
                    newPair.digits() - lowerBound,
                    newPair.numerals().concat(getNumeralValueFromDigit(lowerBound)));
        }

        return newPair;
    }

    private static String getNumeralValueFromDigit(Integer digit) {
        return fromDigit(digit).isPresent() ? fromDigit(digit).get().getRoman() : "";
    }
}
