package org.example;


/**
 * https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{5, 8, 8, 4, 7, 2, 3, 4, 3, 10}, {8, 7, 9, 1, 3, 4, 2, 6, 6, 9}, {6, 2, 10, 10, 4, 6, 3, 4, 1, 1}};
        areSimilar(mat, 3);
    }

    public static boolean areSimilar(int[][] mat, int k) {
        if (k != 1) {
            int remainder = k % mat[0].length;
            k = remainder;
        }

        if (k == 0) {
            return true;
        }

        int[][] shiftedMatrix = shiftMatrix(mat, k);
        return isMatrixesAreEqual(mat, shiftedMatrix) ? true : false;
    }

    private static int[][] shiftMatrix(int[][] mat, int k) {
        int[][] shiftedMatrix = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            if (i % 2 == 0) {
                // evenRows shift to the left
                shiftedMatrix[i] = shiftLeft(mat[i], k);
            } else {
                // oddRows shift to the right
                shiftedMatrix[i] = shiftRight(mat[i], k);
            }
        }

        return shiftedMatrix;

    }

    private static int[] shiftLeft(int[] row, int k) {
        int[] res = new int[row.length];
        for (int i = 0; i < res.length; i++) {
            int newIndex = i - k;
            if (newIndex < 0) {
                int diff = 0 - newIndex;
                newIndex = res.length - 1 - (diff - 1);
            }
            res[newIndex] = row[i];
        }
        return res;
    }

    private static int[] shiftRight(int[] row, int k) {
        int[] res = new int[row.length];
        for (int i = 0; i < res.length; i++) {
            int newIndex = i + k;
            if (newIndex > row.length - 1) {
                int diff = newIndex - (row.length - 1);
                newIndex = 0 + (diff - 1);
            }
            res[newIndex] = row[i];
        }
        return res;
    }

    private static boolean isMatrixesAreEqual(int[][] mat1, int[][] mat2) {
        if (mat1.length != mat2.length) {
            return false;
        }
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
