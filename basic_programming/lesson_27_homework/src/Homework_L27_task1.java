import java.util.ArrayList;

/**
 * Обработка списка строк.
 * Создайте ArrayList, содержащий строки.
 * Напишите метод removeShortString(int size) для удаления всех строк,
 * которые короче определенной длины.
 * Реализуйте функционал для перевода всех строк в верхний регистр.
 */
public class Homework_L27_task1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(Homework_L27_task1.removeShortString(list, 4).toString());
    }

    public static ArrayList<String> removeShortString(ArrayList<String> list, int size) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < size) {
                temp.add(list.get(i));
            }
        }
        list.removeAll(temp);
        list.replaceAll(String::toUpperCase);
        return list;
    }
}
