package task_1;

/**
 * ПРЯМОУГОЛЬНИК - надо длинны 2 сторон
 * * P = 2 * (a + b)
 */

public class Rectangle extends Shape {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }
}
