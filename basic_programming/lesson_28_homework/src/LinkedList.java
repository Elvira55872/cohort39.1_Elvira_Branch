import java.util.List;

public class LinkedList implements MyLinkedList {
    private Node_2 first;
    private int count;

    public LinkedList() {
        first = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // добавляет элемент в конец списка
    // a->b->c->d->e  add(f) -> a->b->c->d->e->f
    @Override
    public boolean add(String data) {
        Node_2 newNode = new Node_2(data,null);
        if (first == null) {
            // Если список пуст, новый узел становится головой
            first = newNode;
            count = 1;
        } else {
            // Иначе идем до последнего узла и вставляем новый узел
            Node_2 current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            count++;
        }

        if (isEmpty()) {
            first = new Node_2(data, null);
            count = 1;
            return true;
        }
        Node_2 current = first;
        while (current.hasNext()) {
            current = current.getNext();
        }
        Node_2 newNode = new Node_2<>(data);
        current.setNext(newNode);
        count++;
        return true;
    }

    // добавляет элемент по индексу
    // a->b->c->d->e  add(2, f) -> a->b->f->c->d->e
    @Override
    public boolean add(int index, String data) throws IndexOutOfBoundsException {

        return false;
    }

    @Override
    public boolean set(int index, String data) throws IndexOutOfBoundsException {
        return false;
    }

    @Override
    public boolean addFirst(String data) {
        return false;
    }

    @Override
    public boolean addLast(String data) {
        return false;
    }

    @Override
    public boolean addAll(List<String> list) {
        return false;
    }

    @Override
    public boolean contains(String data) {
        return false;
    }

    @Override
    public String get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public String getFirst() {
        return first.toString();
    }

    @Override
    public String getLast() {
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public int indexOf(String data) {
        return 0;
    }

    @Override
    public int firstIndexOf(String data) {
        return 0;
    }

    @Override
    public int lastIndexOf(String data) {
        return 0;
    }
}
