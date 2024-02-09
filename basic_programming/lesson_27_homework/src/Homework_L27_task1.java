import java.util.ArrayList;

/**
 * Обработка списка строк.
 * Создайте ArrayList, содержащий строки.
 * Напишите метод removeShortString(int size) для удаления всех строк,
 * которые короче определенной длины.
 * Реализуйте функционал для перевода всех строк в верхний регистр.
 */
public class Homework_L27_task1 {
    public static ArrayList<String> removeShortString(ArrayList<String> list, int size) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String temp1 = list.get(i);
            int temp2 = temp1.length();
            if (temp2 <= size) {
                temp.add(temp1);
            }
        }
        list.removeAll(temp);
        return list;
    }
}
