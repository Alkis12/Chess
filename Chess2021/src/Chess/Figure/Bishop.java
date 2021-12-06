package Chess.Figure;

import Chess.ChessFigure;

public class Bishop extends ChessFigure {


    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2657' : '\u265d');

    }

    @Override
    public boolean canMove(int[] xy, Chess.ChessBoard.ChessBoard board) {
        int x1 = xy[0], y1 = xy[1], x2 = xy[2], y2 = xy[3];
        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            int d1 = x1 < x2 ? 1 : -1;
            int d2 = y1 < y2 ? 1 : -1;
            while (x1 != x2 - d1) {
                x1 += d1;
                y1 += d2;
                if (board.chessBoard[y1][x1] != null)
                    return false;
            }
            return true;
        }
        return false;
    }
}
