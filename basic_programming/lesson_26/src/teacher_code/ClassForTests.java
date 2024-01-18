package teacher_code;

public class ClassForTests {

    public static void switchElements(int[] nums) throws CustomException {
        if (nums == null) {
            throw new CustomException("array cant be null");
        } else if (nums.length < 2) {
            throw new CustomException("array should have more than 1 element");
        }

        int temp = nums[0];
        nums[0] = nums[nums.length - 1];
        nums[nums.length - 1] = temp;
    }
}
