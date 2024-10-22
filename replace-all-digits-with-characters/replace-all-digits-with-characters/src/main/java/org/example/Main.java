package org.example;


public class Main {
    public static void main(String[] args) {
        replaceDigits("a1c1e1");
    }

    public static String replaceDigits(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                sb.append(shift(s.charAt(i - 1), Character.digit(s.charAt(i), 10)));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static char shift(char c, int diff) {
        return (char) ((int) c + diff);
    }

}