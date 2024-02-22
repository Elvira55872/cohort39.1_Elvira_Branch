public class Main04 {
    /*
    Игра "кто хочет стать программистом".
    Тема: регулярные выражения
     */

    public static void main(String[] args) {
        String regex;

        regex = "hello";
        System.out.println("hello".matches(regex));
        System.out.println("goodbye".matches(regex));
        System.out.println();

        regex = "[123hello]";
        System.out.println("12".matches(regex));
        System.out.println("o".matches(regex));

        System.out.println();

        regex = "[^java]";
        System.out.println("a".matches(regex));
        System.out.println("jv".matches(regex));

        System.out.println();

        regex = "[Z-a]";
        System.out.println("[".matches(regex));
        System.out.println("!".matches(regex));

        System.out.println();

        regex = "hi|hello|hey|[0-9]";
        System.out.println("hey".matches(regex));
        System.out.println("1-9".matches(regex));

        System.out.println();

        regex = "....";
        System.out.println("java".matches(regex));
        System.out.println("12+3".matches(regex));

        System.out.println();

        regex = "\\d.\\d";
        System.out.println("1.4".matches(regex));
        System.out.println("127".matches(regex));

        System.out.println();

        regex = "\\d+";
        System.out.println("123".matches(regex));
        System.out.println("abc1".matches(regex));

        System.out.println();

        regex = "[a-z]+\\.com";
        System.out.println("example.com".matches(regex));
        System.out.println("website.compact".matches(regex));

        System.out.println();

        regex = "hello!*";
        System.out.println("hello".matches(regex));
        System.out.println("hello!!!".matches(regex));

        System.out.println();
        // совпадает с любым числом
        regex = "\\d+[\\.,]?\\d*";
        System.out.println("1,2".matches(regex));
        System.out.println("78.456".matches(regex));
        System.out.println();

        regex = ".+!{3}";
        System.out.println("Hello!!!".matches(regex));
        System.out.println("Nice to meet you!".matches(regex));
        System.out.println();


        regex = "[^!]+!{1,3}";
        System.out.println("Hello!!".matches(regex));
        System.out.println("Nice to meet you!!!!".matches(regex));
        System.out.println();
    }
    /*
    a true true
    b true false
    c false true
    d false false
     */
    /*
        System.out.println();

        regex = "";
        System.out.println("".matches(regex));
        System.out.println("".matches(regex));
     */
}
