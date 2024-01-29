package lesson_28;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

    @Test
    void testFindKthFromEnd() {
        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Тест для k-го элемента, где k находится в пределах размера списка
        assertEquals(4, list.findKthFromEnd(2), "2-й элемент с конца должен быть 4");

        // Тест для k, равного размеру списка
        assertEquals(1, list.findKthFromEnd(5), "5-й элемент с конца должен быть 1");

        // Тест для k, большего чем размер списка
        assertThrows(IllegalArgumentException.class, () -> list.findKthFromEnd(6), "Должно быть исключение, если k больше размера списка");

        // Тест для k, равного 1 (последний элемент)
        assertEquals(5, list.findKthFromEnd(1), "1-й элемент с конца должен быть 5");
    }

    @Test
    void testFindKthFromEndWithEmptyList() {
        CustomLinkedList list = new CustomLinkedList();

        // Тест для пустого списка
        assertThrows(IllegalArgumentException.class, () -> list.findKthFromEnd(1), "Должно быть исключение, если список пуст");
    }
}

