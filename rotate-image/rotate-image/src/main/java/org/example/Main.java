package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     * LeetCode 48 — Rotate Image
     *
     * Problem:
     *  Given an n × n matrix, rotate it by 90 degrees clockwise in-place.
     *
     * Approach (Transpose + Reverse Each Row):
     *  1. Transpose the matrix:
     *       Swap matrix[i][j] with matrix[j][i] for all j > i.
     *       This flips the matrix along its main diagonal.
     *  2. Reverse each row:
     *       Swap symmetric elements in each row to achieve a 90° clockwise rotation.
     *
     * Why it works:
     *  - Transposing converts rows into columns.
     *  - Reversing each row reorders columns from left→right to right→left,
     *    completing the clockwise rotation.
     *
     * Example:
     *   Input:
     *     1 2 3
     *     4 5 6
     *     7 8 9
     *   After transpose:
     *     1 4 7
     *     2 5 8
     *     3 6 9
     *   After reversing each row:
     *     7 4 1
     *     8 5 2
     *     9 6 3  ← final rotated matrix
     *
     * Time Complexity:  O(n²)
     * Space Complexity: O(1) (in-place)
     *
     * @param matrix square matrix to be rotated by 90 degrees clockwise
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose (swap matrix[i][j] with matrix[j][i] for j > i)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                int t = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = t;
            }
        }
    }

}