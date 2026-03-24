import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final TileButton[][] buttons;
    private final StatusPanel statusPanel;
    private final JButton quitButton;

    public MainWindow(Game game, Controller controller) {
        super("OOP Tic Tac Toe");

        buttons = new TileButton[3][3];
        statusPanel = new StatusPanel();
        quitButton = new JButton("Quit");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                TileButton btn = new TileButton(r, c);
                btn.addActionListener(controller);
                buttons[r][c] = btn;
                boardPanel.add(btn);
            }
        }

        //Ran out of time to add in dialoguebox to confirm exit


        quitButton.addActionListener(e -> System.exit(0));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(statusPanel, BorderLayout.CENTER);
        bottomPanel.add(quitButton, BorderLayout.EAST);

        add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(500, 500));
        pack();

        setVisible(true);
    }

    public void updateBoard(Board board) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setSymbol(board.getCell(r, c));
            }
        }
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }
}
