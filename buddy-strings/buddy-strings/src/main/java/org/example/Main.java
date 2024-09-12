package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/buddy-strings/solutions/3710426/beat-s-100-c-java-python-beginner-friendly/
 */
public class Main {
    public static void main(String[] args) {

    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        /*for strings like 'aab' and 'aab'*/
        if (s.equals(goal)) {
            if (hasDublicates(s)) {
                return true;
            }
            return false;
        }

        int i = 0;
        while (i < s.length() && s.charAt(i) == goal.charAt(i)) {
            i++;
        }

        int j = s.length() - 1;
        while (j > 0 && s.charAt(j) == goal.charAt(j)) {
            j--;
        }

        return swapChars(s, i, j).equals(goal);
    }

    private static String swapChars(String s, int i, int j) {
        var chars = s.toCharArray();
        Character temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }


    private static boolean hasDublicates(String s) {
        var set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (set.add(s.charAt(i)) == false) {
                return true;
            }
        }
        return false;
    }

}