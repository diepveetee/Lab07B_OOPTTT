public class Board {

    private final char[][] grid;
    private static final int SIZE = 3;

    public Board() {
        grid = new char[SIZE][SIZE];
        reset();
    }

    public void reset() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                grid[r][c] = ' ';
            }
        }
    }

    public boolean isValidMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        return row >= 0 && row < SIZE &&
                col >= 0 && col < SIZE &&
                grid[row][col] == ' ';
    }

    public void applyMove(Move move) {
        grid[move.getRow()][move.getCol()] = move.getPlayer().getSymbol();
    }

    public boolean hasWinFor(Player player) {
        char s = player.getSymbol();

        // rows
        for (int r = 0; r < SIZE; r++) {
            if (grid[r][0] == s && grid[r][1] == s && grid[r][2] == s) return true;
        }

        // cols
        for (int c = 0; c < SIZE; c++) {
            if (grid[0][c] == s && grid[1][c] == s && grid[2][c] == s) return true;
        }

        // diagonals
        if (grid[0][0] == s && grid[1][1] == s && grid[2][2] == s) return true;
        if (grid[0][2] == s && grid[1][1] == s && grid[2][0] == s) return true;

        return false;
    }

    public boolean isFull() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c] == ' ') return false;
            }
        }
        return true;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }
}
