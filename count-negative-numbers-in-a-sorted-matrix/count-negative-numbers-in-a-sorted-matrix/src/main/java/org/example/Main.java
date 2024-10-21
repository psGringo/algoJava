package org.example;


/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[9][9];
        grid[0] = new int[]{8, -2, -2, -2, -4, -5, -5};
        grid[1] = new int[]{-2, -3, -3, -4, -4, -5, -5};
        grid[2] = new int[]{-2, -5, -5, -5, -5, -5, -5};
        grid[3] = new int[]{-3, -5, -5, -5, -5, -5, -5};
        grid[4] = new int[]{-5, -5, -5, -5, -5, -5, -5};
        grid[5] = new int[]{-5, -5, -5, -5, -5, -5, -5};
        grid[6] = new int[]{-5, -5, -5, -5, -5, -5, -5};
        grid[7] = new int[]{-5, -5, -5, -5, -5, -5, -5};
        grid[8] = new int[]{-5, -5, -5, -5, -5, -5, -5};

        countNegatives(grid);
    }

    // TODO Додебажить, по каждому ряду ищем бинарным поиском первое отрицательное число
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int firstIndex = getFirstNegativeBinary(row, 0, row.length - 1);
            if (firstIndex >= 0) {
                count += row.length - firstIndex;
            }
        }
        return count;
    }

    private static boolean g(int[] nums, int numIndex) {
        return nums[numIndex] < 0;
    }

    private static int getFirstNegativeBinary(int[] nums, int lo, int hi) {

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (g(nums, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo < nums.length && lo >= 0 && nums[lo] < 0) {
            return lo;
        }

        return -1;
    }
}