package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                // Replace '?' with a valid character
                for (char c = 'a'; c <= 'z'; c++) {
                    // Check previous and next characters to avoid repetition
                    if ((i > 0 && chars[i - 1] == c) || (i < chars.length - 1 && chars[i + 1] == c)) {
                        continue;
                    }
                    chars[i] = c; // Assign valid character
                    break;
                }
            }
        }

        return new String(chars);
    }
}