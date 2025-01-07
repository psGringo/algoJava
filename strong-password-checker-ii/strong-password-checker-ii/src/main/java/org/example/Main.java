package org.example;


/**
 * https://leetcode.com/problems/strong-password-checker-ii/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialCharacters = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            // Check for lowercase letter
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }

            // Check for uppercase letter
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            // Check for digit
            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            // Check for special character
            if (specialCharacters.indexOf(c) != -1) {
                hasSpecial = true;
            }

            // Check for consecutive identical characters
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }

        // Ensure all conditions are met
        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}