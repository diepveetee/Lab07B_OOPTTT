import javax.swing.JButton;

public class TileButton extends JButton {

    private final int row;
    private final int col;

    public TileButton(int row, int col) {
        this.row = row;
        this.col = col;
        setText("");
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setSymbol(char symbol) {
        setText(symbol == ' ' ? "" : String.valueOf(symbol));
    }
}
