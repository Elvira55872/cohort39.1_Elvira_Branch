package practice.planer;

import java.util.Arrays;

public class Tasks<T> {
    private T[] array;

    public Tasks(T[] array) {
        this.array = array;
    }

    public Tasks() {
        array = (T[]) new Object[0];
    }

    // метод добавления нового элемента с расширением массива
    public void addTask(T t) {
        // ...
        // [1, 2, 3] + 4 -> [1, 2, 3, 0] + 4 -> [1, 2, 3, 0]
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = t;
    }

    // метод удаления элемента из массива с сокращением размера массива
    public void removeTask(T t) throws TaskException {
        int index = getFirstIndex(t);

        if (index == -1) {
            throw new TaskException("данной записи нет в списке!");
        }

        array[index] = null;
        T[] temp = (T[]) new Object[array.length - 1];

        for (int i = 0; i < temp.length; i++) {
            if (i < index) {
                temp[i] = array[i];
            } else {
                temp[i] = array[i + 1];
            }
        }

        array = temp;
    }

    public boolean contain(T t) {
        return getFirstIndex(t) != -1;
    }

    public int getFirstIndex(T t) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(t)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        if (array.length == 0) {
            return " - список пуст";
        }
        StringBuilder builder = new StringBuilder("Tasks:");
        for (int i = 0; i < array.length; i++) {
            builder.append("\n - " + array[i].toString());
        }

        return builder.toString();
    }
}
