import java.util.Arrays;

/**
 * 1/8/2024
 * Algorithms
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {

        int[] a = {2, 4, 100, 1, 10, 5, -5, -2, 30};

        int indexOfMin = 0; // 1
        int indexOfMax = 0; // 1

        int min = a[0]; // 1

        for (int i = 1; i < a.length; i++) { // 3
            if (a[i] < min) { // 1

                min = a[i]; // 1

                indexOfMin = i; // 1
            }
        } // ИТОГО: (3 + 1 + 1 + 1) * 8 = 48 раз


        int max = a[0]; // 1

        for (int i = 1; i < a.length; i++) { // 3
            if (a[i] > max) { // 1

                max = a[i]; // 1
                indexOfMax = i; // 1
            }
        } // ИТОГО: 48 раз

        int temp = a[indexOfMin]; // 1
        a[indexOfMin] = a[indexOfMax]; // 1
        a[indexOfMax] = temp; // 1

        // ВСЕГО ОПЕРАЦИЙ: 2 + 1 + 48 + 1 + 48 + 3 = 103 операции

        // ФОРМУЛА = 7 + 6 * 8 + 6 * 8 => 7 + 6 * N + 6 * N =>
        //
        // ПОРЯДОК ОПЕРАЦИЙ - 12N + 7 - оценка алгоритма от количества данных
    }
}
