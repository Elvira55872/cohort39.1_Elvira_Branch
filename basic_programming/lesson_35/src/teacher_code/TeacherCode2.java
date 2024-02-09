package teacher_code;

import java.time.*;

public class TeacherCode2 {
    public static void main(String[] args) throws InterruptedException {

        LocalDateTime localDateTime  = LocalDateTime.of(2023, 12, 15, 12, 12, 12);

        LocalDate date = localDateTime.toLocalDate();
        LocalTime time = localDateTime.toLocalTime();

        ZonedDateTime zonedDateTimeParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        ZonedDateTime zonedDateTimeTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime zonedDateTimePhoenix = ZonedDateTime.now(ZoneId.of("America/Phoenix"));

        System.out.println("zonedDateTimeParis = " + zonedDateTimeParis);
        System.out.println("zonedDateTimeTokyo = " + zonedDateTimeTokyo);
        System.out.println("zonedDateTimeCal = " + zonedDateTimePhoenix);


    }
}
