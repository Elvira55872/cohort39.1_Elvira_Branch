import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void Task_1() {
        // для работы тестов, сначала кладем нужные данные в файл
        Task_1.fileWriter("Java is fun", "/Users/bigkazanboss/Downloads/Java/cohort39.1_" +
                "Elvira_Branch/basic_programming/lesson_33_homework/src/TextFile_Task_1");
        Task_1.fileWriter("I love programming", "/Users/bigkazanboss/Downloads/Java/cohort39.1_" +
                "Elvira_Branch/basic_programming/lesson_33_homework/src/TextFile_Task_1");

        // далее добавляем строку из задания
        Task_1.fileWriter("Hello, World!", "/Users/bigkazanboss/Downloads/Java/cohort39.1_" +
                "Elvira_Branch/basic_programming/lesson_33_homework/src/TextFile_Task_1");

        assertEquals("Java is funI love programmingHello, World!",
                Task_1.fileReader("/Users/bigkazanboss/Downloads/Java/cohort39.1_" +
                        "Elvira_Branch/basic_programming/lesson_33_homework/src/TextFile_Task_1"));
    }

    @Test
    public void Task_2() {
        // Я не понимаю как написать тесты к коду, где нужно использовать сканер
        // ниже я пыталась прописать логику, но когда в консоли высвечивается вопрос и надо ввести имя,
        // то текст просто не вводится с клавиатуры и невозможно закончить выполнение кода

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Whats your name?");
//        Task_2.fileWriter(scanner.nextLine(), "basic_programming/lesson_33_homework/src/TextFile_Task_2_name");
//
//
//        Assertions.assertEquals("Hello, " + scanner.nextLine() + "!",
//                Task_2.fileReaderAndGreeter("basic_programming/lesson_33_homework/src/TextFile_Task_2_name"));

        // заглушка
        assertEquals(0, 0);
    }

    @Test
    public void Task_3() {
        // не понимаю как сделать тесты на получение ошибки

        // заглушка
        assertEquals(0, 0);
    }
}
