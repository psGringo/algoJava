package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/description/
 */
public class Main {
    public static void main(String[] args) {
        calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"});
    }

    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            switch (operation) {
                case "C" -> stack.pop();
                case "D" -> stack.push(stack.peek() * 2);
                case "+" -> {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1);
                    stack.push(num2);
                    stack.push(num1 + num2);
                }
                default -> stack.push(Integer.parseInt(operation));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}