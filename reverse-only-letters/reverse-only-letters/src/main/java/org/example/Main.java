package org.example;


/**
 * https://leetcode.com/problems/reverse-only-letters/description/
 */
public class Main {
    public static void main(String[] args) {
        reverseOnlyLetters("ab-cd");
    }

    public static String reverseOnlyLetters(String s) {
        // starting from outbound indexes here
        int i = -1, j = s.length();
        char[] charArr = s.toCharArray();

        i = moveRightUntilLetter(charArr, i);
        j = moveLeftUntilLetter(charArr, j);
        while (i < j) {
            swap(charArr, i, j);
            i = moveRightUntilLetter(charArr, i);
            j = moveLeftUntilLetter(charArr, j);
        }

        return String.valueOf(charArr);
    }

    private static char[] swap(char[] source, int i, int j) {
        char temp = source[i];
        source[i] = source[j];
        source[j] = temp;
        return source;
    }

    private static int moveRightUntilLetter(char[] charArr, int index) {
        do {
            if (index < charArr.length - 1) {
                index++;
            }
        } while (index < charArr.length - 1 && !Character.isLetter(charArr[index]));

        return index;
    }

    private static int moveLeftUntilLetter(char[] charArr, int index) {
        do {
            if (index > 0) {
                index--;
            }

        } while (index > 0 && !Character.isLetter(charArr[index]));

        return index;
    }
}