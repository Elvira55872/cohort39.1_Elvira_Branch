package lesson21.OOP.transport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BicycleTest {

    @Test
    void testChangeSpeed() {
        Bicycle bicycle = new Bicycle("Mountain", 26, "Red", false);
        bicycle.changeSpeed(10);
        assertEquals(10, bicycle.getSpeed(), "Проверка изменения скорости велосипеда");
    }

    @Test
    void testTurnOnOffLight() {
        Bicycle bicycle = new Bicycle("Road", 28, "Blue", false);
        bicycle.turnOnLight();
        assertTrue(bicycle.hasFrontLight(), "Проверка включения фары");
        bicycle.turnOffLight();
        assertFalse(bicycle.hasFrontLight(), "Проверка выключения фары");
    }

    @Test
    void testShowCharacteristics() {
        Bicycle bicycle = new Bicycle("Hybrid", 27, "Green", true);
        bicycle.changeSpeed(15);

        String expectedOutput = "Тип: Hybrid, размер колес: 27, цвет: Green, наличие фары: да, текущая передача: 15";
        assertEquals(expectedOutput, bicycle.getCharacteristics(), "Проверка отображения характеристик велосипеда");
    }


    @Test
    void testPerformMaintenance() {
        Bicycle bicycle = new Bicycle("BMX", 20, "Black", true);
        bicycle.performMaintenance();
        // Здесь мы ожидаем, что метод performMaintenance не изменит состояние объекта, но может выводить информацию в консоль
    }

    @Test
    void testPolymorphism() {
        Vehicle vehicle = new Bicycle("Mountain", 26, "Red", false);
        vehicle.changeSpeed(20); // Полиморфизм: использование метода производного класса через ссылку базового класса
        assertTrue(vehicle instanceof Bicycle, "Проверка полиморфизма: vehicle является экземпляром класса Bicycle");
    }
}

