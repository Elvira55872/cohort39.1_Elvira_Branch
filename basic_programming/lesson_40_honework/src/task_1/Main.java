package task_1;

import java.util.Scanner;

/**
 * Задание 1
 * Вы работаете в фирме по изготовлению и установке заборов. В вашей компании есть возможность заказать заборы
 * на участки круглой, прямоугольной и многоугольной формы. Разработайте программу, в которой можно будет посчитать
 * цену забора на участок. Программа должна спрашивать форму участка, размеры участка в метрах и цену за метр забора.
 * <p>
 * Для выполнения задания создать абстрактный класс Shape, в нем описать абстрактный метод getPerimeter
 * <p>
 * Создать классы Прямоугольник, Круг и Правильный многоугольник, которые наследуют этот класс.
 * <p>
 * Справка: Правильный многоугольник - такая фигура, у которой неопределенное количество сторон, но все эти стороны
 * равны между собой, и сложены таким образом, что все углы в многоугольнике равны.
 * <p>
 * В Main написать саму программу, которая при запуске спрашивает все что нужно, создает нужный объект и считает
 * периметр участка. Расчёт цены должен также происходить в Main.
 * <p>
 * Введение формы участка реализовать одним из двух способов:
 * 1 Считывать название формы как строку
 * 2 Вывести в консоль пронумерованный список доступных форм, и считывать номер формы (на подобии меню)
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

        if (landForm == 1) {
            System.out.println("Write radius:");
            double radius = scanner.nextDouble();

            Circle circle = new Circle(radius);
            perimeter = circle.getPerimeter();
        } else if (landForm == 2) {
            System.out.println("Write side 1:");
            double side1 = scanner.nextDouble();

            System.out.println("Write side 2:");
            double side2 = scanner.nextDouble();

            Rectangle rectangle = new Rectangle(side1, side2);
            perimeter = rectangle.getPerimeter();
        } else if (landForm == 3) {
            System.out.println("Write amount of sides:");
            int amountOfSides = scanner.nextInt();

            System.out.println("Write length of the side:");
            double lengthOfSide = scanner.nextDouble();

            Right_Polygon polygone = new Right_Polygon(amountOfSides, lengthOfSide);
            perimeter = polygone.getPerimeter();
        } else {
            System.out.println("Incorrect number");
        }

        System.out.println("Give me the price of fence per meter:");
        double price = scanner.nextDouble();
        System.out.println("Fence price: " + perimeter * price);
    }
}