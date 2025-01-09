package org.example;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-letter-to-equalize-frequency/description/
 */
public class Main {
    public static void main(String[] args) {
        equalFrequency("ddaccb");
    }

    public static boolean equalFrequency(String word) {
        int[] fq = new int[26];
        for (char c : word.toCharArray()) fq[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            fq[i]--;
            if (isEqual(fq)) return true;
            fq[i]++;
        }
        return false;
    }

    private static boolean isEqual(int[] fq) {
        int lastCount = 0;
        for (int count : fq) {
            if (count == 0) continue;
            if (lastCount != 0 && count != lastCount) return false;
            lastCount = count;
        }
        return true;
    }
    
}