import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Задание 3: Обработка исключений
 * <p>
 * Напишите метод, который будет пытаться читать несуществующий файл
 * и обрабатывать возможное исключение FileNotFoundException, выводя сообщение об ошибке в консоль.
 * <p>
 * Пример работы:
 * Входные данные: Попытка чтения несуществующего файла nonexistent.txt.
 * Выходные данные: В консоль выводится сообщение "File not found: nonexistent.txt".
 */

public class Task_3 {
    public static void fileReader(String pathToFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            // почему-то джава не дала мне записать 2 исключения в 1 блок catch (FileNotFoundException | IOException e)
            // поэтому новое исключение z добавила отдельным блоком catch и все работает корректно
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // тоже не понимаю как сделать тесты на получение ошибки
    public static void main(String[] args) {
        fileReader("nonexistent.txt");
    }
}
