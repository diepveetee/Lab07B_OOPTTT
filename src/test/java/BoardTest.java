import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testHorizontalWin() {
        Board board = new Board();
        Player x = new Player("Player X", 'X');

        board.applyMove(new Move(0, 0, x));
        board.applyMove(new Move(0, 1, x));
        board.applyMove(new Move(0, 2, x));

        assertTrue(board.hasWinFor(x));
    }
}

