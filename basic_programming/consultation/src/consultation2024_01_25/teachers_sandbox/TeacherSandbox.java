package consultation2024_01_25.teachers_sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TeacherSandbox {
    public static void main(String[] args) {
        nodeOperations();
    }


    public static void nodeOperations () {
        NodeCons node = createList(30);
        ArrayList<NodeCons> nodeConsArrayList = new ArrayList<>();

        while (node.next != null) {
            System.out.print(node.data);
            nodeConsArrayList.add(node);

            node = node.next;
            if (node.next != null) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println(nodeConsArrayList.get(nodeConsArrayList.size() - 3).data);
    }



    static NodeCons createList(int size) {
        NodeCons first = new NodeCons();
        first.data = 0;
        NodeCons temp = new NodeCons();
        first.next = temp;

        // first(0) ->  (1) -> (2) -> (3) -> temp (0)

        for (int i = 1; i < size; i++) {
            temp.data = i * new Random().nextInt(100);
            temp.next = new NodeCons();
            temp = temp.next;
        }

        return first;
    }




    public static void byteOperations() {
        // 0101
        // 0101

        System.out.println(Integer.toBinaryString(23));
        System.out.println(Integer.toBinaryString(24));
        System.out.println(Integer.toBinaryString(15));
        int x = 23 ^ 24;

        System.out.println(x);
    }
}
