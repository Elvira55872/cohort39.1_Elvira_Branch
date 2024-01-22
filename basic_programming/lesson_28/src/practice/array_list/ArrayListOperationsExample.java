package practice.array_list;


import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListOperationsExample {
    public static void main(String[] args) {
        // Создание ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Добавление элементов
        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Апельсин");

        // Добавление элемента по индексу
        fruits.add(1, "Груша");

        // Удаление элемента по индексу
        fruits.remove(2);

        // Удаление элемента по значению
        fruits.remove("Апельсин");

        // Обновление элемента
        fruits.set(1, "Киви");

        // Поиск элемента
        if (fruits.contains("Банан")) {
            System.out.println("Банан присутствует в списке.");
        }

        // Получение элемента и вывод размера списка
        System.out.println("Элемент на позиции 0: " + fruits.get(0));
        System.out.println("Размер списка: " + fruits.size());

        // Использование for-each цикла для перебора элементов
        System.out.println("Список фруктов:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Использование итератора для перебора элементов
        System.out.println("Перебор элементов через итератор:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

