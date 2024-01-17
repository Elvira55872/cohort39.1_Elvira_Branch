package lesson21.OOP.pet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void testCatCreation() {
        Cat cat = new Cat("Whiskers", 5, "Siamese", "White");
        assertEquals("Whiskers", cat.getName());
        assertEquals(5, cat.getAge());
        assertEquals("Siamese", cat.getBreed());
        assertEquals("White", cat.getFurColor());
    }

    @Test
    void testMakeSound() {
        Cat cat = new Cat("Whiskers", 5, "Siamese", "White");
        cat.makeSound();
        // Тест проверяет вызов метода, но не его вывод, так как он выводит в консоль
    }

    @Test
    void testPlay() {
        Cat cat = new Cat("Whiskers", 5, "Siamese", "White");
        cat.play("ball");
        // Аналогично, проверяем вызов метода
    }

    @Test
    void testEat() {
        Cat cat = new Cat("Whiskers", 5, "Siamese", "White");
        cat.eat("fish");
        // Проверяем вызов метода
    }

    @Test
    void testSleep() {
        Cat cat = new Cat("Whiskers", 5, "Siamese", "White");
        cat.sleep();
        // Проверяем вызов метода
    }

    @Test
    void testGroom() {
        Cat cat = new Cat("Whiskers", 5, "Siamese", "White");
        cat.groom();
        // Проверяем вызов метода
    }

    @Test
    void testEquals() {
        Cat cat1 = new Cat("Whiskers", 5, "Siamese", "White");
        Cat cat2 = new Cat("Whiskers", 5, "Siamese", "White");
        Cat cat3 = new Cat("Fluffy", 3, "Maine Coon", "Black");

        assertEquals(cat1, cat2);
        assertNotEquals(cat1, cat3);
    }
}
