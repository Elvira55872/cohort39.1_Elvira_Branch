package practice.linked_list;

// Узел списка
public class Node {
    int data; // Данные узла
    Node prev; // Ссылка на предыдущий узел
    Node next; // Ссылка на следующий узел

    // Конструктор узла
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
