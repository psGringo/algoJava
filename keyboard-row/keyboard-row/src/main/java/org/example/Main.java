package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/keyboard-row/description/
 */
public class Main {
    public static void main(String[] args) {
        findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }

    public static String[] findWords(String[] words) {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        HashSet firstRowSet = new HashSet();
        HashSet secondRowSet = new HashSet();
        HashSet thirdRowSet = new HashSet();

        for (int i = 0; i < firstRow.length(); i++) {
            firstRowSet.add(firstRow.charAt(i));
        }
        for (int i = 0; i < secondRow.length(); i++) {
            secondRowSet.add(secondRow.charAt(i));
        }
        for (int i = 0; i < thirdRow.length(); i++) {
            thirdRowSet.add(thirdRow.charAt(i));
        }

        List<String> resList = new ArrayList();
        for (String word : words) {
            String lowered = word.toLowerCase();
            if (isAllCharsInOneRow(lowered, firstRowSet) || isAllCharsInOneRow(lowered, secondRowSet) || isAllCharsInOneRow(lowered, thirdRowSet)) {
                resList.add(word);
            }
        }
        return resList.toArray(new String[resList.size()]);
    }

    private static boolean isAllCharsInOneRow(String word, HashSet rowSet) {
        for (int i = 0; i < word.length(); i++) {
            if (!rowSet.contains(word.charAt(i))) {
                return false;
            }

        }
        return true;
    }
}
