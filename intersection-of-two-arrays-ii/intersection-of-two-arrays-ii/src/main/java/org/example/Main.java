package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map2.containsKey(nums1[i])) {
                list.add(nums1[i]);
                int count = map2.getOrDefault(nums1[i], 0) - 1;
                if (count > 0) {
                    map2.put(nums1[i], count);
                } else {
                    map2.remove(nums1[i]);
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}