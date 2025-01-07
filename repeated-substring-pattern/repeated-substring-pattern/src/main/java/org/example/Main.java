package org.example;



public class Main {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // Check all possible lengths of the substring
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) { // The substring length must divide the string length
                String sub = s.substring(0, len); // Get the potential substring
                StringBuilder repeated = new StringBuilder();

                // Construct the string by repeating the substring
                for (int i = 0; i < n / len; i++) {
                    repeated.append(sub);
                }

                // Check if the constructed string matches the original
                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false; // No valid substring pattern found
    }
}