package lesson_27;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NumberListProcessorTest {

    @Test
    void testFindMax() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        assertEquals(9, NumberListProcessor.findMax(numbers), "Максимальное значение должно быть 9");
    }

    @Test
    void testFindMin() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        assertEquals(2, NumberListProcessor.findMin(numbers), "Минимальное значение должно быть 2");
    }

    @Test
    void testFindAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(3.0, NumberListProcessor.findAverage(numbers), "Среднее значение должно быть 3.0");
    }

    @Test
    void testFindPrimes() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(Arrays.asList(2, 3, 5, 7), NumberListProcessor.findPrimes(numbers), "Простые числа в списке: 2, 3, 5, 7");
    }
}
