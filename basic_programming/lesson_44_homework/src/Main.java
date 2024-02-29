/**
 * Имена потоков и приоритеты
 * Описание:
 * Создайте несколько потоков (не менее трех),
 * присвойте им осмысленные имена и различные приоритеты.
 * Реализуйте в этих потоках бесконечные циклы, в которых потоки выводят свое имя и приоритет.
 * <p>
 * Пример вывода
 * Thread-1, Priority: 5 Thread-2, Priority: 3 Thread-3, Priority: 8
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = createThreadWithPriority("Do Homework", 6);
        Thread t2 = createThreadWithPriority("Eat", 10);
        Thread t3 = createThreadWithPriority("Go to school", 8);
        Thread t4 = createThreadWithPriority("Sleep", 10);
        Thread t5 = createThreadWithPriority("Play computer games", 1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static Thread createThreadWithPriority(String name, int priority) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName(name);
                Thread.currentThread().setPriority(priority);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
                }
            }
        });
    }
}
