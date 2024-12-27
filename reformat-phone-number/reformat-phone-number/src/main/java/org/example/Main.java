package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reformat-phone-number/
 */
public class Main {
    public static void main(String[] args) {
        reformatNumber("9964-");
    }

    public static String reformatNumber(String number) {

        String clearedString = clearString(number);

        if (clearedString.length() == 2) {
            return clearedString;
        }

        List<String> parts = new ArrayList<>();
        int wholes = clearedString.length() / 3;
        int restLength = clearedString.length() % 3;
        if (restLength < 2) {
            wholes = wholes - 1;
            restLength += 3;
        }


        int j = 0;
        for (int i = 0; i < wholes; i++) {
            parts.add(clearedString.substring(j, j + 3));
            j += 3;
        }

        if (j < clearedString.length()) {
            String rest = clearedString.substring(j, clearedString.length());
            if (restLength == 2 || restLength == 3) {
                parts.add(rest);
            } else {
                String first = rest.substring(0, 2);
                parts.add(first);
                String second = rest.substring(2, rest.length());
                parts.add(second);
            }
        }

        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < parts.size(); i++) {
            sbResult.append(parts.get(i));
            if (i != parts.size() - 1) {
                sbResult.append("-");
            }
        }

        return sbResult.toString();
    }

    private static String clearString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}