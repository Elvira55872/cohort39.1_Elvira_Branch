package consultation2024_02_01.teachers_sandbox;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TeacherSandbox {
    public static void main(String[] args) {
        // мапа характеризующая зал кинотеатра, где:
        // ключ - номер ряда, значение - все места в этом ряду (вложенная мапа)
        // Вложенная мапа (места в каком-то конкретном ряду):
        // ключ - конкретное место, значение - занято/не занято
        Map <Integer, Map <String, Boolean>> cinemaHall = new HashMap<>();
    }

    private static<E> Collection<E>  removeNonuniqueElementFromCollection (Collection<E> collection) {

        HashSet<E> set = new HashSet<>(collection);

        return set;
    }

    @Test
    public void testRemoveNonuniqueElementFromCollection() {
        List<Integer> list1 = List.of(0, 0, 0, 0);
        List<Integer> list2 = List.of(0, 2, 3, 0);
        List<Integer> list3 = List.of(0, 2, 3, 4);
        List<Integer> list4 = List.of();

        // проверяет размер получаемой коллекции:
        Assert.assertEquals(1, removeNonuniqueElementFromCollection(list1).size());
        Assert.assertEquals(3, removeNonuniqueElementFromCollection(list2).size());
        Assert.assertEquals(4, removeNonuniqueElementFromCollection(list3).size());
        Assert.assertEquals(0, removeNonuniqueElementFromCollection(list4).size());

        // проверяет, что осталось в коллекции:
        Assert.assertTrue(removeNonuniqueElementFromCollection(list1).contains(0));

        Assert.assertTrue(removeNonuniqueElementFromCollection(list2).contains(0));
        Assert.assertTrue(removeNonuniqueElementFromCollection(list2).contains(2));
        Assert.assertTrue(removeNonuniqueElementFromCollection(list2).contains(3));

        Assert.assertTrue(removeNonuniqueElementFromCollection(list3).contains(0));
        Assert.assertTrue(removeNonuniqueElementFromCollection(list3).contains(2));
        Assert.assertTrue(removeNonuniqueElementFromCollection(list3).contains(3));
        Assert.assertTrue(removeNonuniqueElementFromCollection(list3).contains(4));
    }
}
