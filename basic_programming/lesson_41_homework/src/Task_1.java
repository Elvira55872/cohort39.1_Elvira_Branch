import java.util.Scanner;

/**
 * Задание 1.
 * Написать программу, которая просит пользователя ввести электронный адрес
 * и проверяет его на правильность с помощью регулярных выражений
 * Можно выбрать упрощенный вариант (без + в адресе)
 */
public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Email:");
        String email = scanner.nextLine().toLowerCase().trim();
        String regex = "[a-z0-9-_.]+@[a-z-]+\\.[a-z]{2,3}";
        if (email.matches(regex)) {
            System.out.println("Correct email");
        } else {
            System.out.println("Incorrect email");
        }
    }
}

//elli-x1996@mail.ru - корректная почта
//1996@mail.ru - только цифры
//@mail.ru - некорректная почта
//1996@@@mail.ru - некорректная почта
//elli-x1996@mail....ru - некорректная почта
//elli-x1996@mail.rufdgdf - некорректная почта
//elli-x1996!#^@mail.ru - некорректная почта
