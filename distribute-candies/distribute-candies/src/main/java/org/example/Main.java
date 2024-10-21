package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/distribute-candies/
 */
public class Main {
    public static void main(String[] args) {
    }
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> candySet = new HashSet<>();
        for (int candy : candyType) {
            candySet.add(candy);
        }
        int count = 0;
        int countCandiesAllowed = candyType.length / 2;
        var iterator = candySet.stream().iterator();
        while (iterator.hasNext() && count < countCandiesAllowed) {
            iterator.next();
            count++;
        }
        return count;
    }
}