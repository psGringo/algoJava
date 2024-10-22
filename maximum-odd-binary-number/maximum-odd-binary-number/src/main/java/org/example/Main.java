package org.example;


/**
 * https://leetcode.com/problems/maximum-odd-binary-number/description/
 */
public class Main {
    public static void main(String[] args) {
        maximumOddBinaryNumber("010");
    }

    /**
     * max odd binary looks like this
     * last char should always be 1
     * other chars should be most left 1
     *
     * 111111111111111111
     *
     * 111111..0000000..1
     *
     * @param s
     * @return
     */
    public static String maximumOddBinaryNumber(String s) {
        int countZeros = 0;
        int countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                countZeros++;
            } else if (s.charAt(i) == '1') {
                countOnes++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (countOnes > 1) {
            sb.append('1');
            countOnes--;
        }
        while (countZeros > 0) {
            sb.append('0');
            countZeros--;
        }

        sb.append('1');
        countOnes--;

        return sb.toString();
    }
}