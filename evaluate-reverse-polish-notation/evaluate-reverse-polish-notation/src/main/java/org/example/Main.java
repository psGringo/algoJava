package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            stack.push(token);
            if (isOperator(token)) {
                String operator = stack.pop();
                int secondNum = Integer.parseInt(stack.pop());
                int firstNum = Integer.parseInt(stack.pop());
                String res = calc(firstNum, secondNum, operator).toString();
                stack.push(res);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private Integer calc(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException(String.format("Unknown operator '%s'", op));
        };
    }

    private boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

}