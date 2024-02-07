package practice.task;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeConversionTasks {

    /**
     * Задача 1: Конвертация времени из одной часовой зоны в другую.
     * Принимает время в виде строки и часовые пояса для конвертации.
     *
     * @param timeString Время в формате "yyyy-MM-dd HH:mm:ss".
     * @param fromZoneId Исходный часовой пояс.
     * @param toZoneId Целевой часовой пояс.
     * @return Строка времени в целевом часовом поясе.
     */
    public static String convertTimeZone(String timeString, String fromZoneId, String toZoneId) {
        return null;
    }

    /**
     * Задача 2: Парсинг времени ввода пользователя в одной часовой зоне и вывод в UTC.
     *
     * @param userTimeString Время в формате "HH:mm:ss".
     * @param userZoneId Часовой пояс пользователя.
     * @return Время в UTC в формате "HH:mm:ss".
     */
    public static String convertUserTimeToUTC(String userTimeString, String userZoneId) {
        return null;
    }

    /**
     * Задача 3: Парсинг строки даты и времени, добавление временного интервала и конвертация результата в другой часовой пояс.
     *
     * @param dateTimeString Дата и время в формате "yyyy-MM-ddTHH:mm".
     * @param hoursToAdd Количество часов, которые нужно добавить.
     * @param targetZoneId Целевой часовой пояс для конвертации результата.
     * @return Результат в формате "yyyy-MM-dd HH:mm:ss z" в целевом часовом поясе.
     */
    public static String parseAddAndConvert(String dateTimeString, long hoursToAdd, String targetZoneId) {
        return null;
    }

    public static void main(String[] args) {
        // Пример использования задач
        System.out.println(convertTimeZone("2023-01-01 15:00:00", "America/New_York", "Asia/Tokyo"));
        System.out.println(convertUserTimeToUTC("20:00:00", "Europe/London"));
        System.out.println(parseAddAndConvert("2023-01-01T10:00", 5, "Asia/Kolkata"));
    }
}

