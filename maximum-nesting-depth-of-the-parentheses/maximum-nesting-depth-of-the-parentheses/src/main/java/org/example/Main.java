package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int depth = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                ++depth;
            }
            if (!stack.empty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
                --depth;
            }

            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }

}