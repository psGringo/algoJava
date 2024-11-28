package org.example;


/**
 * https://leetcode.com/problems/island-perimeter/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    private final int VISITED = -1;
    private final int ISLAND = 1;
    private final int WATER = 0;

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ISLAND) {
                    perimeter = perimeter + dfs(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (isOutOfBounds(grid, row, col) || grid[row][col] == WATER) {
            return 1;
        }
        if (grid[row][col] == VISITED) {
            return 0;
        }
        grid[row][col] = VISITED;

        return dfs(grid, row + 1, col) + dfs(grid, row - 1, col)
                + dfs(grid, row, col - 1) + dfs(grid, row, col + 1);
    }

    private boolean isOutOfBounds(int[][] grid, int row, int col) {
        boolean rows = row < 0 || row > grid.length - 1;
        boolean cols = col < 0 || col > grid[0].length - 1;
        return rows || cols;
    }
}