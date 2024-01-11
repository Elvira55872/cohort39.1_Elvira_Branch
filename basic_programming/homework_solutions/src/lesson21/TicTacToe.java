package lesson21;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board; // Двумерный массив символов для представления игрового поля
    private int boardSize; // Размер игрового поля
    private char currentPlayer; // Текущий игрок (X или O)

    // Конструктор класса, инициализирующий игровое поле заданного размера
    public TicTacToe(int boardSize) {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
        this.currentPlayer = 'X'; // Начальный игрок - X
        initializeBoard(); // Инициализация игрового поля
    }

    // Метод для инициализации игрового поля, заполняет его пустыми клетками
    private void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Метод для выполнения хода игроком
    public void makeMove(int row, int col) {
        // Проверка, что указанные координаты находятся в пределах игрового поля и клетка свободна
        if (row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == '-') {
            board[row][col] = currentPlayer; // Размещение символа текущего игрока на поле
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Смена игрока
        }
    }

    // Метод для проверки наличия победителя
    public boolean isWinner() {
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
    }

    // Проверка строк на наличие выигрышной комбинации
    private boolean checkRowsForWin() {
        for (int i = 0; i < boardSize; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    // Проверка столбцов на наличие выигрышной комбинации
    private boolean checkColumnsForWin() {
        for (int i = 0; i < boardSize; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    // Проверка диагоналей на наличие выигрышной комбинации
    private boolean checkDiagonalsForWin() {
        return (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]));
    }

    // Вспомогательный метод для проверки равенства трех символов
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    // Метод для проверки наличия ничьей
    public boolean isDraw() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == '-') {
                    return false; // Есть свободные клетки, игра продолжается
                }
            }
        }
        return true; // Свободных клеток нет, игра заканчивается вничью
    }

    // Геттеры для доступа к текущему игроку и игровому полю
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    // Метод для запуска игры
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру Крестики-нолики!");

        // Основной игровой цикл
        while (!isWinner() && !isDraw()) {
            printBoard();
            System.out.println("Ход игрока " + currentPlayer);
            System.out.print("Введите координаты (строка и столбец): ");

            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Проверка корректности ввода и выполнение хода
            if (row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == '-') {
                makeMove(row, col);
            } else {
                System.out.println("Неверный ход. Попробуйте снова.");
            }
        }

        // Печать итоговой ситуации на поле и объявление результата игры
        printBoard();
        if (isWinner()) {
            System.out.println("Победил игрок " + (currentPlayer == 'X' ? 'O' : 'X'));
        } else {
            System.out.println("Игра завершилась вничью!");
        }

        scanner.close();
    }

    // Метод для печати игрового поля
    private void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру Крестики-нолики!");

        // Запрос размера игрового поля
        int boardSize;
        do {
            System.out.print("Введите размер поля (от 3 до 20): ");
            boardSize = scanner.nextInt();
        } while (boardSize < 3 || boardSize > 20);

        // Создание игры и запуск
        TicTacToe game = new TicTacToe(boardSize);
        game.playGame();

        scanner.close();
    }
}
