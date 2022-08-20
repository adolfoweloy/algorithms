package com.adolfoeloy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumbersTest {

    private RomanNumbers romanNumbers = new RomanNumbers();

    @Test
    void shouldReturnUnitsProperly() {
        assertEquals("I", romanNumbers.intToRoman(1));
        assertEquals("II", romanNumbers.intToRoman(2));
        assertEquals("III", romanNumbers.intToRoman(3));
        assertEquals("V", romanNumbers.intToRoman(5));
        assertEquals("VII", romanNumbers.intToRoman(7));
        assertEquals("IV", romanNumbers.intToRoman(4));
        assertEquals("IX", romanNumbers.intToRoman(9));
    }

    @Test
    void shouldReturnDecimalsProperly() {
        assertEquals("X", romanNumbers.intToRoman(10));
        assertEquals("XIII", romanNumbers.intToRoman(13));
        assertEquals("XIV", romanNumbers.intToRoman(14));
        assertEquals("XIX", romanNumbers.intToRoman(19));
        assertEquals("XXVIII", romanNumbers.intToRoman(28));
        assertEquals("XLVIII", romanNumbers.intToRoman(48));
        assertEquals("LIV", romanNumbers.intToRoman(54));
        assertEquals("XCIV", romanNumbers.intToRoman(94));
    }

    @Test
    void shouldReturnRomanProperly() {
        assertEquals(1, romanNumbers.romanToInt("I"));
        assertEquals(3, romanNumbers.romanToInt("III"));
        assertEquals(5, romanNumbers.romanToInt("V"));
        assertEquals(4, romanNumbers.romanToInt("IV"));
        assertEquals(9, romanNumbers.romanToInt("IX"));
        assertEquals(19, romanNumbers.romanToInt("XIX"));
        assertEquals(39, romanNumbers.romanToInt("XXXIX"));
        assertEquals(147, romanNumbers.romanToInt("CXLVII"));
        assertEquals(2147, romanNumbers.romanToInt("MMCXLVII"));
    }
}