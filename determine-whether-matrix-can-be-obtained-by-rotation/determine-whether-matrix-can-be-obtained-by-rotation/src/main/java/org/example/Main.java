package org.example;


/**
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1}, {1, 1}};
        int[][] target = new int[][]{{0, 1}, {1, 1}};
        findRotation(matrix, target);
    }

    public static boolean findRotation(int[][] mat, int[][] target) {

        int countFullRotationCircle = mat.length + 1;

        for (int i = 0; i <= countFullRotationCircle; i++) {
            int[][] flip = flip(mat); // or maybe transponse + flip
            mat = transpose(flip);
            if (isEqual(mat, target)) {
                return true;
            }
        }

        return false;
    }

    private static int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }

        return transposed;
    }

    private static int[][] flip(int[][] matrix) {
        int[][] flipped = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int[] row = matrix[i];
                flipped[i][j] = row[matrix[0].length - 1 - j];

            }
        }
        return flipped;
    }


    private static boolean isEqual(int[][] mat1, int[][] mat2) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}