/**
 * 1/8/2024
 * Algorithms
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main3 {
    public static void main(String[] args) {

        int[] a = {2, 4, 100, 1, 10, 5, -5, -2, 30};

        int indexOfMin = 0; // 1
        int indexOfMax = 0; // 1

        int min = a[0]; // 1
        int max = a[0]; // 1

        for (int i = 1; i < a.length; i++) { // 3

            if (a[i] < min) { // 1

                min = a[i]; // 1

                indexOfMin = i; // 1
            }

            if (a[i] > max) { // 1

                max = a[i]; // 1
                indexOfMax = i; // 1
            }
        }

        int temp = a[indexOfMin]; // 1
        a[indexOfMin] = a[indexOfMax]; // 1
        a[indexOfMax] = temp; // 1

        // ФОРМУЛА: 4 + 9N + 3 = 9N + 7
    }
}
