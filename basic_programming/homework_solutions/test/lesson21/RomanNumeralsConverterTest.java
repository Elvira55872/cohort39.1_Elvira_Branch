package lesson21;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsConverterTest {

    @Test
    public void testValidRomanNumerals() {
        assertEquals(3, RomanNumeralsConverter.convertRomanToDecimal("III"));
        assertEquals(58, RomanNumeralsConverter.convertRomanToDecimal("LVIII"));
        assertEquals(1994, RomanNumeralsConverter.convertRomanToDecimal("MCMXCIV"));
        assertEquals(4, RomanNumeralsConverter.convertRomanToDecimal("IV"));
        assertEquals(9, RomanNumeralsConverter.convertRomanToDecimal("IX"));
    }

    @Test
    public void testInvalidRomanNumerals() {
        assertEquals(-1, RomanNumeralsConverter.convertRomanToDecimal("ABC"));
        assertEquals(-1, RomanNumeralsConverter.convertRomanToDecimal("IIII"));
        assertEquals(-1, RomanNumeralsConverter.convertRomanToDecimal("VV"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(-1, RomanNumeralsConverter.convertRomanToDecimal(""));
    }

    @Test
    public void testNullInput() {
        assertEquals(-1, RomanNumeralsConverter.convertRomanToDecimal(null));
    }
}

