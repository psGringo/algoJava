package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public String findLatestTime(String s) {
        char[] time = s.toCharArray();

        // Handle hours
        if (time[0] == '?') {
            time[0] = (time[1] == '?' || time[1] < '2') ? '1' : '0';
        }
        if (time[1] == '?') {
            time[1] = (time[0] == '1') ? '1' : '9';
        }

        // Handle minutes
        if (time[3] == '?') {
            time[3] = '5';
        }
        if (time[4] == '?') {
            time[4] = '9';
        }

        return new String(time);
    }
}