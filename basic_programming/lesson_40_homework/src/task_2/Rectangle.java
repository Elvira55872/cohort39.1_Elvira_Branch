package task_2;

/**
 * ПРЯМОУГОЛЬНИК - надо длинны 2 сторон
 * * P = 2 * (a + b)
 */

public class Rectangle extends Shape implements Resizable {
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

    @Override
    public void resize(double coefficient) {
        this.side1 *= coefficient;
        this.side2 *= coefficient;
    }
}
