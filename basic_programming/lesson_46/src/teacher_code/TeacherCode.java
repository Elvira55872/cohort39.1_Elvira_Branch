package teacher_code;


public class TeacherCode {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        increase();
        increase();

        Thread.sleep(2000);

        System.out.println("counter = " + counter);
    }

    private static void increase() {
        Thread thread = new Thread(() ->
        {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
        });
        thread.start();
    }
}




