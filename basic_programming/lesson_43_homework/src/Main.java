import java.io.FileInputStream;
import java.io.IOException;

/**
 * Теория по чтению из файла в уроке 33
 * <p>
 * ДЗ
 * Задача 1: Параллельное считывание из двух файлов.
 * Напишите программу, которая параллельно считывает данные из двух файлов и выводит их на экран.
 * <p>
 * Пример
 * Входные данные (в файле 1): Hello, World!
 * <p>
 * Входные данные (в файле 2): How are you?
 * <p>
 * Выходные данные: Hello, World! How are you?
 */

public class Main {
    public static void parallelFileReading() {
        // поток 1
        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                try (FileInputStream fis = new FileInputStream("basic_programming/lesson_43_homework/src/File_1")) {
                    int i;
                    while ((i = fis.read()) != -1) {
                        System.out.print((char) i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // поток 2
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try (FileInputStream fis = new FileInputStream("basic_programming/lesson_43_homework/src/File_2")) {
                    int i;
                    while ((i = fis.read()) != -1) {
                        System.out.print((char) i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        r.start();
        t.start();
    }
}
