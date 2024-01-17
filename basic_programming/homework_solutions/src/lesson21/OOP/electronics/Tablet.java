package lesson21.OOP.electronics;

import java.util.Objects;

public class Tablet extends ElectronicDevice implements Portable {
    private String brand;
    private double screenSize;
    private int ram;
    private int batteryCapacity;

    public Tablet(String brand, double screenSize, int ram, int batteryCapacity) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;
        this.batteryCapacity = batteryCapacity;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getRam() {
        return ram;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    // Методы из ElectronicDevice
    @Override
    public void powerOn() {
        System.out.println(brand + " планшет включен");
    }

    @Override
    public void powerOff() {
        System.out.println(brand + " планшет выключен");
    }

    @Override
    public void installApplication(String application) {
        System.out.println("Приложение " + application + " установлено на " + brand + " планшет");
    }

    @Override
    public void browseWeb(String url) {
        System.out.println("Открыта веб-страница: " + url);
    }

    // Метод из Portable
    @Override
    public void charge() {
        System.out.println(brand + " планшет заряжается");
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tablet)) return false;
        Tablet tablet = (Tablet) o;
        return Double.compare(tablet.screenSize, screenSize) == 0 &&
                ram == tablet.ram &&
                batteryCapacity == tablet.batteryCapacity &&
                Objects.equals(brand, tablet.brand);
    }
}
