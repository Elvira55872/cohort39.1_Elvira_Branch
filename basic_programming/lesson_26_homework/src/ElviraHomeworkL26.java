import java.util.Arrays;

/**
 * Задача 1: Работа с обобщенными методами.
 * <p>
 * Разработайте статический обобщенный метод swap,
 * который принимает массив любого типа и два индекса,
 * и обменивает местами элементы по этим индексам.
 */

public class ElviraHomeworkL26<T> {
    private T[] array;

    public ElviraHomeworkL26(T[] array) {
        this.array = array;
    }

    public T[] swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        // Array of Integer
        Integer[] intArray = {0, 1, 2, 3, 4, 5};
        ElviraHomeworkL26<Integer> intArr = new ElviraHomeworkL26<>(intArray);
        intArr.swap(intArray, 0, 5);

        // Array of String
        String[] strArray = {"zero", "one", "two", "three"};
        ElviraHomeworkL26<String> strArr = new ElviraHomeworkL26<>(strArray);
        strArr.swap(strArray, 0, 3);
    }
}
