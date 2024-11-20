package org.example;


/**
 * https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
            return sb.toString();
        } else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
            return sb.toString();
        }
    }
}