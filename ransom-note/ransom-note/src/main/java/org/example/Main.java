package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class Main {
    public static void main(String[] args) {
        boolean res = canConstruct("aa", "ab");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] charsMagazine = magazine.toCharArray();
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < charsMagazine.length; i++) {
            dict.put(charsMagazine[i], dict.getOrDefault(charsMagazine[i], 0) + 1);
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        for (int i = 0; i < ransomNoteChars.length; i++) {

            if (!dict.containsKey(ransomNoteChars[i])) {
                return false;
            }

            Integer currCount = dict.get(ransomNoteChars[i]);
            if (currCount == null || currCount <= 0) {
                return false;
            }

            dict.put(ransomNoteChars[i], currCount - 1);

        }

        return true;
    }

}