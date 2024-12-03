package org.example;


/**
 * https://leetcode.com/problems/number-of-lines-to-write-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] numberOfLines(int[] widths, String s) {
        int lineWidth = 100;
        int currWidth = 0;
        int countLines = 1;
        for (int i = 0; i < s.length(); i++) {
            currWidth += widths[s.charAt(i) - 'a'];
            if (currWidth > lineWidth) {
                countLines++;
                currWidth = widths[s.charAt(i) - 'a'];
            }
        }

        return new int[]{countLines, currWidth};
    }
}