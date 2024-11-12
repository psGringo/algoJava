package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                 stack.pop();
             } else
             if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                 stack.pop();
             } else
             if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                 stack.pop();
             } else {
                 stack.push(c);
             }

         }
         return stack.isEmpty();
    }

}