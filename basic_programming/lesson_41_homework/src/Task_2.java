import java.util.Scanner;

/**
 * Задание 2.
 * Написать два метода, один из которых преобразует строку из обычного предложения в стиль lowerCamelCase,
 * а другой сделает обратное действие. Например, для строки "Какой замечательный, однако, день!"
 * результатом будет "какойЗамечательныйОднакоДень". Обратите внимание, что все символы,
 * которые не разрешаются в идентификаторах, должны удаляться. Если результат этого метода
 * превратить с помощью второго метода, должно получиться "Какой замечательный однако день"
 */
public class Task_2 {

    public static String toLowerCamelCase(String str) {
        str = str.replaceAll("[!-/:-@\\[\\]^-`{-~]", " ").toLowerCase();
        String[] words = str.split("\\s+");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result += words[i];
            } else {
                result += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
        }
        return result;
    }

    public static String toNormalCase(String str) {
        String[] words = str.split("(?=[A-Z])");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            } else {
                result += " " + words[i].toLowerCase();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write sentense");
        String str = scanner.nextLine();
        System.out.println(toLowerCamelCase(str) + " -> " + toNormalCase(toLowerCamelCase(str)));
    }
}
// Hello,my name is Ela! - текст для теста