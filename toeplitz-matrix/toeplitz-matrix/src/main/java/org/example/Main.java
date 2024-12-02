package org.example;


/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class Main {
    public static void main(String[] args) {
        isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}});
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // if topleft partne r i
                if (!isOutOfBound(matrix, i - 1, j - 1)) {
                    if (matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isOutOfBound(int[][] matrix, int row, int col) {
        return row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[0].length - 1;
    }
}