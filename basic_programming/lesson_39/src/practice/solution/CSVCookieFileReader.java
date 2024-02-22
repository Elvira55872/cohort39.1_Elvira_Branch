package practice.solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CSVCookieFileReader implements CookieFileReader{
    @Override
    public Map<Cookie, Integer> readFile(File file, String date) {
        Map<Cookie, Integer> cookieCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Проверка, соответствует ли запись заданной дате
                if (parts.length == 2 && parts[1].startsWith(date)) {
                    LocalDateTime parsedDate = LocalDateTime.parse(parts[1], DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                    String cookieId = parts[0];

                    Cookie cookie = new CSVCookie(cookieId, parsedDate);

                    // Обновление счетчика посещений для данного cookie
                    int count = cookieCounts.getOrDefault(cookie, 0) + 1;
                    cookieCounts.put(cookie, count);
                }
            }
        } catch (IOException e) {
            //..
        }

        return cookieCounts;
    }

}
