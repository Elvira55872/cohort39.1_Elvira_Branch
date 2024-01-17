package lesson21.OOP.transport;

import java.util.Objects;

// Класс Велосипед, расширяющий Vehicle и реализующий Repairable
public class Bicycle extends Vehicle implements Repairable {
    private String type;
    private int wheelSize;
    private String color;
    private boolean hasFrontLight;

    private int speed;

    public Bicycle(String type, int wheelSize, String color, boolean hasFrontLight) {
        this.type = type;
        this.wheelSize = wheelSize;
        this.color = color;
        this.hasFrontLight = hasFrontLight;
        this.speed = 0;
    }

    // Геттеры и сеттеры
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean hasFrontLight() {
        return hasFrontLight;
    }

    public int getSpeed() {
        return speed;
    }

    // Методы из Vehicle
    @Override
    public void changeSpeed(int speed) {
        this.speed = speed;
        System.out.println("Передача изменена на " + this.speed);
    }

    @Override
    public void turnOnLight() {
        if (hasFrontLight) {
            System.out.println("Фара уже включена");
        } else {
            hasFrontLight = true;
            System.out.println("Фара выключена");
        }
    }

    @Override
    public void turnOffLight() {
        if (!hasFrontLight) {
            System.out.println("Фара уже выключена");
        } else {
            hasFrontLight = false;
            System.out.println("Фара выключена");
        }
    }

    @Override
    public void showCharacteristics() {
        System.out.println("Тип: " + type + ", размер колес: " + wheelSize + ", цвет: " + color +
                ", наличие фары: " + (hasFrontLight ? "да" : "нет") + ", текущая передача: " + speed);
    }

    public String getCharacteristics() {
        return "Тип: " + type + ", размер колес: " + wheelSize + ", цвет: " + color +
                ", наличие фары: " + (hasFrontLight ? "да" : "нет") + ", текущая передача: " + speed;
    }

    // Метод из Repairable
    @Override
    public void performMaintenance() {
        System.out.println("Велосипед обслужен");
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicycle)) return false;
        Bicycle bicycle = (Bicycle) o;
        return wheelSize == bicycle.wheelSize &&
                hasFrontLight == bicycle.hasFrontLight &&
                Objects.equals(type, bicycle.type) &&
                Objects.equals(color, bicycle.color);
    }
}

