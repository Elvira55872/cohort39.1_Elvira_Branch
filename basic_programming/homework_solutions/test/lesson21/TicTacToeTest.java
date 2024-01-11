package lesson21;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void testBoardInitialization() {
        TicTacToe game = new TicTacToe(3);
        char[][] board = game.getBoard();
        for (char[] row : board) {
            for (char cell : row) {
                assertEquals('-', cell);
            }
        }
    }

    @Test
    void testMakeMove() {
        TicTacToe game = new TicTacToe(3);
        game.makeMove(0, 0);
        assertEquals('X', game.getBoard()[0][0]);
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    void testWinningCondition() {
        TicTacToe game = new TicTacToe(3);
        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins
        assertTrue(game.isWinner());
    }

    @Test
    void testDrawCondition() {
        TicTacToe game = new TicTacToe(3);
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 0); // O
        game.makeMove(1, 2); // X
        game.makeMove(1, 1); // O
        game.makeMove(2, 0); // X
        game.makeMove(2, 2); // O
        game.makeMove(2, 1); // X
        assertTrue(game.isDraw());
    }
}
