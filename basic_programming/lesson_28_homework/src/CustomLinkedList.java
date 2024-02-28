import java.util.LinkedList;

public class CustomLinkedList {
    private static Node first;
    private static int count;

    // Конструктор для инициализации связного списка
    public CustomLinkedList() {
        first = null;
        count = 0;
    }

    // Метод для добавления нового узла в конец списка
    public void add(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            // Если список пуст, новый узел становится головой
            first = newNode;
            count = 1;
        } else {
            // Иначе идем до последнего узла и вставляем новый узел
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            count++;
        }
    }

    // Вспомогательный метод для проверки последнего элемента
    public int getLast() {
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    // Вспомогательный метод для печати списка
    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int findKthFromEnd(int kElement) {
        if (kElement > count) {
            System.out.println("Element with this index doesnt exist");
            return -1;
        }
        int indexOfTargetElement = count - kElement;
        Node current = first;
        for (int i = 0; i < indexOfTargetElement; i++) {
            current = current.next;
        }
        return current.data;
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.printList();

        System.out.println(list.findKthFromEnd(2));
    }
}
