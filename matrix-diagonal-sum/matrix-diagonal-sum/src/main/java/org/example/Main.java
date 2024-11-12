package org.example;


/**
 * https://leetcode.com/problems/matrix-diagonal-sum/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < mat.length && j < mat[0].length) {
            sum += mat[i][j];
            i++;
            j++;
        }
        System.out.println(i);
        System.out.println(j);
        i = mat[0].length - 1;
        j = 0;
        while (i >= 0 && j < mat[0].length) {
            if (i != j) {
                sum += mat[i][j];
            }
            i--;
            j++;
        }
        return sum;
    }
}