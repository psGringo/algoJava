package org.example;


/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 */
public class Main {
    public static void main(String[] args) {
        String s = reverseVowels("leetcode");
    }

    public static String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        Character leftVowel;
        Character rightVowel;
        char[] chars = s.toCharArray();

        while (i <= j) {

            if (isVowel(chars[i])) {
                leftVowel = chars[i];
            } else {
                leftVowel = null;
                i++;
            }

            if (isVowel(chars[j])) {
                rightVowel = chars[j];
            } else {
                rightVowel = null;
                j--;
            }

            if (leftVowel != null && rightVowel != null) {
                Character temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }

        return new String(chars);
    }

    private static boolean isVowel(Character c) {
        return "aeiouAEIOU".indexOf(c.charValue()) != -1;
    }

}