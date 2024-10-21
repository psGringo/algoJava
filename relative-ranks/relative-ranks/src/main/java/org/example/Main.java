package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


/**
 * https://leetcode.com/problems/relative-ranks/description/
 */
public class Main {
    public static void main(String[] args) {
        findRelativeRanks(new int[]{5, 4, 3, 2, 1});
    }

    public static String[] findRelativeRanks(int[] score) {
        Integer[] boxed = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, Collections.reverseOrder());
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < boxed.length; i++) {
            if (i == 0) {
                map.put(boxed[i], "Gold Medal");
            } else if (i == 1) {
                map.put(boxed[i], "Silver Medal");
            } else if (i == 2) {
                map.put(boxed[i], "Bronze Medal");
            } else {
                map.put(boxed[i], String.valueOf(i + 1));
            }
        }

        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            res[i] = map.get(score[i]);
        }

        return res;
    }
}