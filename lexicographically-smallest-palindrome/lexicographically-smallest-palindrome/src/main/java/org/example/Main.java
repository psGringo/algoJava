package org.example;


/**
 * https://leetcode.com/problems/lexicographically-smallest-palindrome/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String makeSmallestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] charArr = s.toCharArray();
        while (i <= j) {
            if (charArr[i] != charArr[j]) {
                char minChar = (char) Math.min(s.charAt(i), s.charAt(j));
                charArr[i] = minChar;
                charArr[j] = minChar;
            }

            i++;
            j--;
        }
        return new String(charArr);
    }

}