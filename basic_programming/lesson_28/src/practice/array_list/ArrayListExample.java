package practice.array_list;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Создание ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Добавление элементов
        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Апельсин");

        // Вывод размера списка
        System.out.println("Количество фруктов: " + fruits.size());

        // Получение и вывод элемента по индексу
        System.out.println("Фрукт на второй позиции: " + fruits.get(1));

        // Изменение элемента
        fruits.set(1, "Груша");
        System.out.println("Фрукт на второй позиции после изменения: " + fruits.get(1));

        // Удаление элемента по индексу
        fruits.remove(2);

        // Удаление элемента по значению
        fruits.remove("Груша");

        // Вывод оставшихся элементов
        System.out.println("Оставшиеся фрукты: " + fruits);

        // Уменьшение размера списка до текущего числа элементов
        fruits.trimToSize();
    }
}

