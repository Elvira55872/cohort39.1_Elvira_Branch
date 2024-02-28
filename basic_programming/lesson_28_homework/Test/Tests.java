import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void testAddToTheEnd() {
        CustomLinkedList list = new CustomLinkedList();
        list.add(0);
        list.add(1);
        list.add(2);

        Assertions.assertEquals(2, list.getLast());
    }

    @Test
    public void testFindKthFromEnd() {
        CustomLinkedList list = new CustomLinkedList();
        list.add(0);
        list.add(1);
        list.add(2);

        Assertions.assertEquals(1, list.findKthFromEnd(2));
    }

}
