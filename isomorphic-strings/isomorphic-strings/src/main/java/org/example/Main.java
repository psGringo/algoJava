package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 */
public class Main {
    public static void main(String[] args) {
        boolean res = isIsomorphic("badc", "baba");
    }

    public static boolean isIsomorphic(String s, String t) {
        return doCheckIsomorphic(s, t) && doCheckIsomorphic(t, s);
    }

    private static boolean doCheckIsomorphic(String s, String t) {
        var sMap = new HashMap<Character, Character>();
        for (var i = 0; i < s.length(); i++) {
            var tChar = sMap.get(s.charAt(i));

            if (tChar == null) {
                sMap.put(s.charAt(i), t.charAt(i));
            } else if (tChar != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}