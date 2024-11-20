package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/
 */
public class Main {
    public static void main(String[] args) {
        minLength("ABFCACDB");
    }

    public static int minLength(String s) {
        while (true) {
            boolean x = s.contains("AB");
            boolean y = s.contains("CD");
            if (!x && !y) break;
            if (x) {
                s = s.replaceAll("AB", "");
            }
            if (y) {
                s = s.replaceAll("CD", "");
            }
        }

        return s.length();
    }

    /**
     * Beautiful solution with stack
     *
     * @param s
     * @return
     */
    public int minLength2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char currentChar : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(currentChar);
                continue;
            }

            if (currentChar == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            else if (currentChar == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else {
                stack.push(currentChar);
            }
        }

        return stack.size();
    }

}