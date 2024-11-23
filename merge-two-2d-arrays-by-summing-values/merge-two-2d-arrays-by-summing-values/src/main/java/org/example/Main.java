package org.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
 */
public class Main {
    public static void main(String[] args) {
        mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}});
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i][0], nums1[i][1]);
        }
        for (int i = 0; i < nums2.length; i++) {
            var prev = map.getOrDefault(nums2[i][0], 0);
            map.put(nums2[i][0], prev + nums2[i][1]);
        }

        Map.Entry<Integer, Integer>[] entriesArray =
                (Map.Entry<Integer, Integer>[]) map.entrySet().toArray(new Map.Entry<?, ?>[map.size()]);

        Arrays.sort(entriesArray, (x, y) -> x.getKey() - y.getKey());

        for (int i = 0; i < entriesArray.length; i++) {}

        int[][] result = new int[entriesArray.length][2];
        for (int i = 0; i < entriesArray.length; i++) {
            result[i][0] = entriesArray[i].getKey();
            result[i][1] = entriesArray[i].getValue();
        }

        return result;
    }
}