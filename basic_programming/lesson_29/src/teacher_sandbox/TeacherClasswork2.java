package teacher_sandbox;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TeacherClasswork2 {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("five");
        set.add("five");
        set.add("aaa");

        for (String s : set) {
            System.out.print(s + " ");
        }

        System.out.println("\n" + set.contains("asdasd"));

    }
}
