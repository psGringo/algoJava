package org.example;


/**
 * https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        k = sum % k;
        if (k == 0) {
            return 0;
        }

    }
}