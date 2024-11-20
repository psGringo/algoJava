package org.example;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        heightChecker(new int[]{1, 1, 4, 2, 1, 3});
    }

    public static int heightChecker(int[] heights) {
        int count = 0;
        int[] sortedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHeights);
        for (int i = 0; i < sortedHeights.length; i++) {
            if (sortedHeights[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}