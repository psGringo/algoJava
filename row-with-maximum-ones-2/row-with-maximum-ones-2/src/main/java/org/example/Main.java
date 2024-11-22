package org.example;


/**
 * https://leetcode.com/problems/row-with-maximum-ones/description/
 */
public class Main {
    public static void main(String[] args) {
        rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}});
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int max = Integer.MIN_VALUE;
        int row = 0;
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                    count += mat[i][j]; // all elements 1 or 0, so we can not check with if
            }
            if (count > max) {
                max = count;
                row = i;
            }
        }
        return new int[]{row, max};
    }
}