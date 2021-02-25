package game.pieces;

public class PieceInfo {
    private boolean isOccupied = false;
    private PieceColor pieceColor;

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setPiece(PieceColor color) {
        pieceColor = color;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }
}
