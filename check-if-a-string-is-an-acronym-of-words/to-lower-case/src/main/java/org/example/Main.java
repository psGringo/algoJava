package org.example;


/**
 * https://leetcode.com/problems/to-lower-case/description/
 */
public class Main {
    public static void main(String[] args) {
        String res = toLowerCase("Hello");
    }

    public static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char c = (char) ((int) s.charAt(i) + 32);
                sb.append(c);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}