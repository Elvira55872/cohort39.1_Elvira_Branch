package practice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.ZoneId;

public class DateTimeFormatParseExample {

    public static void main(String[] args) {
        // Пример форматирования даты с использованием стандартных форматов
        LocalDate date = LocalDate.now();
        System.out.println("Стандартное форматирование даты (ISO_LOCAL_DATE): " + date.format(DateTimeFormatter.ISO_LOCAL_DATE));

        // Пример форматирования времени с использованием пользовательского формата
        LocalTime time = LocalTime.now();
        DateTimeFormatter customTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Пользовательское форматирование времени: " + time.format(customTimeFormatter));

        // Пример форматирования даты и времени с использованием локализованного формата
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter localizedFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm", java.util.Locale.ENGLISH);
        System.out.println("Локализованное форматирование даты и времени: " + dateTime.format(localizedFormatter));

        // Пример разбора (парсинга) даты из строки
        try {
            String dateString = "2023-01-28";
            LocalDate parsedDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            System.out.println("Разбор даты из строки: " + parsedDate);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка при разборе даты: " + e.getMessage());
        }

        // Пример разбора (парсинга) времени из строки
        try {
            String timeString = "15:45:30";
            LocalTime parsedTime = LocalTime.parse(timeString, customTimeFormatter);
            System.out.println("Разбор времени из строки: " + parsedTime);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка при разборе времени: " + e.getMessage());
        }

        // Пример работы с часовыми поясами и ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("Текущее время в Париже: " + zonedDateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss z")));

        // Изменение часового пояса для ZonedDateTime
        ZonedDateTime zonedDateTimeInNY = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("То же время в Нью-Йорке: " + zonedDateTimeInNY.format(DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss z")));
    }
}

