package task_2;

/**
 * ПРАВИЛЬНЫЙ МНОГОУГОЛЬНИК - надо длину стороны и количество сторон
 * * Периметр = n * a, где n — количество сторон, a — длина стороны
 */
public class Right_Polygon extends Shape implements Resizable {
    private int amoutOfSides;
    private double lengthOfSide;

    public Right_Polygon(int amoutOfSides, double lengthOfSide) {
        this.amoutOfSides = amoutOfSides;
        this.lengthOfSide = lengthOfSide;
    }

    @Override
    public double getPerimeter() {
        return amoutOfSides * lengthOfSide;
    }

    @Override
    public double resize(double coefficient) {
        return getPerimeter() * coefficient;
    }
}
