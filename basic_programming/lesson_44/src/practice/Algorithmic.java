package practice;

public class Algorithmic {

    // 123 -> 321
    // 1 -> 1
    // 120 -> 21
    public static int reverse(int num) {
        StringBuilder builder = new StringBuilder();
        boolean isNegative = num < 0;
        builder.append(Math.abs(num));
        builder.reverse();


        ///
        return 0;
    }
}
