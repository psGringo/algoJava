package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSq = 0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];
            int diagonalSq = length * length + width * width;
            int area = length * width;

            if (diagonalSq > maxDiagonalSq) {
                maxDiagonalSq = diagonalSq;
                maxArea = area;
            } else if (diagonalSq == maxDiagonalSq && area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}