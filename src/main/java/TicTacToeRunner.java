public class TicTacToeRunner {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Game game = new Game();

            // Create controller placeholder
            Controller controller = new Controller(game);

            // Create window and pass controller into it
            MainWindow mainWindow = new MainWindow(game, controller);

            // give controller access to it
            controller.setMainWindow(mainWindow);

            // Initial stat
            mainWindow.getStatusPanel().setStatus(
                    "Turn: " + game.getPlayerTurn().getCurrentPlayer().getName()
            );
        });
    }
}

