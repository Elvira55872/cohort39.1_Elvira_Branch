import java.io.*;

/**
 * Задание 1: Работа с файлами
 * <p>
 * Создайте текстовый файл с несколькими строками текста.
 * <p>
 * Напишите метод, который будет читать этот файл и выводить содержимое в консоль.
 * <p>
 * Напишите метод, который будет записывать в этот же файл строку “Hello, World!” в конец файла.
 * <p>
 * Пример работы:
 * Входные данные: Файл с текстом "Java is fun\nI love programming\n"
 * <p>
 * Выходные данные: В консоль выводится:
 * Java is fun
 * I love programming
 * Hello, World!
 */

public class Task_1 {
    // дополнительный метод для очистки файла
    // нужен для того, чтобы при повторном запуске кода предыдущее данные не накладывались друг на друга
    // наложение данных помешает тестированию
    public static void fileCleaner(String pathToFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile))) {
            bw.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fileReader(String pathToFile) {
        // для тестирования я сделала этот метод возвратным и ввела дополнительную переменную result
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // удаляем данные из файла
        fileCleaner(pathToFile);
        return result;
    }

    public static void fileWriter(String str, String pathToFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile, true))) {
            bw.newLine();
            bw.append(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
