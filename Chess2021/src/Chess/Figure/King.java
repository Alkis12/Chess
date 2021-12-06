package Chess.Figure;

import Chess.ChessFigure;

public class King extends ChessFigure {

    public King(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2654' : '\u265a');

    }

    @Override
    public boolean canMove(int[] xy, Chess.ChessBoard.ChessBoard board) {
        if (Math.abs(xy[0] - xy[2]) <= 1 && Math.abs(xy[1] - xy[3]) <= 1)
            return true;
        int x1 = xy[0], y1 = xy[1], x2 = xy[2], y2 = xy[3];
        return false;
    }
}
