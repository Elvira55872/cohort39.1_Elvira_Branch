import java.util.Scanner;

public class Main02 {
    /*
    Проверить, является ли строка палиндромом

    Палиндром - такое слово или предложение, которое читается слева направо и справа налево одинаково
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();

        if (new StringBuilder(s).reverse().toString().equals(s)) {
            System.out.println("Is palindrome!");
        } else {
            System.out.println("Is not a palindrome!!!");
        }
        /*
        String s1 = new Scanner(System.in).nextLine().toLowerCase();
        System.out.println(new StringBuilder(s1).reverse().toString().equals(s1) ? "Is palindrome!" : "Is not a palindrome!!!");
         */
    }

}
