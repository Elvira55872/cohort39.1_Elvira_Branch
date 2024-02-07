package teacher_code;

import java.util.Set;

public class Example {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Установленная дата: " + calendar.getTime());
    }
}
