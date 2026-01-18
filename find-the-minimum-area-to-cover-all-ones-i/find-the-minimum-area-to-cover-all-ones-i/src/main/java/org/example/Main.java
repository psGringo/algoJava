package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public static int minimumArea(int[][] grid) {

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                }
            }
        }

        if (maxRow == Integer.MIN_VALUE || minRow == Integer.MAX_VALUE) {
            return 0;
        }

        return (maxCol - minCol + 1) * (maxRow - minRow + 1);
    }
}