package lesson21.OOP.mobile_device;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void testUpdateFirmware() {
        Smartphone phone = new Smartphone("Model X", "OS 1.0", 100, new String[]{});
        phone.updateFirmware("OS 2.0");
        assertEquals("OS 2.0", phone.getOperatingSystem());
    }

    @Test
    void testInstallUninstallApp() {
        Smartphone smartphone = new Smartphone("Model X", "OS 1.0", 100, new String[]{});
        smartphone.installApp("App1");
        smartphone.installApp("App2");
        assertArrayEquals(new String[]{"App1", "App2"}, smartphone.getInstalledApps());

        smartphone.uninstallApp("App1");
        assertArrayEquals(new String[]{"App2"}, smartphone.getInstalledApps());
    }


    @Test
    void testShowBatteryLevel() {
        Smartphone phone = new Smartphone("Model X", "OS 1.0", 50, new String[]{});
        assertEquals(50, phone.getBatteryCharge());
        phone.setBatteryCharge(75);
        assertEquals(75, phone.getBatteryCharge());
    }

    @Test
    void testEquals() {
        Smartphone phone1 = new Smartphone("Model X", "OS 1.0", 100, new String[]{});
        Smartphone phone2 = new Smartphone("Model X", "OS 1.0", 100, new String[]{});
        Smartphone phone3 = new Smartphone("Model Y", "OS 1.0", 100, new String[]{});

        assertEquals(phone1, phone2);
        assertNotEquals(phone1, phone3);
    }

    // При необходимости добавьте дополнительные тесты для других аспектов класса Smartphone
}
