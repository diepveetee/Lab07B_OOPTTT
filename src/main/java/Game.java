public class Game {

    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private final PlayerTurn playerTurn;
    private final Scoreboard scoreboard;

    public enum GameState {
        IN_PROGRESS,
        WIN,
        DRAW
    }

    public Game() {
        this.board = new Board();
        this.playerX = new Player("Player X", 'X');
        this.playerO = new Player("Player O", 'O');
        this.playerTurn = new PlayerTurn(playerX, playerO);
        this.scoreboard = new Scoreboard(playerX, playerO);
    }

    public GameState playMove(int row, int col) {
        Player current = playerTurn.getCurrentPlayer();
        Move move = new Move(row, col, current);

        if (!board.isValidMove(move)) {
            return GameState.IN_PROGRESS; // caller can treat as "invalid move"
        }

        board.applyMove(move);

        if (board.hasWinFor(current)) {
            scoreboard.recordWin(current);
            return GameState.WIN;
        }

        if (board.isFull()) {
            return GameState.DRAW;
        }

        playerTurn.switchTurn();
        return GameState.IN_PROGRESS;
    }

    public void resetGame() {
        board.reset();
        playerTurn.reset();
    }

    public PlayerTurn getPlayerTurn() {
        return playerTurn;
    }

    public Board getBoard() {
        return board;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
