package teacher_code;

public class TeacherCode2 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        System.out.println("Using of abstract method calculate(10, 20) = " + myClass.calculate(10, 20));
        System.out.println("Using of default method calculate(10, -20, 30) = " + myClass.calculate(10, -20, 30));
        System.out.println("Using of static method MyInterface.calculate(10) = " + MyInterface.calculate(10));

        MyInterface substractor  = (a, b) -> a - b;

        System.out.println("substractor.calculate(10, 15) = " + substractor.calculate(10, 15));


        // данный пример показывает то, что логика может быть более сложной
        MyInterface anotherOne = (a, b) -> {
            if (a < 10) {
                return b * a;
            } else {
                return b - a;
            }
        };

    }
}
