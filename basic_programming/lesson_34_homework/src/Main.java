import java.util.Stack;

/**
 * Описание
 * Разработайте программу на Java для проверки правильности скобочной последовательности.
 * Правильная скобочная последовательность должна удовлетворять следующим критериям:
 * <p>
 * Каждой открывающей скобке ((, [, {) должна соответствовать закрывающая скобка того же типа (), ], }).
 * Закрывающая скобка должна следовать после своей открывающей пары.
 * Скобки должны быть правильно вложены друг в друга.
 * <p>
 * Примеры
 * <p>
 * Вход: ( [ ] { } ) Вывод: true
 * <p>
 * Вход: [(]) Вывод: false
 * <p>
 * Вход: {[( )]} Вывод: true
 * <p>
 * Вход: {[} Вывод: false
 * <p>
 * Реализация
 * Используйте стек для отслеживания открывающих скобок. При обходе строки, помещайте в стек все открывающие скобки.
 * <p>
 * При встрече закрывающей скобки проверьте, соответствует ли она верхнему элементу стека (последней открывающей скобке).
 * Если соответствует, извлеките элемент из стека. В противном случае, последовательность скобок неверная.
 * После обработки всей строки, если стек пуст, последовательность верная. Если в стеке остались элементы,
 * последовательность неверная.
 */

public class Main {
    public static boolean bracketsChecker(String str) {
        char[] charArray = str.replaceAll(" ", "").toCharArray();
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                brackets.push(charArray[i]);
            }

            if ((charArray[i] == ')') && brackets.peek().equals('(')) {
                brackets.pop();
            }

            if ((charArray[i] == ']') && brackets.peek().equals('[')) {
                brackets.pop();
            }

            if ((charArray[i] == '}') && brackets.peek().equals('{')) {
                brackets.pop();
            }
        }

        System.out.println(brackets.isEmpty());
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        bracketsChecker("( [ ] { } )");
        bracketsChecker("[(])");
        bracketsChecker("{[( )]}");
        bracketsChecker("{[}");
    }
}
