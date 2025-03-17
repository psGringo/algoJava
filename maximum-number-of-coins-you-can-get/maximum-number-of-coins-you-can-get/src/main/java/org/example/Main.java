package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }


//🔹 Optimal Strategy
//    Sorting the Array
//    To maximize the coins you collect, notice that:
//
//    The first player always picks the biggest pile.
//    You always pick the second biggest.
//    The third player always picks the smallest.
//    To maximize your coins, we should:
//
//    Sort piles in descending order (biggest first).
//    Skip every third pile (since it goes to the third player).
//    Pick every second pile (since you pick second).


    /**
     *  https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/
     *
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {

        Arrays.sort(piles);
        int n = piles.length / 3;

        int res = 0;
        for (int i = piles.length - 2; i >= n; i-=2) {
            res += piles[i];
        }

        return res;
    }
}