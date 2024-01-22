package practice.linked_list;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListExample {
    public static void main(String[] args) {
        // Создание LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Добавление элементов
        linkedList.add("Элемент 1");
        linkedList.add("Элемент 2");
        linkedList.addFirst("Элемент 0"); // Добавление в начало
        linkedList.addLast("Элемент 3");  // Добавление в конец
        linkedList.add(2, "Элемент 1.5"); // Добавление по индексу

        // Печать всего списка
        System.out.println("LinkedList: " + linkedList);

        // Удаление элементов
        linkedList.remove("Элемент 1.5"); // Удаление по значению
        linkedList.removeFirst();         // Удаление первого элемента
        linkedList.removeLast();          // Удаление последнего элемента

        // Получение элементов
        System.out.println("Первый элемент: " + linkedList.getFirst());
        System.out.println("Последний элемент: " + linkedList.getLast());

        // Перебор элементов с использованием итератора
        System.out.println("Итерация по LinkedList:");
        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Перебор элементов с использованием for-each
        System.out.println("Перебор с for-each:");
        for (String element : linkedList) {
            System.out.println(element);
        }

        // Проверка наличия элемента
        if (linkedList.contains("Элемент 2")) {
            System.out.println("Список содержит 'Элемент 2'");
        }

        // Очистка списка
        linkedList.clear();
        System.out.println("LinkedList после очистки: " + linkedList);
    }
}

