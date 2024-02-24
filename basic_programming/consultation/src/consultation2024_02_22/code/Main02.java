package consultation2024_02_22.code;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main02 {

    public static void readFile() throws IOException {
        throw new IOException("No file found!");
    }

    public static void main(String[] args) {

        try {
            readFile();
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        try {
            int number = scanner.nextInt();
            System.out.println("Your number: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Input Error!");
        }

    }
}
