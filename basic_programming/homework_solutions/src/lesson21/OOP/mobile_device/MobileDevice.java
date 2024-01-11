package lesson21.OOP.mobile_device;

import java.util.Arrays;

// Базовый класс для мобильных устройств
public class MobileDevice {
    private String model;
    private String operatingSystem;
    private int batteryCharge;
    private String[] installedApps;

    // Конструктор
    public MobileDevice(String model, String operatingSystem, int batteryCharge, String[] installedApps) {
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.batteryCharge = batteryCharge;
        this.installedApps = installedApps;
    }

    // Геттеры и сеттеры
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

    public String[] getInstalledApps() {
        return installedApps;
    }

    public void setInstalledApps(String[] installedApps) {
        this.installedApps = installedApps;
    }

    // Методы из задания
    public void installApp(String app) {

    }

    public void uninstallApp(String app) {
    }

    public void showBatteryLevel() {
        System.out.println("Текущий заряд батареи: " + batteryCharge + "%");
    }
}


