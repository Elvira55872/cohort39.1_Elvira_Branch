package lesson21.OOP.residential;

import java.util.Arrays;
import java.util.Objects;

public class Apartment extends ResidentialUnit implements Rentable {
    private double area;
    private int numberOfRooms;
    private int floor;
    private String[] residents;
    private int residentCount;

    public Apartment(double area, int numberOfRooms, int floor) {
        setArea(area);
        setNumberOfRooms(numberOfRooms);
        setFloor(floor);
        this.residents = new String[10]; // Начальный размер массива жильцов
        this.residentCount = 0;
    }

    // Геттеры и сеттеры
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area >= 0) {
            this.area = area;
        }
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms >= 0) {
            this.numberOfRooms = numberOfRooms;
        }
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        if (floor >= 0) {
            this.floor = floor;
        }
    }

    // Метод для получения текущего количества жильцов
    public int getResidentCount() {
        return residentCount;
    }

    // Методы из ResidentialUnit
    // Метод для добавления жильца
    @Override
    public void addResident(String resident) {
        // Создаем новый массив на один элемент больше
        String[] newResidents = new String[residentCount + 1];
        System.arraycopy(residents, 0, newResidents, 0, residentCount);
        newResidents[residentCount] = resident;
        residents = newResidents;
        residentCount++;
    }

    // Метод для удаления жильца
    @Override
    public void removeResident(String resident) {
        for (int i = 0; i < residentCount; i++) {
            if (residents[i].equals(resident)) {
                // Создаем новый массив на один элемент меньше
                String[] newResidents = new String[residentCount - 1];
                System.arraycopy(residents, 0, newResidents, 0, i);
                System.arraycopy(residents, i + 1, newResidents, i, residentCount - i - 1);
                residents = newResidents;
                residentCount--;
                return;
            }
        }
        System.out.println("Жилец не найден: нелегальная операция.");
    }

    @Override
    public void showInfo() {
        System.out.println("Квартира на этаже " + floor + " с площадью " + area + " кв.м. и " + numberOfRooms + " комнатами.");
        System.out.println("Жильцы: " + Arrays.toString(Arrays.copyOf(residents, residentCount)));
    }

    // Методы из Rentable
    @Override
    public void rentOut(int months) {
        System.out.println("Квартира сдается в аренду на " + months + " месяцев.");
    }

    @Override
    public void terminateRental() {
        System.out.println("Договор аренды прекращен.");
        // Освобождаем апартаменты, устанавливая размер массива жильцов в ноль
        residents = new String[0];
        residentCount = 0;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        Apartment that = (Apartment) o;
        return Double.compare(that.area, area) == 0 &&
                numberOfRooms == that.numberOfRooms &&
                floor == that.floor &&
                Arrays.equals(Arrays.copyOf(residents, residentCount), Arrays.copyOf(that.residents, that.residentCount));
    }
}
