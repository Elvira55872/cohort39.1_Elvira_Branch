package teacher_code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TeacherCode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        ArrayList<String> stringArrayList = new ArrayList<>(6); // {null, null, null, null,null, null} size = 0

        stringArrayList.add(null); //  size = 1 {null, null, null, null, null, null}
        stringArrayList.add("one"); // size = 2 {null, one, null, null, null, null}
        stringArrayList.add("two");
        stringArrayList.add("three");

        // {one, two, three}
        //   0     1     2
        stringArrayList.get(1);

        printArray(stringArrayList);

        stringArrayList.add(null);

        // метод List.of позволяет создать неизменяемую коллекцию из элементов,
        // то есть из нее ничего нельзя удалить или добавить
        List<String> immutableArrayList = List.of("four", "five", "six");

        try {
            immutableArrayList.add("seven");

        } catch (UnsupportedOperationException exception) {
            if (exception.getMessage() != null) {
                System.out.println(exception.getMessage());
            } else {
                System.out.println("не получилось добавить новый элемент");
            }
        }

        stringArrayList.addAll(immutableArrayList);

        printArray(stringArrayList);

        stringArrayList.add(2 , "seven");

        printArray(stringArrayList);

        stringArrayList.set(2 , "eight");

        printArray(stringArrayList);

        stringArrayList.remove( 3);

        printArray(stringArrayList);

        stringArrayList.add(2 , "four");
        stringArrayList.add(2 , "four");
        stringArrayList.add(2 , "four");

        printArray(stringArrayList);

        stringArrayList.remove("four");

        printArray(stringArrayList);


        // удаляет все элементы, содержащиеся в immutableArrayList из stringArrayList
        try {
            stringArrayList.removeAll(immutableArrayList);
        } catch (NullPointerException e) {
            System.out.println("данная операция работает только если в коллекйии нет значений null");
        }

        printArray(stringArrayList);

        System.out.println("stringArrayList.contains(\"four\") = " + stringArrayList.contains("four"));

        // данная операция позволяет сократить размер внутреннего массива до size, то есть,
        // внутренний массив теперь содержит только элементы, которые добавил пользователь
        // для приложения это позволяет сэкономить память, тк уменьшает ращмер массива
        stringArrayList.trimToSize();
    }

    static void printArray (ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

}




