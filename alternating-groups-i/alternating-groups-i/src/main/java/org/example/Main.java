package org.example;


/**
 * https://leetcode.com/problems/alternating-groups-i/description/
 */
public class Main {
    public static void main(String[] args) {
        numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1});
    }

    public static int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int[] doubleColours = new int[2 * n];
        for (int i = 0; i < n; i++) {
            doubleColours[i] = colors[i];
            doubleColours[i + n] = colors[i];
        }
        int start = 0;
        int i = start;
        int j = i + 2;
        int res = 0;
        while (true) {
            if (doubleColours[i] == doubleColours[j] && doubleColours[i] != doubleColours[i + 1]) {
                res++;
            }
            i++;
            j++;
            if (i == start + n) {
                break;
            }
        }
        return res;
    }
}