package Chess.Figure;

import Chess.ChessFigure;

public class Pawn extends ChessFigure {
    boolean isFirstStep;

    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2659' : '\u265f');
        this.isFirstStep = true;
    }

    @Override
    public boolean canMove(int[] xy, Chess.ChessBoard.ChessBoard board) {
        int x1 = xy[0], y1 = xy[1], x2 = xy[2], y2 = xy[3];
        if (this.isColorIsWhite()) {
            if (board.chessBoard[y2][x2] == null && (y1 == 1 && y2 == 3 || y2 - y1 == 1) && (x1 == x2)) {
                return true;
            }
            if (board.chessBoard[y2][x2] != null && y2 - y1 == 1 && Math.abs(x1 - x2) == 1) {
                return true;
            }
        } else {
            if (board.chessBoard[y2][x2] == null && (y1 == 6 && y2 == 4 || y1 - y2 == 1) && (x1 == x2)) {
                return true;
            }
            if (board.chessBoard[y2][x2] != null && y1 - y2 == 1 && Math.abs(x1 - x2) == 1) {
                return true;
            }
        }
        return false;
    }
}
