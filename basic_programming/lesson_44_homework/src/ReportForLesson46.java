public class ReportForLesson46 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + i);

                }
            }
        });

        // Мы научились:




        // ДАВАТЬ ИМЯ ПОТОКУ
        t1.setName("Поток 1");
        /*
        Рекомендуется давать потокам осмысленные имена, это пригодится при отладке.
        Не рекомендуется давать потокам одинаковые имена, хотя это допустимо
         */






        // ДАВАТЬ ПОТОКУ ПРИОРИТЕТ
        t1.setPriority(10);
        /*
        максимальный = 10
        минимальный = 1

        если мы не устанавливаем вручную приоритет потоку, то он будет выставлен по умолчанию и будет равен 5
        т.к. у потока Main приоритет 5

        Необязательно будет быстрее всего выполнен поток с бОльшим приоритетом,
        тк потоки уходят выполняться на разные ядра и поток с меньшим приоритетом может быть выполнен быстрее
        Мы не можем на это повлиять

        Поток с большим приоритетом будет иметь больше процессорного времени на выполнение.
        Если два потока имеют одинаковый приоритет, то решение о том, какой из них будет выполняться первым,
        зависит от алгоритма планировщика

        Переменные класса:
        Thread.MIN_PRIORITY — минимальный приоритет, значение 1;
        Thread.NORM_PRIORITY — приоритет по умолчанию, значение 5;
        Thread.MAX_PRIORITY — максимальный приоритет потока, значение 10
         */





        // ОБРАЩАТЬСЯ К ПОТОКУ
        Thread.currentThread().setPriority(5);
        /*
        так можно обратиться к потоку
        в этом примере мы обратимся к потоку Main, тк находимся сейчас в нем

        Чтобы обратиться к другому потоку, нужно обращение писать в его теле
         */






        /*
        ПОТОКИ - ДЕМОНЫ
        Работа JVM заканчивается, когда закончил выполняться последний поток не-демон,
        несмотря на работающие потоки-демоны.
         */

        t1.setDaemon(true);
        t1.isDaemon();






        /*
         ОСТАНОВКА ПОТОКА

         Остановка через stop() уже устарела и работает некорректно
         Сейчас используют остановку через interrupt() (в Java 1.1 и выше)
         */

        t1.interrupt(); // останавливает поток

        /*
        изначально у всех потоков флаг interrupt() стоит в позиции FALSE
        t1.interrupt(); после этой команды флаг станет TRUE

        Когда поток прерывается другим потоком, происходит одно из двух:

            1. Если поток уже выполняет один из методов ожидания (Thread.sleep(), Thread.join() или Object.wait() ),
        то ожидание прерывается и метод генерирует InterruptedException. Флаг interrupted устанавливается в false.
            2. Флаг interrupted устанавливается в true.
         */

        t1.isInterrupted(); // не меняет флаг, просто возвращает его значение
        t1.interrupted(); // возвращает значение флага и устанавливает его значение в false.
        // Если флаг interrupted установлен в true и вызывается этот метод, то первый раз метод вернет true,
        // а последующие вызовы вернут false.
        // Работа метода: return currentThread().getAndClearInterrupt();

        // interrupted может быть полезным, когда первый поток имеет ссылку на второй поток,
        // и первый хочет узнать состояние флага второго.








        /* ОБРАБОТКА ОШИБКИ ПРИ ПОПЫТКЕ ПРЕРЫВАНИЯ ПОТОКА: 2 ВАРИАНТА
        1) Первый способ обработки InterruptedException — объявление этого исключения в вышестоящем методе.
            Также при перехвате метода InterruptedException можно произвести какие-то действия
            (например, очистку ресурсов или переменных) и повторно пробросить InterruptedException.

        2) Во втором случае, когда InterruptedException объявить невозможно,
            при генерации и перехвате InterruptedException флаг interrupted устанавливается в false,
            и вызывающие методы не увидят, что было совершено прерывание потока.
            Однако можно восстановить флаг прерывания, вызвав Thread.currentThread().interrupt() при обработке прерывания.
        */

        Thread exampleThread = new Thread(() -> {
            try {
                System.out.println("Thread is going to sleep for 5 seconds");
                // Поток спит 5 секунд, это блокирующая операция и может вызвать InterruptedException
                Thread.sleep(5000);
                System.out.println("Thread woke up");
            } catch (InterruptedException e) {
                // Логика обработки исключения
                System.out.println("Thread was interrupted during sleep");

                // Первый способ обработки: очистка и повторное пробрасывание исключения (если это допустимо)
                // Выполняем какую-то очистку
                // cleanUpResources();
                // throw new RuntimeException(e);

                // Второй способ обработки: восстановление флага прерывания
                // Код может продолжать свое выполнение, но флаг прерывания восстанавливается для дальнейших проверок
                Thread.currentThread().interrupt();
            }
        });
        exampleThread.start();

        // Основной поток спит 2 секунды, чтобы быть уверенным, что exampleThread начал свое выполнение и "спит"
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Прерываем поток exampleThread, пока он "спит"
        exampleThread.interrupt();

    }
}
