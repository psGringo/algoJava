package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public static int[][] modifiedMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = max;
                }
            }

        }
        return matrix;
    }
}