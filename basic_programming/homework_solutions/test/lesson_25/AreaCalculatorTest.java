package lesson_25;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaCalculatorTest {

    @Test
    public void testCalculateAreaWithInvalidRadius() throws IncorrectFigureSizeException {
        try {
            AreaCalculator.calculateArea(-1.0); // Некорректный радиус
        } catch (IncorrectFigureSizeException exception) {
            Assertions.assertEquals("Некорректный радиус: -1.0", exception.getMessage());
        }
    }

    @Test
    public void testCalculateAreaWithInvalidRectangleSides() throws IncorrectFigureSizeException {
        try {
            AreaCalculator.calculateArea(-1.0, 2.0); // Некорректные стороны прямоугольника
        } catch (IncorrectFigureSizeException exception) {
            Assertions.assertEquals("Некорректные размеры сторон прямоугольника: -1.0, 2.0",
                    exception.getMessage());
        }
    }

    @Test
    public void testCalculateAreaWithInvalidTriangleSides() throws IncorrectFigureSizeException {
        try {
            AreaCalculator.calculateArea(1.0, 2.0, 3.0); // Некорректные стороны треугольника (не образуют треугольник)
        } catch (IncorrectFigureSizeException exception) {
            Assertions.assertEquals("Некорректные размеры сторон треугольника: 1.0, 2.0, 3.0",
                    exception.getMessage());
        }
    }
}
