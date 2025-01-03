package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        tictactoe(moves);
    }

    public static String tictactoe(int[][] moves) {
        String[][] grid = new String[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(grid[i], "");
        }

        String res = null;
        boolean isATurn = true;
        int countMoves = 0;
        for (int i = 0; i < moves.length; i++) {
            grid[moves[i][0]][moves[i][1]] = isATurn ? "X" : "0";
            isATurn = !isATurn;
            countMoves++;
            res = isSomebodyWon(moves, i, grid);
            if (res != null) {
                break;
            }
        }

        if (countMoves == 9 && res == null) {
            return "Draw";
        }

        if (countMoves < 9 && res == null) {
            return "Pending";
        }

        return res;
    }

    private static String isSomebodyWon(int[][] moves, int currentMove, String[][] grid) {

        // check rows
        for (int i = 0; i < grid.length; i++) {
            int countX = 0;
            int countZero = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == "X") {
                    countX++;
                }
                if (grid[i][j] == "0") {
                    countZero++;
                }
            }
            if (countX == 3) return "A";
            if (countZero == 3) return "B";
        }

        // check cols
        for (int i = 0; i < grid[0].length; i++) {
            int countX = 0;
            int countZero = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == "X") {
                    countX++;
                }
                if (grid[j][i] == "0") {
                    countZero++;
                }
            }
            if (countX == 3) return "A";
            if (countZero == 3) return "B";
        }

        // checkDiagonals
        if (grid[0][0] == "X" && grid[1][1] == "X" && grid[2][2] == "X") return "A";
        if (grid[0][2] == "X" && grid[1][1] == "X" && grid[2][0] == "X") return "A";

        if (grid[0][0] == "0" && grid[1][1] == "0" && grid[2][2] == "0") return "B";
        if (grid[0][2] == "0" && grid[1][1] == "0" && grid[2][0] == "0") return "B";

        return null;
    }
}