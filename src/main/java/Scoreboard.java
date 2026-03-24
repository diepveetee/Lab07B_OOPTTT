public class Scoreboard {

    private final Player playerX;
    private final Player playerO;

    public Scoreboard(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void recordWin(Player player) {
        player.incrementWins();
    }

    public int getWinsFor(Player player) {
        return player.getWins();
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }
}
