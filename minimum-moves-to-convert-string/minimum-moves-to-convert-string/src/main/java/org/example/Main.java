package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int minimumMoves(String s) {
        int moves = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                // Flip the current 'X' and the next two characters (if they exist)
                moves++;
                i += 3; // Skip the next 2 characters since they are flipped
            } else {
                i++; // Move to the next character
            }
        }

        return moves;
    }
}