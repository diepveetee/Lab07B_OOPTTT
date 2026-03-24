import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private final Game game;
    private MainWindow mainWindow;

    public Controller(Game game) {
        this.game = game;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof TileButton)) {
            return;
        }

        TileButton btn = (TileButton) e.getSource();
        int row = btn.getRow();
        int col = btn.getCol();

        Game.GameState state = game.playMove(row, col);
        mainWindow.updateBoard(game.getBoard());

        switch (state) {
            case IN_PROGRESS:
                mainWindow.getStatusPanel().setStatus(
                        "Turn: " + game.getPlayerTurn().getCurrentPlayer().getName()
                );
                break;

            case WIN:
                Player winner = game.getPlayerTurn().getCurrentPlayer();
                JOptionPane.showMessageDialog(mainWindow,
                        winner.getName() + " wins!");

                // Update scoreboard display
                mainWindow.getStatusPanel().updateScoreboard(game.getScoreboard());

                game.resetGame();
                mainWindow.updateBoard(game.getBoard());
                break;


            case DRAW:
                JOptionPane.showMessageDialog(mainWindow,
                        "It's a draw!");
                game.resetGame();
                mainWindow.updateBoard(game.getBoard());
                break;
        }
    }
}
