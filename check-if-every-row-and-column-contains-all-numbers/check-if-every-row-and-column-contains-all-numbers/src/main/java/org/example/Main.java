package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean checkValid(int[][] matrix) {
      int n = matrix.length;
      HashSet<Integer> nums = new HashSet<>();
        //check rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                nums.add(matrix[i][j]);
            }
            if (nums.size() != n) {
                return false;
            }
            nums.clear();
        }

        // check cols
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums.add(matrix[j][i]);
            }
            if (nums.size() != n) {
                return false;
            }
            nums.clear();
        }

        return true;
    }
}