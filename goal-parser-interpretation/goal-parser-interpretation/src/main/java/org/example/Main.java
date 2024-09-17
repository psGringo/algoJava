package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/goal-parser-interpretation/description/
 */
public class Main {
    public static void main(String[] args) {
        String res = interpret("G()(al)");
    }

    public static String interpret(String command) {

        HashMap<String, String> dict = new HashMap<>();
        dict.put("G", "G");
        dict.put("()", "o");
        dict.put("(al)", "al");

        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < command.length()) {
            String word = (getWord(i, command));
            if (word != null) {
                result.append(dict.get(word));
                i += word.length();
            } else {
                i++;
            }
        }

        return result.toString();
    }

    private static String getWord(int index, String command) {

        if (checkWord(index, command, "G")) {
            return "G";
        } else if (checkWord(index, command, "()")) {
            return "()";
        } else if (checkWord(index, command, "(al)")) {
            return "(al)";
        }

        return null;
    }

    private static boolean checkWord(int index, String command, String word) {
        if (index + word.length() <= command.length()) {
            return command.substring(index, index + word.length()).equals(word);
        } else return false;
    }

}