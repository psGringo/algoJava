package org.example;


import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        clearDigits("cb34");
    }

    public static String clearDigits(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && Character.isDigit(s.charAt(i))) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}