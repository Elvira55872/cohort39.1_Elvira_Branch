import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import teacher_code.ClassForTests;
import teacher_code.CustomException;

public class ClassForTestsTest {
    @Test
    public void testSomeMethodeCorrect() {
        int[] nums = {1, 2, 3};
        int[] expected = {3, 2 , 1};

        try {
            ClassForTests.switchElements(nums);
        } catch (CustomException e) {}

        Assertions.assertArrayEquals(expected, nums);
        Assertions.assertEquals(3, nums[0]);
        Assertions.assertEquals(1, nums[2]);
    }

    @Test
    public void testSomeMethodeIncorrectArraySize() {
        int[] nums = {1};
        String errorMessage = null;

        try {
            ClassForTests.switchElements(nums);
        } catch (CustomException e) {
            errorMessage = e.getMessage();
        }

        Assertions.assertNotNull(errorMessage);
        Assertions.assertEquals("array should have more than 1 element", errorMessage);
    }

    @Test
    public void testSomeMethodeNullValue() {
        int[] nums = null;
        String errorMessage = null;

        try {
            ClassForTests.switchElements(nums);
        } catch (CustomException e) {
            errorMessage = e.getMessage();
        }

        Assertions.assertNotNull(errorMessage);
        Assertions.assertEquals("array cant be null", errorMessage);
    }
}
