package org.example;


/**
 * https://leetcode.com/problems/find-the-encrypted-string/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String getEncryptedString(String s, int k) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt((i + k) % s.length());
        }
        return new String(chars);
    }
}