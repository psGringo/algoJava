package org.example;


/**
 * https://leetcode.com/problems/check-if-grid-satisfies-conditions/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check the cell below
                if (i < m - 1 && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                // Check the cell to the right
                if (j < n - 1 && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}