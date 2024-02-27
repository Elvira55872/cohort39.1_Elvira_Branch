import java.util.ArrayList;
import java.util.Random;

/**
 * Анализ числовых данных:
 * Заполните ArrayList случайными числами. Напишите методы для нахождения максимального,
 * минимального и среднего значения в списке (сумма всех значений, деленная на количество элементов).
 * <p>
 * Доп функционал, по желанию:
 * Реализуйте функцию для нахождения всех простых чисел в списке.
 */

public class Homework_L27_task2 {
    // рандомное заполнение списка
    public static ArrayList<Integer> fillUpRandom(ArrayList<Integer> list, int size, int from, int to) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(from, to));
        }
        return list;
    }

    // нахождение максимального числа
    public static int maxNumber(ArrayList<Integer> list) {
        int maxNumber = list.get(0);
        for (Integer integer : list) {
            if (maxNumber < integer) {
                maxNumber = integer;
            }
        }
        return maxNumber;
    }

    // нахождение минимального числа
    public static int minNumber(ArrayList<Integer> list) {
        int minNumber = list.get(0);
        for (Integer integer : list) {
            if (minNumber > integer) {
                minNumber = integer;
            }
        }
        return minNumber;
    }

    // нахождение среднего значения в списке
    public static double middleNumber(ArrayList<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum / list.size();
    }

    // нахождение всех простых чисел в списке
    public static ArrayList<Integer> simpleNumbers(ArrayList<Integer> list) {
        ArrayList<Integer> simpleNumbers = new ArrayList<>();
        for (Integer integer : list) {
            boolean isPrime = true;
            for (int j = 2; j <= integer / 2; j++) {
                if (integer % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (integer == 0) {
                continue;
            } else if (integer == 1) {
                isPrime = false;
            } else if (isPrime) {
                simpleNumbers.add(integer);
            }
        }
        return simpleNumbers;
    }
}
