import java.util.Arrays;

/**
 * 1/8/2024
 * Algorithms
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        // пусть есть массив, мы хотим поменять местами
        // максимум и минимум этого массива
        int[] a = {2, 4, 100, 1, 10, 5, -5, -2, 30};

        int indexOfMin = 0; // индекс минимального
        int indexOfMax = 0; // индекс максимального

        // найдем минимум
        int min = a[0]; // предполагаем, что первый элемент минимальный

        // просмотрим все остальные элементы
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                // если минимальный элемент больше
                // текущего i-го, то мы должны запомнить его
                min = a[i];
                // и запомнить его индекс
                indexOfMin = i;
            }
        }

        // найдем максимум
        int max = a[0]; // предполагаем, что первый элемент максимальный

        // просмотрим все остальные элементы
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                // если максимальный элемент меньше
                // текущего i-го, то мы должны запомнить его
                max = a[i];
                // и запомнить его индекс
                indexOfMax = i;
            }
        }

        System.out.println("Минимальный элемент " + min + " под индексом " + indexOfMin);
        System.out.println("Максимальный элемент " + max + " под индексом " + indexOfMax);

        // меняем местами два элемента массива
        int temp = a[indexOfMin];
        a[indexOfMin] = a[indexOfMax];
        a[indexOfMax] = temp;

        System.out.println(Arrays.toString(a));
    }
}
