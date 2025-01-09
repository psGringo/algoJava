package org.example;


/**
 * https://leetcode.com/problems/long-pressed-name/description/
 */
public class Main {
    public static void main(String[] args) {
        isLongPressedName("rick", "kric");
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;

        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                // Characters match, move both pointers
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // Character in typed is a long press of the previous character
                j++;
            } else {
                // Invalid character sequence
                return false;
            }
        }

        // Ensure all characters in name were matched
        return i == name.length();
    }
}