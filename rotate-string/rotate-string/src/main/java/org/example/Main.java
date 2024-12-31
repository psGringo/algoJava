package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        boolean res = rotateString("abcde", "abced");
    }

    public static boolean rotateString(String s, String goal) {
        int countShifts = 0;
        char[] arr = s.toCharArray();
        while (true) {
            arr = shift(arr, 1);
            countShifts++;
            if (Arrays.equals(arr, goal.toCharArray())) {
                return true;
            }
            if (countShifts > s.length()) {
                return false;
            }
        }
    }

    private static char[] shift(char[] charArray, int shiftStep) {
        char[] res = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            int index = i + shiftStep;
            if (index > charArray.length - 1) {
                int delta = index - (charArray.length - 1);
                index = delta - 1;
            }
            res[index] = charArray[i];
        }
        return res;
    }
}