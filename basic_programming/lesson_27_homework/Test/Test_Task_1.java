import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Test_Task_1 {
    @Test
    public void testCorrectRemoveShortStringAnsUpperCase() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Assertions.assertEquals("[THREE, FOUR]", Homework_L27_task1.removeShortString(list, 4).toString());
    }

    @Test
    public void testIncorrectSizeRemoveShortString() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Assertions.assertEquals("[]", Homework_L27_task1.removeShortString(list, 60).toString());
    }

    @Test
    public void testToUpperCaseChanging() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        String result = Homework_L27_task1.removeShortString(list, 3).toString();
        String regex = "[A-Z\\[\\],\\s]+";
        boolean matches = result.matches(regex);

        Assertions.assertEquals(true, matches);
    }

    @Test
    public void testEmptyArrayList() {
        ArrayList<String> list = new ArrayList<>();

        Assertions.assertEquals("[]", Homework_L27_task1.removeShortString(list, 5).toString());
    }

}
