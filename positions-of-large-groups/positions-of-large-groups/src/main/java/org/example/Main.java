package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;

        for (int i = 0; i <= s.length(); i++) {
            // Check if the group ends (or the string ends)
            if (i == s.length() || s.charAt(i) != s.charAt(start)) {
                if (i - start >= 3) {
                    // Add the group interval to the result
                    List<Integer> group = new ArrayList<>();
                    group.add(start);
                    group.add(i - 1);
                    result.add(group);
                }
                // Update start for the next group
                start = i;
            }
        }

        return result;
    }
}