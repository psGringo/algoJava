package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public static int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                int numLength = String.valueOf(grid[j][i]).length();
                max = Math.max(numLength, max);
            }
            res[i] = max;
        }

        return res;
    }
}