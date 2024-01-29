package lesson_27;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberListProcessor {

    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElseThrow();
    }

    public static int findMin(List<Integer> list) {
        return list.stream().min(Integer::compareTo).orElseThrow();
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }

    public static List<Integer> findPrimes(List<Integer> list) {
        List<Integer> primes = new ArrayList<>();
        for (int number : list) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100)); // Заполнение случайными числами от 0 до 99
        }

        System.out.println("Максимум: " + findMax(numbers));
        System.out.println("Минимум: " + findMin(numbers));
        System.out.println("Среднее: " + findAverage(numbers));
        System.out.println("Простые числа: " + findPrimes(numbers));
    }
}

