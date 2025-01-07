package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean detectCapitalUse(String word) {
        // Check if all characters are uppercase
        if (word.equals(word.toUpperCase())) {
            return true;
        }

        // Check if all characters are lowercase
        if (word.equals(word.toLowerCase())) {
            return true;
        }

        // Check if only the first character is uppercase
        if (Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }

        // None of the conditions are satisfied
        return false;
    }
}