package lesson21;

public class Robot {
    // Поля для хранения координат робота (x, y) и размеров поля (maxX, maxY)
    private int x, y, maxX, maxY;
    private char direction; // Поле для хранения текущего направления робота

    // Конструктор для инициализации размеров поля; начальное направление - 'N' (север)
    public Robot(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.direction = 'N';
    }

    // Метод для установки начальной позиции и направления робота
    public void setPosition(int x, int y, char direction) {
        // Проверка, что новая позиция находится внутри границ поля
        if (x >= 0 && x < maxX && y >= 0 && y < maxY) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        } else {
            // Вывод ошибки, если позиция вне границ поля
            System.err.println("Invalid position: outside of field boundaries.");
        }
    }

    // Метод для обработки строки команд
    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) { // Преобразование строки в массив символов и их перебор
            switch (command) {
                case 'L': // Если команда 'L', повернуть налево
                    turnLeft();
                    break;
                case 'R': // Если команда 'R', повернуть направо
                    turnRight();
                    break;
                case 'M': // Если команда 'M', переместиться вперед
                    move();
                    break;
                default: // В случае невалидной команды, вывод ошибки
                    System.err.println("Invalid command: " + command);
                    break;
            }
        }
    }

    // Метод для поворота робота налево
    private void turnLeft() {
        switch (direction) {
            case 'N': direction = 'W'; break; // С севера на запад
            case 'W': direction = 'S'; break; // С запада на юг
            case 'S': direction = 'E'; break; // С юга на восток
            case 'E': direction = 'N'; break; // С востока на север
        }
    }

    // Метод для поворота робота направо
    private void turnRight() {
        switch (direction) {
            case 'N': direction = 'E'; break; // С севера на восток
            case 'E': direction = 'S'; break; // С востока на юг
            case 'S': direction = 'W'; break; // С юга на запад
            case 'W': direction = 'N'; break; // С запада на север
        }
    }

    // Метод для перемещения робота на одну клетку вперед
    private void move() {
        switch (direction) {
            case 'N': if (y < maxY - 1) y++; break; // Вверх
            case 'E': if (x < maxX - 1) x++; break; // Вправо
            case 'S': if (y > 0) y--; break; // Вниз
            case 'W': if (x > 0) x--; break; // Влево
        }
    }

    // Метод для получения строкового представления текущего положения и направления робота
    @Override
    public String toString() {
        return "Robot position: (" + x + ", " + y + ") facing " + direction;
    }
}
