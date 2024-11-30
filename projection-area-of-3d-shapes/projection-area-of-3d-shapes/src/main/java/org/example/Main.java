package org.example;


public class Main {
    public static void main(String[] args) {
        projectionArea(new int[][]{{1, 2}, {3, 4}});
    }

    public static int projectionArea(int[][] grid) {
        // xy
        int xySum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    xySum++;
                }
            }
        }

        // zx
        int zxSum = 0;
        for (int i = 0; i < grid.length; i++) {
            int zxMax = Integer.MIN_VALUE;
            for (int j = 0; j < grid[0].length; j++) {
                zxMax = Math.max(zxMax, grid[i][j]);
            }
            zxSum += zxMax;
        }

        // yzMax
        int yzSum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int yzMax = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                yzMax = Math.max(yzMax, grid[j][i]);
            }
            yzSum += yzMax;
        }

        return xySum + zxSum + yzSum;
    }
}