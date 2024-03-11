package teacher_code;


public class TeacherCode {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setPriority(3);

        Thread t1 = createThread("t1", 500);
        Thread t2 = createThread("t2", 700);

//        Thread t1 = createThreadWithPriority("t1", 10);
//        Thread t2 = createThreadWithPriority("t2", 1);
//        t1.setDaemon(true);
//        t2.setDaemon(true);

        t1.start();
        t2.start();

        System.out.println("t1 name: " + t1.getName() + "; t1 priority = " + t1.getPriority() +
                "; isDaemon " + t1.isDaemon() + "; group name = " + t1.getThreadGroup().getName() +
                "; isInterrupted " + t1.isInterrupted());

        System.out.println("t2 name: " + t2.getName() + "; t2 priority = " + t2.getPriority() +
                "; isDaemon " + t2.isDaemon()  + "; group name = " + t1.getThreadGroup().getName() +
                "; isInterrupted " + t2.isInterrupted());


        System.out.println("Main thread = " +
                Thread.currentThread().getThreadGroup().getName());

        Thread.sleep(1000);

        t1.stop();
        t2.interrupt();

        System.out.println("t1.isInterrupted() = " + t1.isInterrupted());
        System.out.println("t2.isInterrupted() = " + t2.isInterrupted());

//
//        Thread.currentThread().setName("MAIN THREAD!!!");
//
//        System.out.println("Main thread name " + Thread.currentThread().getName());

        System.out.println("======= MAIN =========");
    }

    private static Thread createThread(String name, long time) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread.currentThread().setName(name);

                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }, name);
    }

    private static Thread createThreadWithPriority(String name, int  priority) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread.currentThread().setName(name);
                Thread.currentThread().setPriority(priority);

                for (int i = 0; i < 10_000_000; i++) {

                }

                System.out.printf("============ %s FINISHED ===============\n", Thread.currentThread().getName());
            }
        }, name);
    }

}




