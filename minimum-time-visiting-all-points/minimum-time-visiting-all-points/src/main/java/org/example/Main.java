package org.example;


/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};

        minTimeToVisitAllPoints(points);
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            int rest = 0;
            int diffX = Math.abs(points[i][0] - points[i - 1][0]);
            int diffY = Math.abs(points[i][1] - points[i - 1][1]);
            int diagonalTime = Math.min(diffX, diffY);
            if (diffX != diffY) {
                rest = Math.abs(diffX - diffY);
            }
            time += diagonalTime + rest;
        }
        return time;
    }

}