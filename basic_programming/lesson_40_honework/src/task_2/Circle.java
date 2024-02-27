package task_2;

/**
 * * КРУГ - надо радиус
 * *
 * * Формула периметра круга (длины окружности)
 * * Формула расчета периметра круга: C = 2 · π · r, где C это периметр, r – радиус, π – число пи.
 */
public class Circle extends Shape implements Resizable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public void resize(double coefficient) {
        this.radius *= coefficient;
    }
}
