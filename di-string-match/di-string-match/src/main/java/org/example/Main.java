package org.example;


/**
 * https://leetcode.com/problems/di-string-match/description/
 */
public class Main {
    public static void main(String[] args) {
      int[] res =  diStringMatch("DDI");
    }

    public static int[] diStringMatch(String s) {
      int[] perm = new int[s.length() + 1];
      int inc = 0;
      int dec = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = inc++;
            } else if (s.charAt(i) == 'D') {
                perm[i] = dec--;
            }
        }
        perm[s.length()] = inc;

        return perm;
    }

}