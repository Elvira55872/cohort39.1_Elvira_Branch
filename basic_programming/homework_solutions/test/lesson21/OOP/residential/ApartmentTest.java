package lesson21.OOP.residential;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    // Тестирование добавления и удаления жильца
    @Test
    void testAddRemoveResident() {
        // Создаем экземпляр класса Apartment
        Apartment apartment = new Apartment(100.0, 3, 5);

        // Добавляем жильца
        apartment.addResident("John Doe");

        // Проверяем, что количество жильцов стало равным 1
        assertEquals(1, apartment.getResidentCount());

        // Удаляем жильца
        apartment.removeResident("John Doe");

        // Проверяем, что жильцов стало 0
        assertEquals(0, apartment.getResidentCount());
    }

    // Тестирование метода terminateRental (прекращение аренды)
    @Test
    void testTerminateRental() {
        // Создаем экземпляр класса Apartment
        Apartment apartment = new Apartment(100.0, 3, 5);

        // Добавляем жильца
        apartment.addResident("John Doe");

        // Прекращаем аренду
        apartment.terminateRental();

        // Проверяем, что жильцов стало 0
        assertEquals(0, apartment.getResidentCount());
    }

    // Тестирование геттеров и сеттеров
    @Test
    void testSettersAndGetters() {
        // Создаем экземпляр класса Apartment с некорректными значениями
        Apartment apartment = new Apartment(-100.0, -3, -5);

        // Устанавливаем корректные значения
        apartment.setArea(100.0);
        apartment.setNumberOfRooms(3);
        apartment.setFloor(5);

        // Проверяем, что установленные значения соответствуют ожидаемым
        assertEquals(100.0, apartment.getArea());
        assertEquals(3, apartment.getNumberOfRooms());
        assertEquals(5, apartment.getFloor());
    }

    // Тестирование метода equals
    @Test
    void testEquals() {
        // Создаем три экземпляра класса Apartment
        Apartment apartment1 = new Apartment(100.0, 3, 5);
        Apartment apartment2 = new Apartment(100.0, 3, 5);
        Apartment apartment3 = new Apartment(90.0, 2, 4);

        // Проверяем, что первые два экземпляра эквивалентны (равны)
        assertEquals(apartment1, apartment2);

        // Проверяем, что первый и третий экземпляры не эквивалентны
        assertNotEquals(apartment1, apartment3);
    }
}
