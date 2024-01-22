package practice.linked_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestResult {
    private String testName;
    private long arrayListTime;
    private long linkedListTime;

    public List<TestResult> getResults() {
        return results;
    }

    private List<TestResult> results = new ArrayList<>();

    public TestResult() {
    }

    public TestResult(String testName, long arrayListTime, long linkedListTime) {
        this.testName = testName;
        this.arrayListTime = arrayListTime;
        this.linkedListTime = linkedListTime;
    }

    public String getTestName() {
        return testName;
    }

    public long getArrayListTime() {
        return arrayListTime;
    }

    public long getLinkedListTime() {
        return linkedListTime;
    }

    public void addResult(TestResult result) {
        results.add(result);
    }

    public TestResult getTestResults(int size) {
        TestResult results = new TestResult();

        // Для каждого теста вызываем соответствующий метод и добавляем результат
        results.addResult(testListPerformance(size, "Добавление в конец"));
        results.addResult(testListPerformance(size, "Добавление в начало"));
        results.addResult(testListPerformance(size, "Удаление из начала"));
        results.addResult(testListPerformance(size, "Доступ к элементам"));
        results.addResult(testListPerformance(size, "Удаление из конца"));
        results.addResult(testListPerformance(size, "Итерация по всем элементам"));

        return results;
    }

    private TestResult testListPerformance(int size, String testType) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long arrayListDuration = measurePerformance(arrayList, size, testType);
        long linkedListDuration = measurePerformance(linkedList, size, testType);

        return new TestResult(testType, arrayListDuration, linkedListDuration);
    }

    private long measurePerformance(List<Integer> list, int size, String operationType) {
        prepareList(list, size);
        long startTime = System.nanoTime();
        performOperation(list, size, operationType);
        long endTime = System.nanoTime();
        return endTime - startTime;
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
