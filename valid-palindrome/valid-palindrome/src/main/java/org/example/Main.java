package org.example;


/**
 *  https://leetcode.com/problems/valid-palindrome/submissions/1387038996/
 */
public class Main {
    public static void main(String[] args) {
        boolean res = isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        String prepared = sb.toString().toLowerCase();
        return doCheckIsPalindrome(prepared);
    }

    private static boolean doCheckIsPalindrome(String s) {
        char[] palindrome = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            palindrome[i] = s.charAt(s.length() - 1 - i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != palindrome[i]) {
                return false;
            }
        }

        return true;
    }
}