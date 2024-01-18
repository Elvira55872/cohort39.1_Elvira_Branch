/**
 * Вычисление Площади Различных Фигур
 * с использованием исключений
 */
public class HomeWork_L25 {
    public static void main(String[] args) {
        HomeWork_L25 exeption = new HomeWork_L25();

        try {
            exeption.calculateArea(new double[]{-3});
        } catch (IncorrectFigureSizeException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        try {
            exeption.calculateArea(new double[]{-12, -5});
        } catch (IncorrectFigureSizeException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        try {
            exeption.calculateArea(new double[]{-30, 5, 3.45});
        } catch (IncorrectFigureSizeException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }

    public static double calculateArea(double[] nums) throws IncorrectFigureSizeException {
        if (nums.length == 1) {
            return calculateSircle(nums);
        } else if (nums.length == 2) {
            return calculateSquare(nums);
        } else if (nums.length == 3) {
            return calculateTriangle(nums);
        } else {
            System.err.println("\nIncorrect amount of array size");
            return -1;
        }
    }

    public static double calculateSircle(double[] nums) throws IncorrectFigureSizeException {
        if (nums[0] > 0) {
            return Math.PI * nums[0] * nums[0];
        } else {
            throw new IncorrectFigureSizeException("Sircle area: sircle doesnt exist");
        }
    }

    public static double calculateSquare(double[] nums) throws IncorrectFigureSizeException {
        if (nums[0] > 0 && nums[1] > 0) {
            return nums[0] * nums[1];
        } else {
            throw new IncorrectFigureSizeException("Square area: square doesnt exist");
        }
    }

    public static double calculateTriangle(double[] nums) throws IncorrectFigureSizeException {
        if (isTriangleExists(nums)) {
            double p = (nums[0] + nums[1] + nums[2]) / 2;
            return Math.sqrt(p * (p - nums[0]) * (p - nums[1]) * (p - nums[2]));
        } else {
            throw new IncorrectFigureSizeException("Triangle area: your triangle doesn`t exist");
        }
    }

    public static boolean isTriangleExists(double[] nums) {
        boolean isTriangleExists = false;
        if ((nums[0] > 0 && nums[1] > 0 && nums[2] > 0) && (nums[0] < nums[1] + nums[2])
                && (nums[1] < nums[0] + nums[2]) && (nums[2] < nums[0] + nums[1])) {
            isTriangleExists = true;
        }
        return isTriangleExists;
    }
}
