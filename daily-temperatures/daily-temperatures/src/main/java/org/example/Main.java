package org.example;


import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Temperature> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().temperature()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek().index() - i;
            }
            stack.push(new Temperature(i, temperatures[i]));
        }
        return result;
    }
}

record Temperature(int index, int temperature) {
}

