package lesson_26;

public class SwapElement<E> {

    public void swap(E[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Массив не должен быть пустым и должен содержать минимум два элемента.");
        }

        E temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }
}

