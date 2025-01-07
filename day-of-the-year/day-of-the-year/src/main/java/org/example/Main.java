package org.example;


import java.time.LocalDate;

/**
 * https://leetcode.com/problems/day-of-the-year/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int dayOfYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfYear();
    }
}