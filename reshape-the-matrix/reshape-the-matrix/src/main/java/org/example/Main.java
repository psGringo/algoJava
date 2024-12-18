package org.example;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reshape-the-matrix/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        matrixReshape(matrix, 2, 4);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (exitCondition(mat, r, c)) {
            return mat;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                queue.offer(mat[i][j]);
            }
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.poll();
            }
        }

        return res;
    }

    private static boolean exitCondition(int[][] matrix, int r, int c) {
        return (matrix.length * matrix[0].length != r * c);
    }
}