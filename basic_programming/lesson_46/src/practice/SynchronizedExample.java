package practice;

public class SynchronizedExample {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public void example() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
            System.out.println("Thread 1 finished.");
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
            System.out.println("Thread 2 finished.");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Counter final value: " + counter);
    }
}

