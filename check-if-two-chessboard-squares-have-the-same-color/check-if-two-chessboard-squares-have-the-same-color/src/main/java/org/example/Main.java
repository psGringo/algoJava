package org.example;


/**
 * https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/description/
 */
public class Main {
    public static void main(String[] args) {
        checkTwoChessboards("a1", "c3");
    }

    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return getColor(coordinate1).equals(getColor(coordinate2));
    }

    private static Color getColor(String coordinate) {
        Color startColor = (int) coordinate.charAt(0) % 2 != 0 ? Color.BLACK : Color.WHITE;
        if (startColor == Color.BLACK) {
            return Character.getNumericValue(coordinate.charAt(1)) % 2 == 0 ? Color.WHITE : Color.BLACK;
        } else {
            return Character.getNumericValue(coordinate.charAt(1)) % 2 == 0 ? Color.BLACK : Color.WHITE;
        }
    }

}

enum Color {
    BLACK, WHITE
}