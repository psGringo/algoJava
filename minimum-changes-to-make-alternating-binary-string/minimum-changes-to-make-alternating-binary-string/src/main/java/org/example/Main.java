package org.example;


public class Main {
    public static void main(String[] args) {
//        minOperations("10010100");
    }

    public static int minOperations(String s) {
        int changesForPattern1 = 0; // Pattern "010101..."
        int changesForPattern2 = 0; // Pattern "101010..."

        for (int i = 0; i < s.length(); i++) {
            char expectedCharForPattern1 = (i % 2 == 0) ? '0' : '1';
            char expectedCharForPattern2 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expectedCharForPattern1) {
                changesForPattern1++;
            }
            if (s.charAt(i) != expectedCharForPattern2) {
                changesForPattern2++;
            }
        }

        return Math.min(changesForPattern1, changesForPattern2);
    }

    /**
     * Don't work on all test cases, need to check both scenarios with 10101... and 01010...patterns
     *
     * @param s
     * @return
     */
    public static int minOperations2(String s) {
         StringBuilder sb = new StringBuilder();
         char prevChar = s.charAt(0) == '0' ? '0' : '1';
         sb.append(prevChar);
         for (int i = 1; i < s.length(); i++) {
             char currChar = toggle(prevChar);
             sb.append(currChar);
             prevChar = currChar;
         }
         String correct = sb.toString();

         int count = 0;
         for (int i = 0; i < correct.length(); i++) {
             if (correct.charAt(i) != s.charAt(i)) {
                 count++;
             }
         }
         return count;
    }

    private static char toggle(char c) {
        return c == '1' ? '0' : '1';
    }
}