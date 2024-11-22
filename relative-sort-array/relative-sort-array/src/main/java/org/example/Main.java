package org.example;


import java.util.*;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        // arr1 to hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        // sorting with relative order
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                int count = map.get(arr2[i]);
                for (int j = 0; j < count; j++) {
                    result.add(arr2[i]);
                }
                map.remove(arr2[i]);
            }
        }

        // rest
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
        for (int i = 0; i < arr1.length; i++) {
            if (!set.contains(arr1[i])) {
                pq.add(arr1[i]);
            }
        }

        // get values from pq in correct order
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}


