package practice.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.time.Duration;
import java.time.ZoneId;

public class DateTimePracticeTasks {

    /**
     * Задача 1: Рассчитайте возраст человека на основе его даты рождения.
     *
     * @param birthdate Дата рождения человека в формате "yyyy-MM-dd".
     * @return Возраст человека в годах.
     */
    public static int calculateAge(String birthdate) {
        return 0;
    }

    /**
     * Задача 2: Определите, сколько времени прошло между двумя моментами времени в течение дня.
     *
     * @param startTime Время начала в формате "HH:mm:ss".
     * @param endTime Время окончания в формате "HH:mm:ss".
     * @return Продолжительность между двумя моментами времени в минутах.
     */
    public static long timeBetween(String startTime, String endTime) {
        return 0;
    }

    /**
     * Задача 3: Переведите момент времени из одного часового пояса в другой.
     *
     * @param dateTime Дата и время в формате "yyyy-MM-ddTHH:mm:ss".
     * @param fromZoneId ID исходного часового пояса.
     * @param toZoneId ID целевого часового пояса.
     * @return Строка с датой и временем в целевом часовом поясе.
     */
    public static String convertTimeZone(String dateTime, String fromZoneId, String toZoneId) {
        return null;
    }

    /**
     * Задача 4: Найдите день недели для даты.
     *
     * @param date Дата в формате "yyyy-MM-dd".
     * @return День недели в текстовом формате (например, "Понедельник").
     */
    public static String findDayOfWeek(String date) {
        return null;
    }

    /**
     * Задача 5: Форматируйте текущую дату и время в красивом формате.
     *
     * @return Текущая дата и время в формате "dd MMMM yyyy, EEEE HH:mm:ss".
     */
    public static String formatCurrentDateTime() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Age: " + calculateAge("1990-01-01"));
        System.out.println("Minutes between: " + timeBetween("09:00:00", "10:30:00"));
        System.out.println("Time zone conversion: " + convertTimeZone("2023-01-01T15:00:00", "Europe/London", "Asia/Tokyo"));
        System.out.println("Day of week: " + findDayOfWeek("2023-01-01"));
        System.out.println("Formatted current date and time: " + formatCurrentDateTime());
    }
}

