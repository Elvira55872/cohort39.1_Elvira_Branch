package teacher_code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TeacherCode3 {
    public static void main(String[] args) throws IOException {
        String path = "basic_programming/lesson_33/resources/file1.txt";
        String path1 = "basic_programming/lesson_33/resources/output.txt";

        File input = new File(path);
        File output = new File(path1);

        Scanner scanner = new Scanner(input);

        FileOutputStream fos = new FileOutputStream(output, true);
        int counter = 1;
        while (scanner.hasNext()) {
            String temp = counter + ". " + scanner.nextLine() + "\n" ;
            fos.write(temp.getBytes());
            counter++;
        }

    }
}
