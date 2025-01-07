package org.example;


/**
 * https://leetcode.com/problems/student-attendance-record-i/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean checkRecord(String s) {
        return s.chars().filter(c -> c == 'A').count() <= 1 && !s.contains("LLL");
    }
}