public class Node_2<String> {
    Node_2<java.lang.String> next;   // указатель на следующий элемент
    private java.lang.String value;   // данные

    // Конструктор узла
    public Node_2(java.lang.String value, Node_2<java.lang.String> next) {
        this.value = value;
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node_2<java.lang.String> getNext() {
        return next;
    }

    public void setNext(Node_2<java.lang.String> next) {
        this.next = next;
    }
}
