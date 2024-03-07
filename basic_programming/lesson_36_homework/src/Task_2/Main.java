package Task_2;

/**
 * Задание 2
 * Создать интерфейс Shape с методом area().
 * Используйте этот интерфейс для создания классов Circle и Rectangle.
 * После этого реализуйте функцию, которая принимает массив объектов типа Shape и вычисляет общую площадь.
 */
public class Main {
    // функция, которая принимает массив объектов типа Shape и вычисляет общую площадь
    public static double totalArea (Shape[] shapes){
        double totalArea = 0;

        for (Shape shape : shapes) {
            totalArea += shape.area();
        }

        return totalArea;
    }
}
