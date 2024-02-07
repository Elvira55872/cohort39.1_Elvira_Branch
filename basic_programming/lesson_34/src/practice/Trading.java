package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Trading {
    // Данн массив чисел, которые характеризую цену на актив в какой-то определенный день
    // следует посчитать максимально возможную прибыль
    // [1, 2, 3, 5, 3] -> 4
    // [5, 6, 1, 2] -> 1
    // [5, 3, 1] -> 0
    // [100, 200, 200, 3, 90] -> 100
    // [999, 999, 100, 200, 200, 3, 90] -> 100

    public static int calculateMaxProfit(int[] prices) {
        // logic
        return 0;
    }

    @Test
    public void testCalculateMaxProfit() {
        Assertions.assertEquals(1, calculateMaxProfit(new int[]{1, 2}));
        Assertions.assertEquals(10, calculateMaxProfit(new int[]{1, 2, 3, 4, 11}));
        Assertions.assertEquals(0, calculateMaxProfit(new int[]{11}));
        Assertions.assertEquals(0, calculateMaxProfit(new int[]{11, 1}));
        Assertions.assertEquals(100, calculateMaxProfit(new int[]{10, 110, 3, 80}));
    }
}
