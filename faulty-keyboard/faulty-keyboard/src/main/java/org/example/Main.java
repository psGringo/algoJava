package org.example;


/**
 * 2810. Faulty Keyboard
 *
 * https://leetcode.com/problems/faulty-keyboard/description/
 */
public class Main {
    public static void main(String[] args) {
        finalString("viwif");
    }

    public static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                sb.reverse();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String reverse(String s) {
        StringBuilder sbRes = new StringBuilder();
        return sbRes.append(s).reverse().toString();
    }


    /*        String[] substrings = s.split("i");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < substrings.length; i++) {
            if (i > 0 && substrings[i] == "") {
                substrings[i - 1] = reverse(substrings[i - 1]);
            } else if (s.charAt(s.length() - 1) == 'i' && i == substrings.length - 1) {
                substrings[substrings.length - 1] = reverse(substrings[substrings.length - 1]);
            }
            else if (i != substrings.length - 1) {
                substrings[i] = reverse(substrings[i]);
            }
        }
        for (int i = 0; i < substrings.length; i++) {
            sb.append(substrings[i]);
        }

        return sb.toString();*/
}