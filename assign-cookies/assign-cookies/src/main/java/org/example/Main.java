package org.example;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class Main {
    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{3};
        findContentChildren(g, s);
    }

    public static int findContentChildren2(int[] g, int[] s) {
        if (s == null || s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j;
    }

    public static int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        // left border
        int left = g[0] < s[0] ? s[0] : g[0];
        // right border
        int right = g[g.length - 1] < s[s.length - 1] ? g[g.length - 1] : s[s.length - 1];

        System.out.println(left);
        System.out.println(right);

        int countGreed = 0;
        int countSatisfy = 0;
        for (int i = 0; i < g.length; i++) {
            if (g[i] >= left && g[i] <= right) {
                countGreed++;
            }
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i] >= left && s[i] <= right) {
                countSatisfy++;
            }
        }

        return Math.min(countGreed, countSatisfy);
    }

}