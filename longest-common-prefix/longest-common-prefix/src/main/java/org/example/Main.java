package org.example;


/**
 * https://leetcode.com/problems/longest-common-prefix
 */
public class Main {
    public static void main(String[] args) {
        String res = longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"});
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs[0].equals("")) {
            System.out.println("here");
            return "";
        }

        int index = 0;

        while (index < strs[0].length()) {
            if (isAllCharsEqual(strs, index)) {
                index++;
            } else {
                break;
            }
        }


        return strs[0].substring(0, index);
    }

    private static boolean isAllCharsEqual(String[] strs, int index) {
        for (int i = 1; i < strs.length; i++) {
            if (index >= strs[i].length() || strs[0].charAt(index) != strs[i].charAt(index)) {
                return false;
            }
        }
        return true;
    }


}