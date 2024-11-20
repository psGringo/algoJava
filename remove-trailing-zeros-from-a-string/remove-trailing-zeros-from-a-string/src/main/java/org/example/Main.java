package org.example;


/**
 * https://leetcode.com/problems/remove-trailing-zeros-from-a-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String removeTrailingZeros(String num) {
        int lastZeroIndex = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
              lastZeroIndex = i;
            } else {
                break;
            }
        }
        return lastZeroIndex == -1 ? num : num.substring(0, lastZeroIndex);
    }
}