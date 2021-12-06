package Chess;

public abstract class ChessFigure {
    protected boolean colorIsWhite; // true = white, false = black
    protected boolean isOnBoard;  // true = onBoard
    protected char symbol; // '\u2654'..'\u265f';

    public ChessFigure(boolean colorIsWhite, char symbol) {
        this.colorIsWhite = colorIsWhite;
        this.isOnBoard = true;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    public abstract boolean canMove(int[] xy, Chess.ChessBoard.ChessBoard board);

    public boolean isColorIsWhite() {
        return colorIsWhite;
    }
}
