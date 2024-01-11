package lesson21;

public class RomanNumeralsConverter {

    /**
     * Конвертирует римское число в десятичное.
     *
     * @param roman строка, представляющая римское число.
     * @return десятичное представление римского числа или -1, если строка невалидна.
     */
    public static int convertRomanToDecimal(String roman) {
        // Проверка на null и пустую строку
        if (roman == null || roman.isEmpty()) {
            System.err.println("Invalid input: The string cannot be null or empty.");
            return -1;
        }

        int decimal = 0; // Десятичное значение римского числа
        int lastNumber = 0; // Последнее обработанное числовое значение символа
        char lastChar = ' '; // Последний обработанный символ

        // Обход строки с римским числом с конца к началу
        for (int i = roman.length() - 1; i >= 0; i--) {
            char ch = roman.charAt(i); // Текущий символ
            int currentNumber = romanToDecimal(ch); // Числовое значение текущего символа

            // Проверка на невалидный символ
            if (currentNumber < 0) {
                System.err.println("Invalid character in Roman numeral: " + ch);
                return -1;
            }

            // Проверка на недопустимое повторение символов
            if (ch == lastChar) {
                if (ch == 'V' || ch == 'L' || ch == 'D') {
                    System.err.println("Invalid Roman numeral sequence: " + ch + " cannot be repeated.");
                    return -1;
                } else if (i < roman.length() - 3 && roman.charAt(i + 2) == ch && roman.charAt(i + 3) == ch) {
                    System.err.println("Invalid Roman numeral sequence: Too many repeated characters.");
                    return -1;
                }
            }

            // Расчет десятичного значения с учетом порядка символов
            if (currentNumber < lastNumber) {
                decimal -= currentNumber;
            } else {
                decimal += currentNumber;
            }

            lastNumber = currentNumber; // Обновление последнего числового значения
            lastChar = ch; // Обновление последнего символа
        }

        return decimal; // Возвращение результата
    }

    /**
     * Конвертирует символ римского числа в его десятичное значение.
     *
     * @param ch символ римского числа.
     * @return десятичное значение символа или -1, если символ невалиден.
     */
    private static int romanToDecimal(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1; // В случае невалидного символа
        }
    }
}
