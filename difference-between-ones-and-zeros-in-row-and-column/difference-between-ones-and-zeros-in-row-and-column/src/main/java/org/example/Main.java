package org.example;


public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1},
                {1, 0, 1},
                {0, 0, 1}
        };
        onesMinusZeros(grid);
    }

    /**
     * Optimal solution
     *
     * @param grid
     * @return
     */
    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length; int n = grid[0].length;

        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        int[] rowZeros = new int[m];
        int[] colZeros = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowOnes[i]++;
                    colOnes[j]++;
                } else {
                    rowZeros[i]++;
                    colZeros[i]++;
                }
            }
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = rowOnes[i] + colOnes[j] - rowZeros[i] - colZeros[j];
            }
        }

        return result;
    }


    /**
     * my first solution
     *
     *
     * https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/submissions/1577746995/
     *
     * @param grid
     * @return
     */
    public static int[][] onesMinusZeros2(int[][] grid) {
        // rows
        int[][] rowStatistics = new int[grid.length][2];
        int[][] colStatistics = new int[grid[0].length][2];

        for (int i = 0; i < grid.length; i++) {
            int countOnes = 0;
            int countZeros = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    countZeros++;
                } else if (grid[i][j] == 1) {
                    countOnes++;
                }
            }

            rowStatistics[i][0] = countZeros;
            rowStatistics[i][1] = countOnes;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int countOnes = 0;
            int countZeros = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    countZeros++;
                } else if (grid[j][i] == 1) {
                    countOnes++;
                }
            }

            colStatistics[i][0] = countZeros;
            colStatistics[i][1] = countOnes;
        }

        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = rowStatistics[i][1] + colStatistics[j][1] - rowStatistics[i][0] - colStatistics[j][0];
            }
        }

        return result;
    }
}