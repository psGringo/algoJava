package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean halvesAreAlike(String s) {
        String leftHalf = s.substring(0, s.length() / 2 );
        String rightHalf = s.substring(s.length() / 2,  s.length());

        HashSet<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int countVowelsLeft = 0;
        int countVowelsRight = 0;

        for (int i = 0; i < leftHalf.length(); i++) {
            if (vowels.contains(leftHalf.charAt(i))) {
                countVowelsLeft++;
            }
        }
        for (int i = 0; i < rightHalf.length(); i++) {
            if (vowels.contains(rightHalf.charAt(i))) {
                countVowelsRight++;
            }
        }
        return countVowelsLeft == countVowelsRight;
    }
}