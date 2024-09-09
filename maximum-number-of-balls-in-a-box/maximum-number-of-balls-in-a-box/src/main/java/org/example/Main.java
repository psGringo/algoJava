package org.example;

import java.util.HashMap;


/**
 * https://leetcode.com/problems/maximum-number-of-balls-in-a-box/submissions/1384153906/
 */
public class Main {
    public static void main(String[] args) {

        int res = countBalls(1, 10);
    }

    public static int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {

            String numStr = String.valueOf(i);

            int sumDigits = 0;
            for (int j = 0; j < numStr.length(); j++) {
                sumDigits += Character.digit(numStr.charAt(j), 10);

            }

            int count = map.getOrDefault(sumDigits, 0);

            map.put(sumDigits, ++count);

        }

        int maxCount = 0;

        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue().intValue() > maxCount) {
                maxCount = entry.getValue();
            }
        }

        return maxCount;
    }

}