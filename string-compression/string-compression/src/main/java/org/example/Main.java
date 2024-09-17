package org.example;


/**
 * https://leetcode.com/problems/string-compression/submissions/1393035387/
 */
public class Main {
    public static void main(String[] args) {
        // new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] chars3 = new char[]{'a', 'b', 'c'};
        int res = compress(chars);

    }


    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int writeIndex = 0;
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            count++;
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                // dump
                chars[writeIndex++] = chars[i];
                if (count > 1) {
                    char[] charsFromCount = String.valueOf(count).toCharArray();
                    for (int k = 0; k < charsFromCount.length; k++) {
                        chars[writeIndex++] = charsFromCount[k];
                    }
                }
                count = 0;

            }

        }

        return writeIndex;
    }


}