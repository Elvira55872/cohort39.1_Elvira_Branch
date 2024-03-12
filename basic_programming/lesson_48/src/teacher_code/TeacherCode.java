package teacher_code;


import java.util.*;

public class TeacherCode {
    public static void main(String[] args) {
        Map <String, Set<Integer>> map = new HashMap<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(3);
        set1.add(5);

        set2.add(2);
        set2.add(4);
        set2.add(6);

        map.put("even", set2);
        map.put("odd", set1);


        Set<Integer> set = map.getOrDefault("zero", new HashSet<>());

        if (map.containsKey("zero")) {
            set = map.get("zero");
        } else {
            set = new HashSet<>();
        }


    }



}




