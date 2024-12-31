//Written by Jason Jiang and Ishan Shukla

public class Knight {
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     * @param row   The current row of the pawn.
     * @param col   The current column of the pawn.
     * @param isBlack   The color of the pawn.
     */
    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Checks if a move to a destination square is legal.
     * @param board     The game board.
     * @param endRow    The row of the destination square.
     * @param endCol    The column of the destination square.
     * @return True if the move to the destination square is legal, false otherwise.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (!board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack)) {
            return false;
        }
        if (Math.abs(row - endRow) + Math.abs(col - endCol) == 3) {
            return true;
        }
        return false;
    }

    private boolean inbounds(int x, int y) {
        if (x < 0 || x > 8 || y < 0 || y > 8) {
            return false;
        }
        return true;
    }
}
