package org.example;


public class Main {
    public static void main(String[] args) {
        construct2DArray(new int[]{1, 2}, 1, 1);
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }

        int[][] result = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[k++];
            }
        }

        return result;
    }
}