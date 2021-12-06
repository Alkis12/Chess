package Chess.ChessBoard;

import Chess.ChessFigure;
import Chess.Figure.*;

public class ChessBoard {
    public ChessFigure[][] chessBoard;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    public ChessBoard() {
        this.chessBoard = new ChessFigure[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[1][i] = new Pawn(true);
            chessBoard[6][i] = new Pawn(false);
        }
        chessBoard[0][0] = new Rook(true);
        chessBoard[0][7] = new Rook(true);
        chessBoard[0][1] = new Knight(true);
        chessBoard[0][6] = new Knight(true);
        chessBoard[0][2] = new Bishop(true);
        chessBoard[0][5] = new Bishop(true);
        chessBoard[7][0] = new Rook(false);
        chessBoard[7][7] = new Rook(false);
        chessBoard[7][1] = new Knight(false);
        chessBoard[7][6] = new Knight(false);
        chessBoard[7][2] = new Bishop(false);
        chessBoard[7][5] = new Bishop(false);
        chessBoard[0][3] = new King(true);
        chessBoard[7][3] = new King(false);
        chessBoard[0][4] = new Queen(true);
        chessBoard[7][4] = new Queen(false);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Pawn falsePawn = new Pawn(true);
        for (int i = 0; i < 8; i++) {
            result.append(8 - i).append("|");
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1)
                    result.append(ANSI_PURPLE_BACKGROUND);
                else
                    result.append(ANSI_WHITE_BACKGROUND);
                ChessFigure cf = chessBoard[7 - i][j];
                result.append(cf != null ? cf : ((i + j) % 2 == 1 ? ANSI_PURPLE : ANSI_WHITE) + falsePawn + ANSI_RESET);
            }
            result.append(ANSI_RESET + "\n");
        }
        return result.toString();
    }

    public boolean canMove(int[] xy, boolean color) {
        if (chessBoard[xy[1]][xy[0]] == null || chessBoard[xy[3]][xy[2]] != null && chessBoard[xy[3]][xy[2]].isColorIsWhite() == chessBoard[xy[1]][xy[0]].isColorIsWhite() || (xy[3] == xy[1] && xy[2] == xy[0]) || chessBoard[xy[1]][xy[0]].isColorIsWhite() != color)
            return false;
        else return chessBoard[xy[1]][xy[0]].canMove(xy, this);
    }

    public boolean isShah(boolean color_is_white) {
        King false_King = new King(color_is_white);
        int yking = 0, xking = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] == false_King) {
                    yking = i;
                    xking = j;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] != null && chessBoard[i][j].isColorIsWhite() != color_is_white) {
                    int[] xy = {i, j, xking, yking};
                    if (this.canMove(xy, !color_is_white)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isMat() {
        if (!this.isShah(true) && !this.isShah(false))
            return false;
        return true;
    }

    public void move(int[] xy) {
        chessBoard[xy[3]][xy[2]] = chessBoard[xy[1]][xy[0]];
        chessBoard[xy[1]][xy[0]] = null;
    }
}
