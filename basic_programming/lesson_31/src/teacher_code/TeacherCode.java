package teacher_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TeacherCode {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, null);

        System.out.println("map.isEmpty() = " + map.isEmpty());
        System.out.println("map.size() = " + map.size());

        System.out.println("map.containsKey(12) = " + map.containsKey(12));
        System.out.println("map.containsValue(\"two\") = " + map.containsValue("two"));

        System.out.println("map.get(3) = " + map.get(3));
        System.out.println("map.get(5) = " + map.get(5));
        System.out.println("map.get(20) = " + map.get(20));

        if (map.containsKey(20)) {
            // do some logic
            System.out.println("map.get(20) = " + map.get(20));
        } else {
            // do other logic
        }

        System.out.println("map.getOrDefault() = " + map.getOrDefault(30, "there are not any pair with this key"));

        Set <Map.Entry<Integer, String>> entrySet = map.entrySet();

        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println("entry.getKey() = " + entry.getKey() +
                    "; entry.getValue() = " + entry.getValue());
        }
    }
}
