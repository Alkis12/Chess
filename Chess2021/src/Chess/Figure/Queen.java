package Chess.Figure;
import Chess.ChessFigure;
public class Queen extends ChessFigure {


    public Queen(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b');

    }

    @Override
    public boolean canMove(int[]xy, Chess.ChessBoard.ChessBoard board) {
        int x1 = xy[0], y1 = xy[1], x2 = xy[2], y2 = xy[3];
        if (xy[0] == xy[2] || xy[1] == xy[3]) {
            System.out.println("good");
            if (xy[0] == xy[2]) {
                for (int i = Math.min(xy[1], xy[3]) + 1; i < Math.max(xy[1], xy[3]); i++) {
                    if (board.chessBoard[i][xy[0]] != null)
                        return false;
                }
            } else {
                for (int i = Math.min(xy[0], xy[2]) + 1; i < Math.max(xy[0], xy[2]); i++) {
                    if (board.chessBoard[xy[1]][i] != null)
                        return false;
                }
            }
            return true;
        } else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            int d1 = x1 < x2 ? 1 : -1;
            int d2 = y1 < y2 ? 1 : -1;
            while (x1 != x2 - d1) {
                x1 += d1;
                y1 += d2;
                if (board.chessBoard[y1][x1] != null)
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
