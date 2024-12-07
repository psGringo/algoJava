package org.example;


public class Main {
    public static void main(String[] args) {
        int[][] brackets = new int[][]{{3, 50}, {7, 10}, {12, 25}};
        calculateTax(brackets, 10);
    }

    public static double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int taxSum = brackets[0][0];
        double percent = brackets[0][1] / 100.0;
        if (income > taxSum) {
            income -= taxSum;
            res += taxSum * percent;
        } else {
            res += income * percent;
            return res;
        }


        for (int i = 1; i < brackets.length; i++) {
            taxSum = brackets[i][0] - brackets[i - 1][0];
            percent = brackets[i][1] / 100.0;
            if (income > taxSum) {
                income -= taxSum;
                res += taxSum * percent;
            } else {
                res += income * percent;
                return res;
            }
        }

        return res;
    }
}