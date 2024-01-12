import java.util.Arrays;

public class Flat extends ResidentialUnit implements Rentable {
    // protected and STATIC:
    // STATIC тк данные для всех квартир одинаковые
    protected static String address = "ул Кольцевая д 1";
    protected static int[] arrFlats = new int[0];

    // protected but not static:
    // эти данные могут знать все, в них нет ничего секретного, но они индивидуальны для каждой квартиры
    protected int numberOfFlat;
    protected int floorNumber;

    // PRIVATE but not static:
    // PRIVATE тк эти данные не надо знать никому, кроме тех кто живет в квартире
    private double square;
    private int amountOfRooms;
    private String[] arrRoomers = new String[0];

    // Конструктор класса Flat
    protected Flat(int numberOfFlat, double square, int amountOfRooms, int floorNumber, String roomers) {
        this.numberOfFlat = numberOfFlat;
        this.square = square;
        this.amountOfRooms = amountOfRooms;
        this.floorNumber = floorNumber;
        this.arrRoomers = roomers.split("\\s+");
    }

    // Метод для создания квартиры
    public static Flat setFlat(int numberOfFlat, double square, int amountOfRooms, int floorNumber, String roomers) {
        boolean isFlatExist = false;
        for (int i = 0; i < arrFlats.length; i++) {
            if (numberOfFlat == arrFlats[i] || numberOfFlat < 0 || numberOfFlat >= 300) {
                isFlatExist = true;
                break;
            }
        }

        if (isFlatExist) {
            System.out.println("Введите другой номер квартиры. " + numberOfFlat +
                    " уже существует или вы ввели цифру больше 300. Введите новое значение от 1 до 300");
            return null;
        } else {
            arrFlats = Arrays.copyOf(arrFlats, arrFlats.length + 1);
            arrFlats[arrFlats.length - 1] = numberOfFlat;
            Flat flat = new Flat(numberOfFlat, square, amountOfRooms, floorNumber, roomers);
            System.out.println("Квартира под номером " + numberOfFlat + " успешно создана");
            return flat;
        }
    }

    //ОПЕРАЦИИ С ЖИЛЬЦАМИ (изменила с void на возвращающее значение)
    // Метод для добавления жильца
    @Override
    public String[] setRoomer(String name) {
        if (arrRoomers.length < 5) {
            arrRoomers = Arrays.copyOf(arrRoomers, arrRoomers.length + 1);
            arrRoomers[arrRoomers.length - 1] = name;
            System.out.printf("\n %s теперь живет в квартире %d", name, numberOfFlat);
        } else {
            System.out.println("В квартире не может жить больше 5 людей");
        }
        return arrRoomers;
    }
    // Метод для удаления жильца
    @Override
    public String[] removeRoomer(String name) {
        for (int i = 0; i < arrRoomers.length; i++) {
            if (arrRoomers[i] == name) {
                arrRoomers[i] = arrRoomers[arrRoomers.length - 1];
                arrRoomers = Arrays.copyOf(arrRoomers, arrRoomers.length - 1);
            } else {
                continue;
            }
        }
        System.out.printf("\n %s был выселен из квартиры %d ", name, numberOfFlat);
        return arrRoomers;
    }

    //ГЕТТЕРЫ
    // Метод для получения номера квартиры
    public int getNumberOfFlat() {
        System.out.println("\nНомер квартиры:" + numberOfFlat);
        return numberOfFlat;
    }

    // Метод для получения списка проживающих в определенной квартире
    public String getRoomers() {
        System.out.printf("\n В квартире %d живут %s", numberOfFlat, Arrays.toString(arrRoomers));
        return Arrays.toString(arrRoomers);
    }

    // Метод для получения списка всех существующих квартир в доме
    public static String getArrFlats() {
        System.out.printf("\n В доме по адресу %s есть квартиры %s", address, Arrays.toString(arrFlats));
        return Arrays.toString(arrFlats);
    }

    // Метод для получения адреса дома
    public static String getAddres() {
        System.out.printf("\n Адрес: %s", address);
        return address;
    }

    // Метод для вывода информации
    @Override
    public void showInfo() {
        System.out.printf("\n По адресу %s кв %d \n живут %s. \n Площадь квартиры: %.2f\n Кол-во комнат: %d\n Этаж: %d",
                address, numberOfFlat, Arrays.toString(arrRoomers), square, amountOfRooms, floorNumber);
    }

    //Методы toString() и equals() в Наследовании
    @Override
    public String toString() {
        return "Квартира номер = " + numberOfFlat + ", кол-во комнат = " + amountOfRooms +
                ", жильцы = " + Arrays.toString(arrRoomers);
    }

    @Override
    public boolean equals(Object object){
        // проверили ссылки объектов
        if (this == object){
            return true;
        }
        // проверили принадлежность к одному и тому же классу +
        if (!(object instanceof Flat) || object == null ){
            return false;
        }
        Flat obj = (Flat) object;
        // в одинаковых квартирах будут равны: площадь и кол-во комнат, поэтому сравниваем только их
        boolean isSquareSame = this.square == obj.square;
        boolean isAmountOfRoomsSame = this.amountOfRooms == obj.amountOfRooms;

        return isSquareSame && isAmountOfRoomsSame;
    }

    /**
     * INTERFACE
     * @param months Количество месяцев аренды.
     */
    @Override
    public void rentOut(int months) {
        System.out.printf("Квартира %d сдана в аренду на %d месяцев\n",numberOfFlat,months);
    }

    @Override
    public void terminateRental() {
        System.out.printf("Квартира %d снята с аренды\n",numberOfFlat);
    }
}
