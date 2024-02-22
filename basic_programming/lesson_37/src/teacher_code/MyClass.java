package teacher_code;

public class MyClass implements MyInterface{
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }

    @Override
    public int calculate(int a, int b, int c) {
        return Math.abs(a * b * c);
    }
}
