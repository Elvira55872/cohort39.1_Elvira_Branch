package practice.solution;

import java.io.File;
import java.util.Map;

public interface CookieFileReader {
    Map<Cookie, Integer> readFile(File file, String date);
}
