package org.example;


import java.util.*;

/**
 * https://leetcode.com/problems/remove-outermost-parentheses/description/
 */
public class Main {
    public static void main(String[] args) {
        removeOuterParentheses(new String("(()())(())"));
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Integer> indexesToDelete = new HashSet<>();
        int leftIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.peek() == ')') {
                stack.pop();
                stack.pop();
                if (stack.isEmpty()) {
                    indexesToDelete.add(leftIndex);
                    indexesToDelete.add(i);
                    if (i < s.length() - 1) {
                        leftIndex = i + 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToDelete.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}