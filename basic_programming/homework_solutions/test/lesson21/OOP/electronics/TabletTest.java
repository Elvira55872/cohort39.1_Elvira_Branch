package lesson21.OOP.electronics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TabletTest {
    private Tablet tablet;

    @BeforeEach
    void setUp() {
        tablet = new Tablet("TestBrand", 10.1, 4, 5000);
    }

    @Test
    void testPowerOn() {
        tablet.powerOn();
        // Проверка результатов метода powerOn (например, изменение состояния планшета)
    }

    @Test
    void testPowerOff() {
        tablet.powerOff();
        // Проверка результатов метода powerOff
    }

    @Test
    void testInstallApplication() {
        tablet.installApplication("TestApp");
        // Проверка установки приложения (например, изменение списка установленных приложений)
    }

    @Test
    void testBrowseWeb() {
        tablet.browseWeb("http://example.com");
        // Проверка открытия веб-страницы
    }

    @Test
    void testCharge() {
        tablet.charge();
        // Проверка зарядки планшета (например, изменение уровня заряда батареи)
    }

    @Test
    void testTabletAttributes() {
        assertEquals("TestBrand", tablet.getBrand());
        assertEquals(10.1, tablet.getScreenSize());
        assertEquals(4, tablet.getRam());
        assertEquals(5000, tablet.getBatteryCapacity());
    }
}

