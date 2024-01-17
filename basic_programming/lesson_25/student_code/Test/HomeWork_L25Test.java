import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWork_L25Test {
    /**
     * Incorrect tests to get IncorrectFigureSizeException
     * Result is compared as text
     */
    @Test
    public void sircleIncorrectCalculateAreaTest() {
        HomeWork_L25 exeption = new HomeWork_L25();
        String exceptionMessage = null;
        try {
            exeption.calculateArea(new double[]{-3});
        } catch (IncorrectFigureSizeException e) {
            exceptionMessage = e.getMessage();
        }
        Assertions.assertEquals("Sircle area: sircle doesnt exist", exceptionMessage);
    }

    @Test
    public void squareIncorrectCalculateAreaTest() {
        HomeWork_L25 exeption = new HomeWork_L25();
        String exceptionMessage = null;
        try {
            exeption.calculateArea(new double[]{-3, 0});
        } catch (IncorrectFigureSizeException e) {
            exceptionMessage = e.getMessage();
        }
        Assertions.assertEquals("Square area: square doesnt exist", exceptionMessage);
    }

    @Test
    public void triangleIncorrectCalculateAreaTest() {
        HomeWork_L25 exeption = new HomeWork_L25();
        String exceptionMessage = null;
        try {
            exeption.calculateArea(new double[]{-3, 0, 345});
        } catch (IncorrectFigureSizeException e) {
            exceptionMessage = e.getMessage();
        }
        Assertions.assertEquals("Triangle area: your triangle doesn`t exist", exceptionMessage);
    }

    /**
     * Correct tests
     * Result is compared as double numbers
     */
    @Test
    public void sircleCorrectCalculateAreaTest() {
        HomeWork_L25 exeption = new HomeWork_L25();
        double result = 0;
        try {
            result = exeption.calculateArea(new double[]{1});
        } catch (IncorrectFigureSizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        Assertions.assertEquals(3.14, result, 0.01);
    }

    @Test
    public void squareCorrectCalculateAreaTest() {
        HomeWork_L25 exeption = new HomeWork_L25();
        double result = 0;
        try {
            result = exeption.calculateArea(new double[]{1, 5});
        } catch (IncorrectFigureSizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        Assertions.assertEquals(5, result, 0.1);
    }

    @Test
    public void triangleCorrectCalculateAreaTest() {
        HomeWork_L25 exeption = new HomeWork_L25();
        double result = 0;
        try {
            result = exeption.calculateArea(new double[]{4, 6, 5});
        } catch (IncorrectFigureSizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        Assertions.assertEquals(9.9, result, 0.1);
    }
}
