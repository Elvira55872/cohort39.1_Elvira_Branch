package students_code;

public class L23_Homework_Elvira_Cohort391 {

    public static void main(String[] args) {
        int[] sortedNumbers = new int[]{-5, -5, -5, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(binarySearchFirstIndex(sortedNumbers, 0));
        System.out.println(binarySearchLastIndex(sortedNumbers, 0));
    }

    static int binarySearchFirstIndex(int[] sortedArray, int targetNumber) {
        int left = 0;
        int right = sortedArray.length - 1;
        int result = -1;

        while (left <= right) {
            int middle = (right + left) / 2;
            if (sortedArray[middle] == targetNumber) {
                result = middle;
                right = middle - 1;
            }
            else if (sortedArray[middle] < targetNumber) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }

    static int binarySearchLastIndex(int[] sortedArray, int targetNumber) {
        int left = 0;
        int right = sortedArray.length - 1;
        int result = -1;

        while (left <= right) {
            int middle = (right + left) / 2;
            if (sortedArray[middle] == targetNumber) {
                result = middle;
                left = middle + 1;
            } else if (sortedArray[middle] < targetNumber) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }
}
