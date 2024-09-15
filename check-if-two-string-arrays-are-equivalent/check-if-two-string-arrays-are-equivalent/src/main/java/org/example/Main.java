package org.example;


/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
 */
public class Main {
    public static void main(String[] args) {
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};

     boolean result = arrayStringsAreEqual(word1, word2);
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
      return getWord(word1).equals(getWord(word2));
    }

    private static String getWord(String[] source) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            sb.append(source[i]);
        }

        return sb.toString();
    }

}