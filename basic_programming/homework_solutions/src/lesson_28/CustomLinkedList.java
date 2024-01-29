package lesson_28;

/**
 * Поиск k-го элемента с конца в односвязном списке <p>
 * Цель:<p>
 * Реализовать метод для нахождения k-го элемента с конца в односвязном списке.<p><p>
 *
 * Задачи:<p>
 * Реализовать метод findKthFromEnd в классе CustomLinkedList.<p>
 * Метод должен находить элемент за один проход по списку.<p>
 * Продемонстрировать работу метода на различных списках.<p>
 */
public class CustomLinkedList {
    private Node head;

    // Внутренний класс для узла списка
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Метод для добавления элемента в список
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Метод для нахождения k-го элемента с конца списка
    public int findKthFromEnd(int k) {
        Node fast = head;
        Node slow = head;

        // Сдвигаем быстрый указатель на k элементов вперед
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("Размер списка меньше k");
            }
            fast = fast.next;
        }

        // Перемещаем оба указателя до тех пор, пока быстрый не достигнет конца списка
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow теперь указывает на k-й элемент с конца
        return slow.data;
    }

    // Демонстрация работы
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int k = 2;
        System.out.println(k + "-й элемент с конца: " + list.findKthFromEnd(k));
    }
}

