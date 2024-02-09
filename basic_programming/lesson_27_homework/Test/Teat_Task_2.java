import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Teat_Task_2 {

    @Test
    public void TestFillUpRandom() {
        ArrayList<Integer> arrList = new ArrayList<>();
        Homework_L27_task2.fillUpRandom(arrList, 10, 0, 30);

        Assertions.assertEquals(10, arrList.size());
        Assertions.assertNotEquals(true, arrList.isEmpty());
    }

    @Test
    public void TestMaxNumber() {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(4);
        arrList.add(90);
        arrList.add(0);
        arrList.add(45);
        arrList.add(2);
        arrList.add(120);
        arrList.add(1);

        Assertions.assertEquals(120, Homework_L27_task2.maxNumber(arrList));
    }

    @Test
    public void TestMinNumber() {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(4);
        arrList.add(90);
        arrList.add(0);
        arrList.add(45);
        arrList.add(2);
        arrList.add(120);
        arrList.add(1);

        Assertions.assertEquals(0, Homework_L27_task2.minNumber(arrList));
    }

    @Test
    public void TestMiddleNumber() {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(4);
        arrList.add(90);
        arrList.add(0);
        arrList.add(45);
        arrList.add(2);
        arrList.add(120);
        arrList.add(1);

        Assertions.assertEquals(33.375, Homework_L27_task2.middleNumber(arrList));
    }

    @Test
    public void TestSimpleNumbers() {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(4);
        arrList.add(90);
        arrList.add(0);
        arrList.add(45);
        arrList.add(2);
        arrList.add(120);
        arrList.add(1);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(2);

        ArrayList<Integer> result = Homework_L27_task2.simpleNumbers(arrList);

        Assertions.assertEquals(expected, result);
    }
}
