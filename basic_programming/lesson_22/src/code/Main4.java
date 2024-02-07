import java.util.Arrays;

/**
 * 1/8/2024
 * Algorithms
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main4 {
    public static void main(String[] args) {
        // Задача: написать сортировку выбором
        // оценим сложность сортировки выбором

        int[] a = {29, 72, 98, 13, 87, 66, 52, 51, 36};

        int temp, min, indexOfMin;

        for (int i = 0; i < a.length; i++) {
            min = a[i];
            indexOfMin = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    indexOfMin = j;
                }
            }

            temp = a[indexOfMin];
            a[indexOfMin] = a[i];
            a[i] = temp;
        }

        System.out.println(Arrays.toString(a));
    }
}
