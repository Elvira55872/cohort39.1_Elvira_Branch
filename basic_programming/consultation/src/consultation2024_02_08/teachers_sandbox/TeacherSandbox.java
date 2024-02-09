package consultation2024_02_08.teachers_sandbox;

public class TeacherSandbox {
    public static void main(String[] args) {

        someMethod("one");
        someMethod("two");
        someMethod("hello world");
        someMethod("three");

    }

    public static String rgb(int[] ar) {
        StringBuilder hexString = new StringBuilder();
        for (int value : ar) {
            int clampedValue = Math.min(Math.max(value, 0), 255); // Ограничение значений от 0 до 255
            hexString.append(String.format("%02X", clampedValue)); // Преобразование в шестнадцатеричное с ведущими нулями
        }

        return hexString.toString();
    }

    public static void someMethod(String str) {
        // some logic
        System.out.println(str.toUpperCase());
    }
}
