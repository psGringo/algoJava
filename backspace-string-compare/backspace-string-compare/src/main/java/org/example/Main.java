package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class Main {
    public static void main(String[] args) {
        backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public static boolean backspaceCompare(String s, String t) {
        String s1 = clearFromBackSpaces(s);
        String s2 = clearFromBackSpaces(t);
        return s1.equals(s2);
    }

    private static String clearFromBackSpaces(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == '#') {
                stack.pop();
            } else if (c != '#') {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}