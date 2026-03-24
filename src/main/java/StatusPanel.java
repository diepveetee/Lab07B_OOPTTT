import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private final JLabel statusLabel;
    private final JLabel scoreLabel;

    public StatusPanel() {
        setLayout(new GridLayout(2, 1));

        statusLabel = new JLabel("Welcome to Tic Tac Toe");
        scoreLabel = new JLabel("Score: Player X = 0 | Player O = 0");

        add(statusLabel);
        add(scoreLabel);
    }

    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    public void updateScoreboard(Scoreboard scoreboard) {
        int xWins = scoreboard.getPlayerX().getWins();
        int oWins = scoreboard.getPlayerO().getWins();
        scoreLabel.setText("Score: Player X = " + xWins + " | Player O = " + oWins);
    }
}
