package org.example;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int daysBetweenDates(String date1, String date2) {
        // Parse the input strings into LocalDate objects
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);

        // Calculate the absolute difference in days
        return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }
}