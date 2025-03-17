package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/description/
 */
public class Main {
    public static void main(String[] args) {
        processQueries(new int[]{3,1,2,1}, 5);
    }

    public static int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i];

            int index = list.indexOf(x); // O(m) lookup but optimized
            result[i] = index; // Store result

            // Move x to the front in O(1)
            list.remove(index);
            list.add(0, x);
        }

        return result;
    }
}