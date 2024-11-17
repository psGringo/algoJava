package org.example;


import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        map.values().forEach((value) -> set.add(value));
        return set.size() == map.values().size();
    }

}