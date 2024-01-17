package lesson_25;

public class AreaCalculator {

    public static double calculateArea(double radius) throws IncorrectFigureSizeException {
        if (!figureCanExist(radius)) {
            throw new IncorrectFigureSizeException("Некорректный радиус: " + radius);
        }
        return Math.PI * radius * radius;
    }

    public static double calculateArea(double sideA, double sideB) throws IncorrectFigureSizeException {
        if (!figureCanExist(sideA, sideB)) {
            throw new IncorrectFigureSizeException("Некорректные размеры сторон прямоугольника: " + sideA + ", " + sideB);
        }
        return sideA * sideB;
    }

    public static double calculateArea(double sideA, double sideB, double sideC) throws IncorrectFigureSizeException {
        if (!figureCanExist(sideA, sideB, sideC)) {
            throw new IncorrectFigureSizeException("Некорректные размеры сторон треугольника: " + sideA + ", " + sideB + ", " + sideC);
        }
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public static boolean figureCanExist(double radius) {
        return radius > 0;
    }

    public static boolean figureCanExist(double sideA, double sideB) {
        return sideA > 0 && sideB > 0;
    }

    public static boolean figureCanExist(double sideA, double sideB, double sideC) {
        return sideA > 0 && sideB > 0 && sideC > 0 &&
                sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA;
    }
}

