package org.example;


/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted/description/
 */
public class Main {
    public static void main(String[] args) {
        minDeletionSize(new String[]{"zyx", "wvu", "tsr"});
    }

    public static int minDeletionSize(String[] strs) {
        int count = 0;
        int wordSize = strs[0].length();
        for (int i = 0; i < wordSize; i++) {
            for (int j = 0; j < strs.length -1; j++) {
                if (strs[j + 1].charAt(i) < strs[j].charAt(i)) {
                    count++;
                    break; // this column deleted, no need checks anymore
                }

            }
        }
        return count;
    }
}