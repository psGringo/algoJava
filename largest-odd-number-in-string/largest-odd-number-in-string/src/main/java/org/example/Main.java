package org.example;


public class Main {
    public static void main(String[] args) {
        String res = largestOddNumber("239537672423884969653287101");
    }

    public static String largestOddNumber(String num) {
        int index = num.length() - 1;
        for (int i = index; i >= 0; i--) {
            if ((Character.digit(num.charAt(i), 10) & 0x1) == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";


    // this solution is not ok because of numbers like this 239537672423884969653287101
    //        long numLong = Long.parseLong(num);
    //        long maxOddNumber = getMaxOddNumber(numLong);
    //        return maxOddNumber == 0 ? "" : String.valueOf(maxOddNumber);
    }

    private static long getMaxOddNumber(Long num) {
        while (true) {
            if (num == 0 || (num & 0x1) == 1) {
                return num;
            }

            num = num / 10;
        }
    }
}