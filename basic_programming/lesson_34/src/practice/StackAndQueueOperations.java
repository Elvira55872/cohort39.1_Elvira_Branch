package practice;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueueOperations {

    /**
     * Демонстрация основных операций со стеком: push, pop, peek.
     */
    public static void demonstrateStackOperations() {
        Stack<Integer> stack = new Stack<>();

        // Добавление элементов в стек
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushes: " + stack);

        // Просмотр верхнего элемента без его удаления
        System.out.println("Peek top element: " + stack.peek());

        // Удаление элемента из стека
        System.out.println("Pop element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }

    /**
     * Демонстрация основных операций с очередью: add, remove, element.
     */
    public static void demonstrateQueueOperations() {
        Queue<Integer> queue = new LinkedList<>();

        // Добавление элементов в очередь
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue after adds: " + queue);

        // Получение головного элемента без его удаления
        System.out.println("Element at front: " + queue.element());

        // Удаление элемента из очереди
        System.out.println("Remove element: " + queue.remove());
        System.out.println("Queue after remove: " + queue);
    }

    public static void main(String[] args) {
        System.out.println("Demonstrating Stack Operations:");
        demonstrateStackOperations();

        System.out.println("\nDemonstrating Queue Operations:");
        demonstrateQueueOperations();
    }
}

