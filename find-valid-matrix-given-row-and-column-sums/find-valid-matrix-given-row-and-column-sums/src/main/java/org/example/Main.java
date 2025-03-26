package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        for (int row = 0; row < rowSum.length; row++) {
            for (int col = 0; col < colSum.length; col++) {
                int value = Math.min(rowSum[row], colSum[col]);
                matrix[row][col] = value;

                rowSum[row] -= value;
                colSum[col] -= value;
            }
        }
        return matrix;
    }
}