package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> res = getRow(3);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        doGenerate(rowIndex + 1, result);
        return result.get(result.size() - 1);
    }

    private static void doGenerate(int numRows, List<List<Integer>> result) {
        if (numRows <= 0) {
            return;
        }
        if (numRows == 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            result.add(row);
            return;
        }
        doGenerate(numRows - 1, result);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            row.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        row.add(1);
        result.add(row);
    }

}