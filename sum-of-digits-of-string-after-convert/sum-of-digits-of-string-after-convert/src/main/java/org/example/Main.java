package org.example;


/**
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 */
public class Main {
    public static void main(String[] args) {
        getLucky("zbax", 2);
    }

    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((int) (s.charAt(i) - 'a' + 1));
        }
        String numsString = sb.toString();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (int j = 0; j < numsString.length(); j++) {
                int digit = Character.digit(numsString.charAt(j), 10);
                sum += digit;
            }
            numsString = String.valueOf(sum);
        }
        return sum;
    }
}