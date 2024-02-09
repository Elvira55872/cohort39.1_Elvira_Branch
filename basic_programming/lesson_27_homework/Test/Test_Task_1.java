import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Test_Task_1 {
    @Test
    public void testCorrectRemoveShortString() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Assertions.assertEquals("[three, four]", Homework_L27_task1.removeShortString(list, 3).toString());
    }

    @Test
    public void testIncorrectRemoveShortString() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Assertions.assertEquals("[]", Homework_L27_task1.removeShortString(list, 5).toString());
    }
}
