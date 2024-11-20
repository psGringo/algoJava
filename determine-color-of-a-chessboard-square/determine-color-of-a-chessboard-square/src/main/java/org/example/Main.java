package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public static boolean squareIsWhite(String coordinates) {
      return getColor(coordinates).equals(Color.WHITE);
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