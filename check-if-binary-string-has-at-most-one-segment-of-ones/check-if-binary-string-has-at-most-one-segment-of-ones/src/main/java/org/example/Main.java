package org.example;

public class Main {
    public static void main(String[] args) {
        checkOnesSegment("1001");
    }

    public static boolean checkOnesSegment(String s) {

        int currentCountOnes = 0;
        int countSegments = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                currentCountOnes++;
            } else {
                if (currentCountOnes >= 1) {
                    countSegments++;
                }
                currentCountOnes = 0;
            }
        }

        // last segment
        if (currentCountOnes > 0) {
            countSegments++;
        }


        return countSegments == 1;
    }
}