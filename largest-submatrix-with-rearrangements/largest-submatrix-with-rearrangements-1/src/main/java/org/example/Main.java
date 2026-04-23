package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("i believe in you!");
    }


    /**
     * Idea of the algorithm
     * 1. Go row by row
     * <p>
     * Treat each row as a possible bottom of the rectangle.
     * <p>
     * 2. Build heights
     * <p>
     * For each column, store:
     * <p>
     * how many consecutive 1s end at this row
     * <p>
     * Rule:
     * <p>
     * if current cell is 0 → height becomes 0
     * if current cell is 1 → height becomes previous height + 1
     * 3. Look only at the current row’s heights
     * <p>
     * Now you know how tall each column can be if the rectangle ends at this row.
     * <p>
     * Example:
     * <p>
     * [3, 1, 3, 2]
     * <p>
     * 4. Sort these heights in descending order
     * <p>
     * Why?
     * <p>
     * Because the problem allows us to rearrange columns.
     * <p>
     * So we can place taller columns together.
     * <p>
     * Example:
     * <p>
     * [3, 3, 2, 1]
     * <p>
     * 5. Try all possible widths
     * <p>
     * Now check:
     * <p>
     * take first 1 column
     * take first 2 columns
     * take first 3 columns
     * ...
     * <p>
     * If you take first k columns:
     * <p>
     * width = k
     * height = height of the shortest among them
     * after sorting, that is the k-th value
     * <p>
     * So:
     * <p>
     * area = sorted[k - 1] * k
     * <p>
     * 6. Update the global maximum
     * <p>
     * For every row, compute the best area.
     * Keep the largest one.
     * <p>
     * Why this works
     * <p>
     * Because after rearranging columns, the only thing that matters is:
     * <p>
     * how many columns have enough height
     * <p>
     * Sorting lets us group the tallest columns together.
     * <p>
     * Full thinking in one line
     * <p>
     * For each row, compute consecutive-1 heights, sort them, try every width, compute area, keep the maximum.
     *
     * @param matrix
     * @return
     */
    public int largestSubmatrix(int[][] matrix) {
        var maxArea = 0;
        var heights = new int[matrix[0].length];

        // for each row
        for (int i = 0; i < matrix.length; i++) {
            fillHeights(matrix, i, heights);
            int[] clonedHeights = heights.clone();
            Arrays.sort(clonedHeights);

            int rectangleArea = clonedHeights[0] * 1;
            maxArea = Math.max(maxArea, rectangleArea);

            for (int j = 0; j < clonedHeights.length; j++) {
                int height = clonedHeights[j];
                int width = clonedHeights.length -j;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }


    private static void fillHeights(int[][] matrix, int row, int[] heights) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] == 1) {
                heights[i]++;
            } else {
                heights[i] = 0;
            }
        }
    }
}