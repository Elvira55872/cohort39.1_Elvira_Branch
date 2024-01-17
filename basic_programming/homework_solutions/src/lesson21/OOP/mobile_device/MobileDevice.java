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
        // Проверка, установлено ли уже приложение
        for (String installedApp : installedApps) {
            if (installedApp != null && installedApp.equals(app)) {
                System.out.println("Приложение уже установлено.");
                return;
            }
        }

        installedApps = Arrays.copyOf(installedApps, installedApps.length + 1);
        // Добавление приложения
        installedApps[installedApps.length - 1] = app;
        System.out.println("Приложение успешно установлено.");
    }

    public void uninstallApp(String app) {
        // Подсчет количества приложений, исключая удаляемое
        int appCount = 0;
        for (String installedApp : installedApps) {
            if (installedApp != null && !installedApp.equals(app)) {
                appCount++;
            }
        }

        // Если приложение не найдено, выводим сообщение и выходим из метода
        if (appCount == installedApps.length) {
            System.out.println("Приложение не найдено.");
            return;
        }

        // Создаем новый массив для хранения приложений
        String[] newInstalledApps = new String[appCount];
        int index = 0;

        // Копируем все приложения, кроме удаляемого, в новый массив
        for (String installedApp : installedApps) {
            if (installedApp != null && !installedApp.equals(app)) {
                newInstalledApps[index++] = installedApp;
            }
        }

        // Обновляем список установленных приложений
        installedApps = newInstalledApps;
    }

    public void showBatteryLevel() {
        System.out.println("Текущий заряд батареи: " + batteryCharge + "%");
    }
}


