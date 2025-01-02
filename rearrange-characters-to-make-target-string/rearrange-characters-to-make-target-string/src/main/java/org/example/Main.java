package org.example;


import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 */
public class Main {
    public static void main(String[] args) {
        rearrangeCharacters("abbaccaddaeea", "aaaaa");
    }

    public static int rearrangeCharacters(String s, String target) {

        int[] fq = new int[26];
        for (char c : s.toCharArray()) {
            fq[c - 'a']++;
        }

        int[] fqTarget = new int[26];
        for (char c : target.toCharArray()) {
            fqTarget[c - 'a']++;
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
        for (int i = 0; i < fq.length; i++) {
            if (fqTarget[i] > 0 && fq[i] == 0) {
                return 0;
            }
            if (fq[i] > 0 && fqTarget[i] > 0) {
                pq.add(fq[i] / fqTarget[i]);
            }
        }

        return pq.peek();
    }
}

