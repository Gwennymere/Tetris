package game.pieces;

public enum PieceColor {
    BLUE(0, 0, 255),
    GREEN(0, 255, 0),
    RED(255, 0, 0),
    YELLOW(0, 122, 122);

    private int red;
    private int green;
    private int blue;

    private PieceColor(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }
}
