package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];

        matrix[0] = new int[]{1, 1, 0, 0, 0};
        matrix[1] = new int[]{1, 1, 1, 1, 0};
        matrix[2] = new int[]{1, 0, 0, 0, 0};
        matrix[3] = new int[]{1, 1, 0, 0, 0};
        matrix[4] = new int[]{1, 1, 1, 1, 1};
        kWeakestRows(matrix, 3);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        R[] rows = new R[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int countSoldiers = 0;
            int indexLastSoldier = binarySearchForDescArr(row, 1);
            if (indexLastSoldier >= 0) {
                countSoldiers = indexLastSoldier + 1;
            }
            rows[i] = new R(countSoldiers, i);
        }

        Arrays.sort(rows, (x, y) -> {
            if (x.numSolders() != y.numSolders()) {
                return x.numSolders() - y.numSolders();
            } else {
                return x.index() - y.index();
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rows[i].index();
        }
        return result;
    }

    private static int binarySearchForDescArr(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                lo = mid + 1; // changed here
            } else {
                hi = mid - 1; // and here
            }
        }

        if (hi >= 0 && hi < nums.length && nums[hi] == target) {
            return hi; // and returning hi
        }

        return -1;
    }
}

record R(int numSolders, int index) {
}