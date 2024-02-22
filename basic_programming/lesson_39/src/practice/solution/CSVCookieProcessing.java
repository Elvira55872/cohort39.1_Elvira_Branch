package practice.solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVCookieProcessing {

    public static void process(String[] args) throws CookieReaderException {
        // Инициализация переменных для хранения имени файла и даты
        File fileName = null;
        String date = null;
        // Парсинг аргументов командной строки
        for (int i = 0; i < args.length; i++) {
            if ("-f".equals(args[i])) {
                fileName = new File(args[++i]); // Получение имени файла
            } else if ("-d".equals(args[i])) {
                date = args[++i]; // Получение даты
            }
        }

        if (date == null) {
            throw new CookieReaderException("Incorrect CLI format. Data equals null");
        }

        if (!fileName.exists()) {
            //...
        } else if (!fileName.canRead()) {
            //...
        } else if (!fileName.isDirectory()) {
            //...
        }

        // Словарь для подсчета количества каждого cookie
        Map<Cookie, Integer> cookieCounts = new CSVCookieFileReader().readFile(fileName, date);
        List<Cookie> mostActiveCookies = CookieSearcher.getMostActiveCookie(cookieCounts);
        printMostActiveCookie(mostActiveCookies);
    }

    /**
     * javadoc
     * @param cookies
     */
    public static void printMostActiveCookie(List<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getCookieId());
        }
    }
}
