import java.util.Arrays;

/**
 * Lesson_19 добавьте в ваш класс логику наследования,
 * переопределите указанные методы (@Override) в вашем основном классе.
 */
public class ResidentialUnit {
    String[] arrRoomers = new String[0];
    String[] roomers = new String[0];
    public String[] setRoomer(String resident) {
        arrRoomers = Arrays.copyOf(arrRoomers, arrRoomers.length + 1);
        arrRoomers[arrRoomers.length - 1] = resident;
        return roomers;
    }
    public String[] removeRoomer(String resident) {
        for (int i = 0; i < arrRoomers.length; i++) {
            if (arrRoomers[i] == resident) {
                arrRoomers[i] = arrRoomers[arrRoomers.length - 1];
                arrRoomers = Arrays.copyOf(arrRoomers, arrRoomers.length - 1);
            } else {
                continue;
            }
        }
        System.out.printf("\n %s был выселен из квартиры", resident);
        return arrRoomers;
    }
    public void showInfo() {}
}