package teacher_code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int x;

        try {
            // блок кода, который может вызвать исключение
            x = scanner.nextInt();

        } catch (InputMismatchException exception) {
            // блок кода для обработки исключения
            // метод getMessage(); - вернет нам строку, содержащую информацию об этой ошибке.
            String exceptionMessage = exception.getMessage();

            //метод printStackTrace() - выведет сообщение об ошибке в консоль
            //exception.printStackTrace();

            // подобные вещи допустимы джавой, но не желательны, обычно в блоке catch должна быть
            // лишь логика обработки исключения
            x = -1;

            System.out.println("При попытке считать число из консоли возникла ошибка, пожалуйста введите корректные значения в следующий раз");
        }
        // желательно, но не обязательно указывать конкретный тип
        // исключения (InputMismatchException ex), можно обобщить и указать родительский класс,
        // например RuntimeException или просто Exception


        System.out.println("FINISH");

        try {
            getFirstIndex(null, 10);
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }

    }


    static int getFirstIndex(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }
}




