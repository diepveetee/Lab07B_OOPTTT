public class PlayerTurn {

    private final Player playerX;
    private final Player playerO;
    private Player current;

    public PlayerTurn(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.current = playerX;
    }

    public Player getCurrentPlayer() {
        return current;
    }

    public void switchTurn() {
        current = (current == playerX) ? playerO : playerX;
    }

    public void reset() {
        current = playerX;
    }
}

