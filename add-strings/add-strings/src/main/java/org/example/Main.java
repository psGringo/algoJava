package org.example;

/**
 * https://leetcode.com/problems/add-strings/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(7 / 10);
        String res = addStrings("9", "99");
    }

    public static String addStrings(String num1, String num2) {
        char[] numsArray1 = num1.toCharArray();
        char[] numsArray2 = num2.toCharArray();

        int i = numsArray1.length - 1;
        int j = numsArray2.length - 1;
        var res = new StringBuilder();

        int rest = 0;
        int digit1 = 0;
        int digit2 = 0;
        while (i >= 0 || j >= 0) {
            digit1 = 0;
            digit2 = 0;

            if (i >= 0) {
                digit1 = Character.digit(numsArray1[i], 10);
            }
            if (j >= 0) {
                digit2 = Character.digit(numsArray2[j], 10);
            }

            int sum = digit1 + digit2 + rest;
            rest = sum / 10;
            res.append(sum % 10);

            i--;
            j--;
        }

        if (rest != 0) {
            res.append(rest);
        }

        return res.reverse().toString();
    }
}