import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Переписать следующий код с использованием Stream API:

        //КОД №1
        //Цикл для фильтрации элементов:
        List<Integer> input1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> outputOld1 = new ArrayList<>();
        for (Integer i : input1) {
            if (i % 2 == 0) {
                outputOld1.add(i);
            }
        }
        System.out.println("outputOld1 = " + outputOld1);
        //НОВЫЙ КОД
        List<Integer> outputNew1 = input1.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("outputNew1 = " + outputNew1);

        //КОД №2
        //Цикл для преобразования элементов:
        List<String> input2 = Arrays.asList("apple", "banana", "cherry");
        List<Integer> outputOld2 = new ArrayList<>();
        for(String s : input2) {
            outputOld2.add(s.length());
        }
        System.out.println("outputOld2 = " + outputOld2);
        //НОВЫЙ КОД
        List<Integer> outputNew2 = input2.stream().map(String::length).toList();
        System.out.println("outputNew2 = " + outputNew2);

        //КОД №3
        //Цикл для подсчета элементов, удовлетворяющих условию:
        List<Integer> input3 = Arrays.asList(1, 2, 3, 4, 5);
        int countOld = 0;
        for(Integer i : input3) {
            if(i % 2 == 0) {
                countOld++;
            }
        }
        System.out.println("countOld = " + countOld);
        //НОВЫЙ КОД
        int countNew = (int) input3.stream().filter(i -> i % 2 == 0).count();
        System.out.println("countNew = " + countNew);
    }
}
