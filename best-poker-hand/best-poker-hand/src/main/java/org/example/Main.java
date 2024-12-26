package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/best-poker-hand/
 */
public class Main {
    public static void main(String[] args) {
        bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'});
    }

    public static String bestHand(int[] ranks, char[] suits) {

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            rankMap.put(ranks[i], rankMap.getOrDefault(ranks[i], 0) + 1);
        }

        HashMap<Character, Integer> suitsMap = new HashMap<>();
        for (int i = 0; i < suits.length; i++) {
            suitsMap.put(suits[i], suitsMap.getOrDefault(suits[i], 0) + 1);
        }


        if (isFlush(suitsMap)) {
            return "Flush";
        } else if (isRanksEqualToCount(rankMap, 3)) {
            return "Three of a Kind";
        } else if (isRanksEqualToCount(rankMap, 2)) {
            return "Pair";
        } else {
            return "High Card";
        }
    }

    private static boolean isFlush(HashMap<Character, Integer> suits) {
        return suits.keySet().size() == 1;
    }

    private static boolean isRanksEqualToCount(HashMap<Integer, Integer> ranks, int resultCount) {
        var iterator = ranks.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() >= resultCount) {
                return true;
            }
        }
        return false;
    }
}