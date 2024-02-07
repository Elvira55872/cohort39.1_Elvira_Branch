import java.util.Arrays;

public class ResidentialUnit {
    String[] arrRoomers = new String[0];
    String[] roomers = new String[0];

    public void setRoomer(String resident) {
        arrRoomers = Arrays.copyOf(arrRoomers, arrRoomers.length + 1);
        arrRoomers[arrRoomers.length - 1] = resident;
    }

    public void removeRoomer(String resident) {
        for (int i = 0; i < arrRoomers.length; i++) {
            if (arrRoomers[i] == resident) {
                arrRoomers[i] = arrRoomers[arrRoomers.length - 1];
                arrRoomers = Arrays.copyOf(arrRoomers, arrRoomers.length - 1);
            } else {
                continue;
            }
        }
        System.out.printf("\n %s был выселен из квартиры", resident);
    }

    public void showInfo() {
    }
}
