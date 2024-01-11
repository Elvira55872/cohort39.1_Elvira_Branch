package lesson21.OOP.mobile_device;


// Класс смартфона, расширяющий MobileDevice и реализующий Updatable
public class Smartphone extends MobileDevice implements Updatable {
    public Smartphone(String model, String operatingSystem, int batteryCharge, String[] installedApps) {
        super(model, operatingSystem, batteryCharge, installedApps);
    }

    @Override
    public void updateFirmware(String version) {
        setOperatingSystem(version);
        System.out.println("Операционная система обновлена до версии " + version);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Smartphone that = (Smartphone) obj;
        return getBatteryCharge() == that.getBatteryCharge() &&
                getModel().equals(that.getModel()) &&
                getOperatingSystem().equals(that.getOperatingSystem());
    }
}


