package practice.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CookieSearcher {
    public static List<Cookie> getMostActiveCookie(Map<Cookie, Integer> cookies) {
        int max = -1;
        List<Cookie> mostActiveCookies = new ArrayList<>();

        for (Integer value : cookies.values()) {
            max = Math.max(max, value);
        }

        for (Cookie cookie : cookies.keySet()) {
            if (cookies.get(cookie) == max) {
                mostActiveCookies.add(cookie);
            }
        }

        return mostActiveCookies;
    }
}
