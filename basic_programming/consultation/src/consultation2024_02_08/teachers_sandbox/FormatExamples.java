package consultation2024_02_08.teachers_sandbox;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class FormatExamples {
    public static void main(String[] args) {
        // Пример 1: Форматирование строк с использованием плейсхолдеров
        String name = "Ильяс";
        int age = 30;
        String formattedString = String.format("Привет, %s! Тебе %d лет.", name, age);
        System.out.println(formattedString);

        // Пример 2: Форматирование чисел с фиксированной точкой
        double pi = Math.PI;
        String formattedNumber = String.format("Значение числа π с тремя знаками после запятой: %.3f", pi);
        System.out.println(formattedNumber);

        // Пример 3: Вывод чисел с ведущими нулями
        int receiptNumber = 42;
        String formattedReceiptNumber = String.format("Номер квитанции: %05d", receiptNumber);
        System.out.println(formattedReceiptNumber);

        // Пример 4: Форматирование даты и времени

        LocalDate date  = LocalDate.now();
        LocalTime time = LocalTime.now();
        String formattedDate = String.format("Текущая дата и время: %tF %tT", date, time);
        System.out.println(formattedDate);

        // Пример 5: Выравнивание текста и задание ширины поля
        String leftAligned = String.format("|%-10s|", "left"); // Выравнивание влево
        String rightAligned = String.format("|%10s|", "right"); // Выравнивание вправо
        System.out.println(leftAligned);
        System.out.println(rightAligned);

        // Пример 6: Форматирование с использованием локализации
        double price = 12345.6789;
        String formattedPriceUS = String.format(java.util.Locale.US, "Цена (US): %,.2f долларов", price);
        String formattedPriceGermany = String.format(java.util.Locale.GERMANY, "Цена (DE): %,.2f евро", price);
        System.out.println(formattedPriceUS);
        System.out.println(formattedPriceGermany);
    }
}

