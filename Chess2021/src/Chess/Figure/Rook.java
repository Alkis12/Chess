package Chess.Figure;

import Chess.ChessFigure;

public class Rook extends ChessFigure {
    public Rook(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2656' : '\u265c');

    }

    @Override
    public boolean canMove(int[] xy, Chess.ChessBoard.ChessBoard board) {
        if (xy[0] == xy[2] || xy[1] == xy[3]) {
            System.out.println("good");
            if (xy[0] == xy[2]) {
                for (int i = Math.min(xy[1], xy[3])+1; i < Math.max(xy[1], xy[3]); i++) {
                    if (board.chessBoard[i][xy[0]] != null)
                        return false;
                }
            }
            else {
                for (int i = Math.min(xy[0], xy[2])+1; i < Math.max(xy[0], xy[2]); i++) {
                    if (board.chessBoard[xy[1]][i] != null)
                        return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
