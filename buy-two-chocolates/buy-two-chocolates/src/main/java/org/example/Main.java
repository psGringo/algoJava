package org.example;


public class Main {
    public static void main(String[] args) {
        buyChoco(new int[]{98, 54, 6, 34, 66, 63, 52, 39}, 62);
    }

    public static int buyChoco(int[] prices, int money) {
        int min1 = Integer.MAX_VALUE;
        int min1Index = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min1) {
                min1 = Math.min(min1, prices[i]);
                min1Index = i;
            }
        }

        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min2 && i != min1Index) {
                min2 = Math.min(min2, prices[i]);
            }
        }


        int diff = money - (min1 + min2);

        return diff >= 0 ? diff : money;
    }
}