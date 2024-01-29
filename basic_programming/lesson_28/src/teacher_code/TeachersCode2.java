package teacher_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TeachersCode2 {
    public static void main(String[] args) {
        // системные переменные для работы
        List<String> immutable = List.of("one", "movie", "car");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        //__________________________________________

        // основной код:
        LinkedList<Integer> linkedList = new LinkedList<>(); // пусто
        LinkedList<String> stringLinkedList = new LinkedList<>(immutable); // в основе уже лежат элементы из immutable

        // добавление одного элемента
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);

        printList(linkedList);

        // добавление всех элементов из другой коллекции (arrayList)
        linkedList.addAll(arrayList);

        printList(linkedList);

        // получение элемента по индексу (O(n))
        try {
            System.out.println(linkedList.get(30));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Если индекс больше, либо равен длине списка, то можно получить ошибку IndexOutOfBoundsException");
        }

        // вставка элемента по индексу (O(n))
        linkedList.add(1, 456);
        printList(linkedList);

        // замена элемента по индексу (O(n)):
        linkedList.set(1, 987);
        printList(linkedList);

        // вставка элемента в начало и в конец (O(1)):
        linkedList.addFirst(77);
        linkedList.addFirst(77);
        linkedList.addFirst(77);

        linkedList.addLast(77);
        linkedList.addLast(77);
        linkedList.addLast(77);
        printList(linkedList);

        // удалет первое вхождение элемента (O(n)):
        // специфика того, что наш лист содержит числа, если при операции ".remove(77)" передать просто число,
        // то джава подумает, что это примитив, следовательно это индекс элемента, который надо удалить,
        // тк есть 2 метода remove(Object 0) и remove(int index). Следовательно, если мы хотим  удалить элемент 77,
        // нам следует в качестве значения аргумента передавать Integer
        linkedList.remove((Integer) 77);
        printList(linkedList);

        // удаляет первое вхождение данного элемента в лист  (O(n)):
        linkedList.removeFirstOccurrence(77);
        printList(linkedList);

        // удаляет последнее вхождение данного элемента в лист (O(n)):
        linkedList.removeLastOccurrence(77);
        printList(linkedList);

        // просто удаляет последний и первый элемент соответственно (O(1)):
        linkedList.removeLast();
        linkedList.removeFirst();
        printList(linkedList);

        // проверяет наличие данного элемента в листе (O(n))
        System.out.println("linkedList.contains(20) = " + linkedList.contains(20));
        System.out.println("linkedList.contains(21) = " + linkedList.contains(21));

        // првоеряет наличие всех элементов из переменной arrayList в переменной linkedList (O(n^2))
        System.out.println("linkedList.containsAll(arrayList) = " + linkedList.containsAll(arrayList));

        // удаляет все элементы из переменной arrayList в переменной linkedList (O(n^2))
        linkedList.removeAll(arrayList);
        printList(linkedList);

        // возвращает первый и последний элемент соответственно (O(n))
        System.out.println("linkedList.getFirst() = " + linkedList.getFirst());
        System.out.println("linkedList.getLast() = " + linkedList.getLast());
    }

    static void printList(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println();
    }

    static void iteration(LinkedList list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }
}
