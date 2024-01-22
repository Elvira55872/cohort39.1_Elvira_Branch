package practice.linked_list;

public class SinglyLinkedList {


    private Node head; // Начальный узел списка

    // Конструктор для инициализации связного списка
    public SinglyLinkedList() {
        head = null;
    }

    // Метод для добавления нового узла в конец списка
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // Если список пуст, новый узел становится головой
            head = newNode;
        } else {
            // Иначе идем до последнего узла и вставляем новый узел
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Метод для удаления узла по значению
    public void delete(int key) {
        Node current = head, prev = null;

        // Если удаляемый узел - голова списка
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        // Поиск удаляемого узла, сохраняя предыдущий
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // Если узел не найден, выходим
        if (current == null) return;

        // Удаляем узел, переустанавливая ссылку предыдущего узла
        prev.next = current.next;
    }

    // Метод для поиска узла с определенным значением
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true; // Найден
            }
            current = current.next;
        }
        return false; // Не найден
    }

    // Вспомогательный метод для печати списка
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Основной метод для демонстрации работы списка
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.printList(); // Печать списка

        list.delete(2);
        list.printList(); // Печать после удаления

        System.out.println("Поиск 3: " + list.search(3)); // Поиск элемента
    }
}

