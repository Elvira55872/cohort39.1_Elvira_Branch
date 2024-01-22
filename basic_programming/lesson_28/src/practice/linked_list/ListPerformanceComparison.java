package practice.linked_list;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {
    public static void main(String[] args) {
        int size = 100000; // Размер списка для тестирования

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Тест добавления в конец
        comparePerformance(arrayList, linkedList, size, "Добавление в конец");

        // Тест добавления в начало
        comparePerformance(arrayList, linkedList, size, "Добавление в начало");

        // Тест удаления из начала
        comparePerformance(arrayList, linkedList, size, "Удаление из начала");

        // Тест доступа к элементам
        comparePerformance(arrayList, linkedList, size, "Доступ к элементам");

        // Тест удаления из конца
        comparePerformance(arrayList, linkedList, size, "Удаление из конца");

        // Тест итерации по всем элементам
        comparePerformance(arrayList, linkedList, size, "Итерация по всем элементам");
    }

    private static void comparePerformance(List<Integer> arrayList, List<Integer> linkedList, int size, String testType) {
        long startTime, endTime, arrayListDuration, linkedListDuration;

        // Подготовка списков
        prepareList(arrayList, size);
        prepareList(linkedList, size);

        // ArrayList
        startTime = System.nanoTime();
        performOperation(arrayList, size, testType);
        endTime = System.nanoTime();
        arrayListDuration = endTime - startTime;

        // LinkedList
        startTime = System.nanoTime();
        performOperation(linkedList, size, testType);
        endTime = System.nanoTime();
        linkedListDuration = endTime - startTime;

        System.out.println("Тест: " + testType);
        System.out.println("ArrayList:  " + arrayListDuration + " нс");
        System.out.println("LinkedList: " + linkedListDuration + " нс");
        System.out.println();
    }

    private static void performOperation(List<Integer> list, int size, String operationType) {
        switch (operationType) {
            case "Добавление в конец":
            case "Доступ к элементам":
            case "Итерация по всем элементам":
                for (int i = 0; i < size; i++) {
                    if (operationType.equals("Добавление в конец")) {
                        list.add(i);
                    } else if (operationType.equals("Доступ к элементам")) {
                        list.get(i);
                    } else {
                        // Итерация по всем элементам
                    }
                }
                break;
            case "Добавление в начало":
                for (int i = 0; i < size; i++) {
                    list.add(0, i);
                }
                break;
            case "Удаление из начала":
            case "Удаление из конца":
                while (!list.isEmpty()) {
                    if (operationType.equals("Удаление из начала")) {
                        list.remove(0);
                    } else {
                        list.remove(list.size() - 1); // Удаление из конца
                    }
                }
                break;
        }
    }

    private static void prepareList(List<Integer> list, int size) {
        list.clear();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }
}
