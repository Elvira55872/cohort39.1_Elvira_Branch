package practice.linked_list;

/**
 * Особенности реализации: <p>
 * Каждый узел содержит ссылки как на предыдущий, так и на следующий элементы.<p>
 * При добавлении элемента обновляются ссылки на предыдущий и следующий узлы.<p>
 * При удалении элемента обновляются ссылки соседних узлов.<p><p>
 * Преимущества по сравнению с односвязными списками:<p>
 * Двунаправленный доступ: позволяет перемещаться как вперед, так и назад по списку.<p>
 * Удобство удаления: легко удалять узлы, имея доступ к предыдущему узлу (не нужно искать его).<p><p>
 * Недостатки:<p>
 * Больше занимаемой памяти: каждый узел содержит две ссылки.<p>
 * Сложность реализации: управление двумя ссылками в каждом узле усложняет код.<p>
 */
public class DoublyLinkedList {

    private Node head; // Начало списка
    private Node tail; // Конец списка

    // Конструктор двусвязного списка
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Метод для добавления элемента в конец списка
    public void add(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            // Если список пуст, новый узел становится и головой, и хвостом
            head = newNode;
            tail = newNode;
        } else {
            // Добавляем узел в конец списка
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Метод для удаления узла
    public void delete(int key) {
        Node current = head;

        // Поиск узла для удаления
        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) return; // Узел не найден

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // Удаляемый узел был головой списка
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Удаляемый узел был хвостом списка
        }
    }

    // Вспомогательный метод для печати списка
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Основной метод для демонстрации работы списка
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.printList(); // Печать списка

        list.delete(2);
        list.printList(); // Печать после удаления
    }
}
