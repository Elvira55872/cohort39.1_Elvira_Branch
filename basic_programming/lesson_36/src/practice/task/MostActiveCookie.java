package practice.task;

import java.io.*;
import java.util.*;

public class MostActiveCookie {

    public static void main(String[] args) {
        // Инициализация переменных для хранения имени файла и даты
        String fileName = null;
        String date = null;
        // Парсинг аргументов командной строки
        for (int i = 0; i < args.length; i++) {
            if ("-f".equals(args[i])) {
                fileName = args[++i]; // Получение имени файла
            } else if ("-d".equals(args[i])) {
                date = args[++i]; // Получение даты
            }
        }

        // Проверка на наличие необходимых аргументов
        if (fileName == null || date == null) {
            System.out.println("Usage: java MostActiveCookie -f <filename> -d <date>");
            return;
        }

        // Словарь для подсчета количества каждого cookie
        Map<String, Integer> cookieCounts = new HashMap<>();
        // Максимальное количество посещений для cookie
        int maxCount = 0;
        // Список самых активных cookie
        List<String> mostActiveCookies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Чтение файла построчно
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Проверка, соответствует ли запись заданной дате
                if (parts.length == 2 && parts[1].startsWith(date)) {
                    String cookie = parts[0];
                    // Обновление счетчика посещений для данного cookie
                    int count = cookieCounts.getOrDefault(cookie, 0) + 1;
                    cookieCounts.put(cookie, count);

                    // Обновление списка самых активных cookie
                    if (count > maxCount) {
                        mostActiveCookies.clear();
                        mostActiveCookies.add(cookie);
                        maxCount = count;
                    } else if (count == maxCount) {
                        mostActiveCookies.add(cookie);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Вывод самых активных cookie
        for (String cookie : mostActiveCookies) {
            System.out.println(cookie);
        }
    }
}
