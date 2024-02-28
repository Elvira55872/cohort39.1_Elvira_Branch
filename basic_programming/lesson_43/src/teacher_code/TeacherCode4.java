package teacher_code;

public class TeacherCode4 {
    public static void main(String[] args) throws InterruptedException {
        joinExample();
    }

    public static void joinExample() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Тимофей вышел гулять");
            }
        };

        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Роман вышел гулять");
            }
        });

        System.out.println("Максим зовет гулять Тимофея и Романа");
        t.start();
        r.start();

        // ждем, когда соберуться и выйдут во двор Тимофей и Роман:
        t.join(3000);
        r.join(3000);


        System.out.println("Максим тоже вышел гулять");
    }






    public static void exampleOfJoin() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("========= Thread ============");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("========= Runnable ============");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        r.start();

        // метод t1.join() - заставляет поток, в котором он вызван (поток мейн) дождаться,
        // когда завершиться работа потока t1 и только потом продолжить свою работу
        r.join();
        t1.join();



        System.out.println("======= MAIN =======");
    }



    public static void threadExample() {
        Thread t1 = new ThreadExample1();
        Runnable t2 = new ThreadExample2();

        // метод run() - всего лишь запустит код из этого метода, но без создания новго потока
//        t1.run();
//        t2.run();

        // для создания нового потока, надо воспользоваться методом start()
        t1.start();
        new Thread(t2).start();


        System.out.println("======= MAIN =======");
    }


}
