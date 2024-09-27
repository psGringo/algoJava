package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Main {
    public static void main(String[] args) {
        int res = calculate("0-2147483647");
    }


    public static int calculate(String s) {
        String[] tokens = getTokens(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                String operator = tokens[i];
                switch (operator) {
                    case "+" -> stack.push(Integer.parseInt(tokens[i + 1]));
                    case "-" -> stack.push(-Integer.parseInt(tokens[i + 1]));
                    case "*" -> stack.push(stack.pop() * Integer.parseInt(tokens[i + 1]));
                    case "/" -> stack.push(stack.pop() / Integer.parseInt(tokens[i + 1]));
                }
                i++;
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    private static int calcPrimitives(String s) {
        String[] tokens = getTokens(s);
        if (!hasOperators(tokens)) {
            return Integer.parseInt(s.trim());
        }
        Stack<String> stack = new Stack<>();
        String operator = null;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            if (operator != null) {
                stack.push(tokens[i]);
                String secondNum = stack.pop();
                String op = stack.pop();
                String firstNum = stack.pop();
                int localRes = calc(Integer.parseInt(firstNum), Integer.parseInt(secondNum), op);
                stack.push(String.valueOf(localRes));
                operator = null;
            } else {
                stack.push(tokens[i]);
                if (isOperator(tokens[i])) {
                    operator = tokens[i];
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static String calculatePrior(String s) {
        String[] tokens = getTokens(s);
        if (!hasOperators(tokens)) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        String operator = null;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            if (operator != null) {
                stack.push(tokens[i]);
                String secondNum = stack.pop();
                String op = stack.pop();
                String firstNum = stack.pop();
                int localRes = calc(Integer.parseInt(firstNum), Integer.parseInt(secondNum), op);
                stack.push(String.valueOf(localRes));
                operator = null;
            } else {
                stack.push(tokens[i]);
                if (isPriorOperator(tokens[i])) {
                    operator = tokens[i];
                }
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    private static String[] getTokens(String str) {
        str = str.trim();
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                num.append(str.charAt(i));
            } else if (isOperator(Character.toString(str.charAt(i)))) {
                tokens.add(num.toString());
                num.setLength(0); // clear
                tokens.add(Character.toString(str.charAt(i)));
            }
        }
        if (num.length() > 0) {
            tokens.add(num.toString());
        }
        return tokens.toArray(new String[tokens.size()]);
    }


    private static int calc(int firstNum, int secondNum, String op) {
        return switch (op) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            case "/" -> firstNum / secondNum;
            default -> throw new IllegalArgumentException(String.format("Invalid operator: %s", op));
        };
    }

    private static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    private static boolean isPriorOperator(String op) {
        return op.equals("*") || op.equals("/") || op.equals("-");
    }

    private static boolean hasOperators(String[] tokens) {
        for (String token : tokens) {
            if (isOperator(token)) {
                return true;
            }
        }

        return false;
    }

}