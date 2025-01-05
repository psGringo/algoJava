package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price > minPrice) {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }

            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}