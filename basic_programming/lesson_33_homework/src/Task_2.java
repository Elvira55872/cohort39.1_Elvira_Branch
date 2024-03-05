import java.io.*;
import java.util.Scanner;

/**
 * Задание 2: Работа с пользовательским вводом
 * <p>
 * Напишите программу, которая будет запрашивать у пользователя его имя.
 * Запишите имя пользователя в текстовый файл.
 * Затем прочитайте файл и выведите приветствие пользователю в консоль.
 * Пример работы:
 * Входные данные: Имя пользователя Alice.
 * Выходные данные: В консоль выводится "Hello, Alice!".
 */

public class Task_2 {
    // дополнительный метод для очистки имени в файле
    // нужен для того, чтобы при повторном запуске кода предыдущее имя не выводилось на экран
    public static void fileCleaner(String pathToFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile))) {
            bw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWriter(String str, String pathToFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile, true))) {
            bw.append(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fileReaderAndGreeter(String pathToFile) {
        // для тестирования я сделала этот метод возвратным и ввела дополнительную переменную result
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line = br.readLine();
            System.out.println("Hello, " + line + "!");
            result = "Hello, " + line + "!";
        } catch (IOException e) {
            e.printStackTrace();
        }
        // удаляем имя из файла
        fileCleaner(pathToFile);
        return result;
    }

    // у меня не получилось написать тесты к этому коду (из-за использования сканера),
    // поэтому показываю работу в методе ниже
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Whats your name?");
        fileWriter(scanner.nextLine(), "basic_programming/lesson_33_homework/src/TextFile_Task_2_name");
        fileReaderAndGreeter("basic_programming/lesson_33_homework/src/TextFile_Task_2_name");
    }
}
