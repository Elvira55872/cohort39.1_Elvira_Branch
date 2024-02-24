package example01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("Hello");
        list.add("Goodbye");
        list.add("how are you");
        System.out.println("Singly linked list:");
        for (String s : list) {
            System.out.println(s);
        }

        /*
        // цикл выше можно развернуть вот в такую запись
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();

            System.out.println(s);
        }
        */

        Queue<String> q = new LinkedList<>();
        q.add("Hello");
        q.add("Goodbye");
        q.add("how are you");
        System.out.println("Queue:");
        for (String s : q) {
            System.out.println(s);
        }

        System.out.println("Q empty: " + q.isEmpty());

        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Goodbye");
        set.add("how are you");
        System.out.println("Set:");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
