import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElviraHomeworkL26Test {
    @Test
    public void swapIntegerTest() {
        Integer[] intArray = {0, 1, 2, 3, 4, 5};
        ElviraHomeworkL26<Integer> intArr = new ElviraHomeworkL26<>(intArray);

        Integer[] result = intArr.swap(intArray, 0, 5);
        Integer[] expexted = {5, 1, 2, 3, 4, 0};

        Assertions.assertArrayEquals(expexted, result);
    }

    @Test
    public void swapDoubleTest() {
        Double[] doubleArray = {0.1, 1.9, 2.444, 3.231, 4.0, 5.453};
        ElviraHomeworkL26<Double> intArr = new ElviraHomeworkL26<>(doubleArray);

        Double[] result = intArr.swap(doubleArray, 0, 5);
        Double[] expexted = {5.453, 1.9, 2.444, 3.231, 4.0, 0.1};

        Assertions.assertArrayEquals(expexted, result);
    }

    @Test
    public void swapStringTest() {
        String[] strArray = {"zero", "one", "two", "three"};
        ElviraHomeworkL26<String> strArr = new ElviraHomeworkL26<>(strArray);

        String[] result = strArr.swap(strArray, 0, 3);
        String[] expexted = {"three", "one", "two", "zero"};

        Assertions.assertArrayEquals(expexted, result);
    }
}