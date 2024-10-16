package org.example;


/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
        return doGuessNumber(1, n);
    }

    public int doGuessNumber(int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        System.out.println(mid);
        if (guess(mid) == 0) {
            return mid;
        } else if (guess(mid) == -1) {
            return doGuessNumber(lo, mid - 1);
        } else if (guess(mid) == 1) {
            return doGuessNumber(mid + 1, hi);
        }
        return -1;
    }

    private int guess(int n) {
        return 123;
    }
}