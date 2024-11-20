package org.example;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/submissions/1458613984/
 */
public class Main {
    public static void main(String[] args) {
        String res = freqAlphabets("1326#");
    }

    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                String substr = s.substring(i - 2, i + 1);
                char c = map(substr);
                sb.append(c);
                i = i - 3;
            } else {
                sb.append(map(s.charAt(i)));
                i = i - 1;
            }
        }
        return sb.reverse().toString();
    }

    private static char map(String s) {
        HashMap<String, Character> map = new HashMap<>();
        map.put("10#", 'j');
        map.put("11#", 'k');
        map.put("12#", 'l');
        map.put("13#", 'm');
        map.put("14#", 'n');
        map.put("15#", 'o');
        map.put("16#", 'p');
        map.put("17#", 'q');
        map.put("18#", 'r');
        map.put("19#", 's');
        map.put("20#", 't');
        map.put("21#", 'u');
        map.put("22#", 'v');
        map.put("23#", 'w');
        map.put("24#", 'x');
        map.put("25#", 'y');
        map.put("26#", 'z');
        return map.get(s);
    }

    private static char map(char c) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', 'a');
        map.put('2', 'b');
        map.put('3', 'c');
        map.put('4', 'd');
        map.put('5', 'e');
        map.put('6', 'f');
        map.put('7', 'g');
        map.put('8', 'h');
        map.put('9', 'i');
        return map.get(c);
    }

}