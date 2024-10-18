package org.example;


/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
public class Main {
    public static void main(String[] args) {

    }
    // TODO Додебажить, по каждому ряду ищем бинарным поиском первое отрицательное число
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int firstIndex = getFirstNegativeBinary(row, 0, row.length - 1);
            if (firstIndex >= 0) {
                count = row.length - firstIndex;
            }
        }
        return count;
    }

    private int getFirstNegativeBinary(int[] row, int lo, int hi) {
        if (hi < lo) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        System.out.println(mid - 1);
        if (row[mid] < 0 && row[mid - 1] > 0) {
            return mid;
        } else if (row[mid] > 0 && row[mid - 1] > 0) {
            return getFirstNegativeBinary(row, mid + 1, hi);
        } else if (row[mid] < 0 && row[mid - 1] < 0) {
            return getFirstNegativeBinary(row, lo, mid - 1);
        }
        return -1;
    }
}