package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-similar-items/description/
 */
public class Main {
    public static void main(String[] args) {
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};

        mergeSimilarItems(items1, items2);
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            int item1Weight = map.getOrDefault(items2[i][0], 0);
            map.put(items2[i][0], item1Weight + items2[i][1]);
        }

        List<Integer> sortedKeys = map.keySet().stream().sorted().toList();
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < sortedKeys.size(); i++) {
            List<Integer> list = new ArrayList<>();
            list.add(sortedKeys.get(i));
            list.add(map.get(sortedKeys.get(i)));
            res.add(list);
        }

        return res;
    }
}