package consultation2024_01_11.teachers_sandbox;

import java.util.Arrays;

public class TeacherSandbox {
    public static void main(String[] args) {

    }

    //O(1) - операции всегда выполняются за константное время
    public static void constant() {
        int[] nums = {1, 2, 3, 4};
        String str1 = "hello";
        String str2 = "fsgwhejuhgtrfrghjgtdhtrtedg";

        // получение количеста элементов в строке или массиве
        str1.length();
        str2.length();
        int x = nums.length;

        //  получение элемента по индексу также является
        //  константной операцие, выполянемой за одно и
        //  тоже время вне зависиости от того, с какой
        //  позиции мы берем элемент (перва или последняя),
        //  а также, сколько элементов содержится в массиве

        int first = nums[0];
        int last = nums[nums.length - 1];

        char firstCharStr1 = str1.charAt(0);
        char firstCharStr2 = str2.charAt(0);

        char lastCharStr1 = str1.charAt(str1.length() - 1);
        char lastCharStr2 = str2.charAt(str2.length() - 1);

        // не константная сложность, а линейная,
        // так как для проверки используется цикл, который
        // перебирает все символы в строке, следовательно,
        // чем длинее строка, тем дольше выполняется проверка

        int indexOf = str2.indexOf("!");
    }


    static void log (int[] nums) {
        // бинарный поиск в отсортированном массиве

        System.out.println("Hello");

        // O(log N + 1) -> O(log N)

        Arrays.binarySearch(nums, 5);
        //  N - Operations
        //  4 - 2
        //  5 - 3
        // .. - 3
        //  8 - 3
        //  9 - 4


    }
}
