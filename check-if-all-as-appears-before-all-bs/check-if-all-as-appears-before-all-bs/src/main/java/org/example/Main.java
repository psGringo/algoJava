package org.example;


/**
 * https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean checkString(String s) {
        int lastIndexOfA = s.lastIndexOf("a");
        int firstIndexOfB = s.indexOf("b");
        if (firstIndexOfB == -1) {
            return true;
        }
        return lastIndexOfA < firstIndexOfB;
    }
}