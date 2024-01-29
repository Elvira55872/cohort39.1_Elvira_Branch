package lesson_26;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SwapElementTest {

    @Test
    void testSwap() {
        SwapElement<Integer> swapElement = new SwapElement<>();
        Integer[] array = {1, 2, 3, 4};
        swapElement.swap(array);
        assertArrayEquals(new Integer[]{4, 2, 3, 1}, array, "Первый и последний элементы должны поменяться местами");
    }

    @Test
    void testSwapSingleElement() {
        SwapElement<Integer> swapElement = new SwapElement<>();
        Integer[] array = {1};
        assertThrows(IllegalArgumentException.class, () -> swapElement.swap(array), "Должно возникнуть исключение, если в массиве менее двух элементов");
    }

    @Test
    void testSwapEmptyArray() {
        SwapElement<Integer> swapElement = new SwapElement<>();
        Integer[] array = {};
        assertThrows(IllegalArgumentException.class, () -> swapElement.swap(array), "Должно возникнуть исключение, если массив пустой");
    }

    @Test
    void testSwapNullArray() {
        SwapElement<Integer> swapElement = new SwapElement<>();
        assertThrows(IllegalArgumentException.class, () -> swapElement.swap(null), "Должно возникнуть исключение, если массив является null");
    }
}

