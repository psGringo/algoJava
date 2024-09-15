package org.example;


/**
 * https://leetcode.com/problems/shuffle-string/
 */
public class Main {
    public static void main(String[] args) {
        var res = restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3});
    }

    public static String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = s.charAt(i);
        }

        return new String(res);
    }

}