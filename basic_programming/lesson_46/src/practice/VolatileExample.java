package practice;

public class VolatileExample {
    private volatile boolean running = true;

    public void example() {
        Thread thread1 = new Thread(() -> {
            int counter = 0;
            while (running) {
                counter++;
            }
            System.out.println("Thread 1 finished. Counted up to " + counter);
        });

        Thread thread2 = new Thread(() -> {
            // Ожидание, чтобы гарантировать, что thread1 начал исполнение
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 2 finishing and setting running to false.");
            running = false;
        });

        thread1.start();
        thread2.start();
    }
}

