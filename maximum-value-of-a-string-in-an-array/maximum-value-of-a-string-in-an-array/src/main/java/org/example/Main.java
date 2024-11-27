package org.example;


/**
 * https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
       // maximumValue(new String[]{"5232", "yv", "22", "c", "yawgs", "928", "4003", "2"});
    }


    public int maximumValue(String[] strs) {
        int max = Integer.MIN_VALUE;
        for (String str : strs) {
            if (isOnlyDigits(str)) {
                max = Math.max(max, Integer.parseInt(str, 10));
            } else {
                max = Math.max(max, str.length());
            }
        }
        return max;
    }

    private boolean isOnlyDigits(String str) {
        sum = 0;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}