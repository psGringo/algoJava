package org.example;


/**
 * https://leetcode.com/problems/arranging-coins/submissions/1386565688/
 */
public class Main {
    public static void main(String[] args) {
        int countRows = arrangeCoins(8);
    }

    public static int arrangeCoins(int n) {
        int rowNumber = 0;
        int coinsNeeded = 0;
        while (n > 0) {
            ++coinsNeeded;
            if (n > coinsNeeded) {
                n = n - coinsNeeded;
                ++rowNumber;
            } else if (n == coinsNeeded) {
                n = n - coinsNeeded;
                return ++rowNumber;
            } else if (n < coinsNeeded) {
                return rowNumber;
            }
        }

        return rowNumber;
    }
}