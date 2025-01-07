package org.example;


/**
 * https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int forwardDistance = (i - startIndex + n) % n;
                int backwardDistance = (startIndex - i + n) % n;
                int distance = Math.min(forwardDistance, backwardDistance);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}