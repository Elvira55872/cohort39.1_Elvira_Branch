package teacher_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TeacherCode {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // [1, 2, 3]
        //_______________________________


        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(43);

        // (1) -> (2) -> (3) -> (43) -> null

        NodeExample first = new NodeExample(22); // data = 22; next = null
        NodeExample second = new NodeExample(33); // data = 33; next = null

        first.next = second;// data = 22; next = second
        // second: data = 33; next = null

        tryLinkedNode();

    }

    static void tryLinkedNode() {
        Scanner scanner = new Scanner(System.in);

        NodeExample first = new NodeExample(12); // @link1  first data = 12, next = null,
        NodeExample temp = new NodeExample(15); //  @link2  temp  data = 15, next = null,

        first.next = temp; // first data = 12, next = @link2,

        while (scanner.hasNextInt()) {
            NodeExample scannerNode = new NodeExample(scanner.nextInt()); // @link234  data = scanner.nextInt() next = null
            temp.next = scannerNode; // /  @link2  temp  data = 15, next = @link234
            temp = scannerNode; // @link234   temp  data = scanner.nextInt() next = null
        }

        temp = first; //

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

}




