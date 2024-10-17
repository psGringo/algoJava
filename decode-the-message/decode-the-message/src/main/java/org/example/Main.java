package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/decode-the-message/description/
 */
public class Main {
    public static void main(String[] args) {
        String res = decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }

    public static String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();

        char ch = 'a';
        for (int i = 0, j = 0; i < key.length(); i++) {
            if (!map.containsKey(key.charAt(i)) && key.charAt(i) != ' ') {
                map.put(key.charAt(i), ch);
                j++;
                ch++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                int code = map.get(message.charAt(i));
                sb.append((char) code);
            }
        }

        return sb.toString();
    }
}