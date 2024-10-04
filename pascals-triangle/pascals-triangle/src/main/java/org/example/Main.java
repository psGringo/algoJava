package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        doGenerate(numRows, result);
        return result;
    }

    private void doGenerate(int numRows, List<List<Integer>> result) {
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