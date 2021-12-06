package Chess.Figure;

import Chess.ChessFigure;

public class Knight extends ChessFigure {


    public Knight(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2658' : '\u265e');

    }

    @Override
    public boolean canMove(int[] xy, Chess.ChessBoard.ChessBoard board) {
        int x1 = xy[0], y1 = xy[1], x2 = xy[2], y2 = xy[3];
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
        return dx == 1 && dy == 2 || dx == 2 && dy == 1;
    }
}
