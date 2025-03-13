package org.example;


/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n]; // Maximum height for each row
        int[] colMax = new int[n]; // Maximum height for each column

        // Find the max height in each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }

        // Find the max height in each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        // Calculate the sum of possible height increases
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return sum;
    }
}