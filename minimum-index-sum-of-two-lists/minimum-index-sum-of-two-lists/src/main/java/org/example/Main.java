package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class Main {
    public static void main(String[] args) {
        findRestaurant(new String[]{"happy", "sad", "good"}, new String[]{"sad", "happy", "good"});
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        PriorityQueue<WordInfo> pq = new PriorityQueue<>((x, y) -> x.sum() - y.sum());
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    pq.add(new WordInfo(list1[i], i + j));
                }
            }
        }

        List<String> res = new ArrayList<>();
        WordInfo wordInfo = pq.peek();
        while (!pq.isEmpty() && pq.peek().sum() == wordInfo.sum()) {
            res.add(pq.poll().word());
        }

        return res.toArray(new String[res.size()]);
    }
}

record WordInfo(String word, int sum) {
}