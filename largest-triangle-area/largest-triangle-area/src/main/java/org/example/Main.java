package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     * Shoelace's Formula (also known as Gauss's area formula and surveyor's formula):
     * Area = (1/2) * |x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)|
     *
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        double maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    double nextMaxArea = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
                    maxArea = Math.max(maxArea, nextMaxArea);
                }
            }
        }

        return maxArea;
    }
}