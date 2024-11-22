package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();
        for (int num : arr1) {
            if (map.containsKey(num)) {
                list.add(num);
            } else {
                remaining.add(num);
            }
        }


        List<Integer> result = new ArrayList<>();
        Collections.sort(remaining);
        list.sort((a, b) -> map.get(a) - map.get(b));

        result.addAll(list);
        result.addAll(remaining);
        return result.stream().mapToInt(i -> i).toArray();

    }

}