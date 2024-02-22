package task_2;

import java.util.Scanner;

/**
 * Задание 2 (продолжение)
 * Ваша компания по какой-то причине захотела, чтобы в программе можно было изменить размер участка,
 * периметр которого вы считаете, после факта подсчета, и потом пересчитать еще раз.
 * <p>
 * Скопировать код из предыдущего задания. Разработать интерфейс Resizable,
 * который опишет метод resize(double coefficient). Изменить класс Shape так, чтобы он реализовывал этот интерфейс.
 * Реализовать добавленный интерфейсом метод в неабстрактных классах-наследниках класса Shape.
 * Этот метод должен пропорционально увеличивать размер фигуры. Например, если этот метод вызвать на прямоугольнике
 * со сторонами 4 и 5, передав 2, стороны должны стать 8 и 10
 * <p>
 * В основной программе, после расчета цены забора, спросить, хочет ли пользователь пропорционально
 * изменить размер участка, и если да, предоставить возможность ввести коэффициент и пересчитать сумму.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose form of your land:
                1. Circle
                2. Rectangle
                3. Right Polygon""");
        int landForm = scanner.nextInt();
        double perimeter = 0;
        double coefficient = 0;
        double radius = 0;
        double side1 = 0;
        double side2 = 0;
        int amountOfSides = 0;
        double lengthOfSide = 0;


        if (landForm == 1) {
            System.out.println("Write radius:");
            radius = scanner.nextDouble();

            Circle circle = new Circle(radius);
            perimeter = circle.getPerimeter();
        } else if (landForm == 2) {
            System.out.println("Write side 1:");
            side1 = scanner.nextDouble();

            System.out.println("Write side 2:");
            side2 = scanner.nextDouble();

            Rectangle rectangle = new Rectangle(side1, side2);
            perimeter = rectangle.getPerimeter();
        } else if (landForm == 3) {
            System.out.println("Write amount of sides:");
            amountOfSides = scanner.nextInt();

            System.out.println("Write length of the side:");
            lengthOfSide = scanner.nextDouble();

            Right_Polygon polygone = new Right_Polygon(amountOfSides, lengthOfSide);
            perimeter = polygone.getPerimeter();
        } else {
            System.out.println("Incorrect number");
        }

        System.out.println("Give me the price of fence per meter:");
        double price = scanner.nextDouble();
        System.out.println("Fence price: " + perimeter * price);

        System.out.println("Do u want to change size of land?" +
                "\nif yes - press 1" +
                "\nif no - press 2");
        int decicion = scanner.nextInt();

        if (decicion == 1) {
            System.out.println("How many times u want to make it bigger?");
            coefficient = scanner.nextDouble();
        } else if (decicion == 2) {
            System.out.println("amazing");
        } else {
            System.out.println("incorrect answer");
        }

        if (decicion == 1) {
            if (landForm == 1) {
                Circle circle = new Circle(radius);
                System.out.println("Fence price: " + circle.resize(coefficient) * price);
            } else if (landForm == 2) {
                Rectangle rectangle = new Rectangle(side1,side2);
                System.out.println("Fence price: " + rectangle.resize(coefficient) * price);
            } else if (landForm == 3) {
                Right_Polygon polygone = new Right_Polygon(amountOfSides,lengthOfSide);
                System.out.println("Fence price: " + polygone.resize(coefficient) * price);
            }
        }
    }
}