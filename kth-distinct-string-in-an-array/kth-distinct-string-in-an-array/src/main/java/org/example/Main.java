package org.example;


import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                count++;
                if (count == k) {
                    return arr[i];
                }
            }
        }
        return "";
    }
}