package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/description/
 */
public class Main {
    public static void main(String[] args) {
        arrayRankTransform(new int[]{40, 10, 20, 30});
    }

    public static int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        NumInfo[] arrInfo = new NumInfo[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInfo[i] = new NumInfo(arr[i], i);
        }
        Arrays.sort(arrInfo, (x, y) ->
                x.value() - y.value()
        );
        int rank = 1;
        int[] ranks = new int[arr.length];
        ranks[arrInfo[0].index()] = rank;
        for (int i = 1; i < arrInfo.length; i++) {
            if (arrInfo[i].value() > arrInfo[i - 1].value()) {
                ranks[arrInfo[i].index()] = ++rank;
            } else {
                ranks[arrInfo[i].index()] = rank;
            }
        }
        return ranks;
    }
}

record NumInfo(int value, int index) {
}