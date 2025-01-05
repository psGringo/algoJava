package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        countBinarySubstrings("00110011");
    }


    public static int countBinarySubstrings(String s) {
        // List to store the lengths of consecutive runs
        List<Integer> groupLengths = new ArrayList<>();
        int count = 1;

        // Traverse the string to calculate lengths of consecutive runs
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                groupLengths.add(count);
                count = 1;
            }
        }
        // Add the last group length
        groupLengths.add(count);

        // Count valid substrings
        int result = 0;
        for (int i = 1; i < groupLengths.size(); i++) {
            result += Math.min(groupLengths.get(i - 1), groupLengths.get(i));
        }

        return result;
    }


}