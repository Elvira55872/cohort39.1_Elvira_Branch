package practice;

public class ArrayUtil<T> {
    public static void main(String[] args) {
        // Использование
        Integer[] intArray = {1, 2, 3};
        ArrayUtil<Integer> integerArrayUtil = new ArrayUtil<>(intArray);
        Integer number = integerArrayUtil.getElement(1); // Возвращает 2

        System.out.println(number);

        ArrayUtil<String> stringArrayUtil = new ArrayUtil<>(new String[]{"one", "two", "three"});
        System.out.println(stringArrayUtil.getElement(2));
    }

    private T[] array; // null

    public ArrayUtil(T[] array) {
        this.array = array;
    }

    // Метод для возврата элемента по индексу
    public T getElement(int index) {
        if (index < array.length) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива.");
        }
    }

    // Метод для определения содержится ли данный элемент в массиве или нет
    public boolean contains(T t) {
        if(array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == t) {
                    return true;
                }
            }
        }
        return false;
    }


}

