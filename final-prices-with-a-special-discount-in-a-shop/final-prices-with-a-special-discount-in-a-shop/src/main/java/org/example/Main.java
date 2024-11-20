package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
 */
public class Main {
    public static void main(String[] args) {
        finalPrices(new int[]{8, 4, 6, 2, 3});
    }

    /**
     * Monotonic stack task
     *
     * @param prices
     * @return
     */
    public static int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            // remove non monotonic values
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            int nextLowerValue = 0;
            if (!stack.isEmpty()) {
                nextLowerValue = stack.peek();
            }
            finalPrices[i] =prices[i] - nextLowerValue;
            stack.push(prices[i]);
        }
        return finalPrices;
    }
}