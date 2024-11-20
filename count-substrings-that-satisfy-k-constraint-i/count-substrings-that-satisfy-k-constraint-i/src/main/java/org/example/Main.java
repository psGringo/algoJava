package org.example;


/**
 * https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countKConstraintSubstrings(String s, int k) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                int bitCount = 0;
                int zeroCount = 0;
                for (int m = i; m <= j; m++) {
                    if (chars[m] == '0') {
                        zeroCount++;
                    } else if (chars[m] == '1') {
                        bitCount++;
                    }
                }
                if ((zeroCount <= k) || (bitCount <= k)) {
                    count++;
                }
            }
        }


        return count;
    }
}