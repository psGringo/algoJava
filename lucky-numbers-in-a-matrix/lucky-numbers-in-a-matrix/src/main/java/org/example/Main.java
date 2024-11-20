package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] rowMins = new int[matrix.length];
        int[] colMaxs = new int[matrix[0].length];


        int r = 0;
        for (int i = 0; i < matrix.length; i++) {
            rowMins[r] = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                rowMins[r] = Math.min(matrix[i][j], rowMins[r]);
            }
            r++;
        }

        //        System.out.println("row mins:");
//        for (int i = 0; i < rowMins.length; i++) {
//            System.out.print(String.format("%d ", rowMins[i]));
//        }

        int c = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                colMaxs[c] = Math.max(matrix[i][j], colMaxs[c]);
            }
            c++;
        }

//        System.out.println("\n col maxs:");
//        for (int i = 0; i < colMaxs.length; i++) {
//            System.out.print(String.format("%d ", colMaxs[i]));
//        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowMins.length; i++) {
            for (int j = 0; j < colMaxs.length; j++) {
                if (rowMins[i] == colMaxs[j]) {
                    result.add(rowMins[i]);
                }
            }
        }

        return result;
    }

}