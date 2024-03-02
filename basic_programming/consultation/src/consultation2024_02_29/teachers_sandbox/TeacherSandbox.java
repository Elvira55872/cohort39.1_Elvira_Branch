package consultation2024_02_29.teachers_sandbox;

public class TeacherSandbox {
    public static void main(String[] args) throws InterruptedException {
        method();

        try {
            setAge(100);
        } catch (CustomException e) {
            // log e.message
        }

        System.out.println("main finish");
    }

    public static void method() throws InterruptedException {
        Thread.sleep(1000);

        System.out.println("finish");
    }

    public static void setAge(int age) throws CustomException {
        if (age < 0) {
            throw new CustomException("возраст не может быть отрицательным");
        }

        System.out.println("ваш возраст " + age + " лет");
    }
}
