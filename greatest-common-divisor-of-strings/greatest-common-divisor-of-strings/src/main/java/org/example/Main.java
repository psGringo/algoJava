package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 + str2 equals str2 + str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Compute the GCD of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the substring of length gcdLength from str1
        return str1.substring(0, gcdLength);
    }

    // Helper function to compute the GCD of two numbers
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}