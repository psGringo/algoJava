package org.example;


/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/description/
 */
public class Main {
    public static void main(String[] args) {
        int res = convertTime("11:00", "11:01");
    }

    public static int convertTime(String current, String correct) {
        final int[] ops = {60, 15, 5, 1};
        int diff = getMinutes(correct) - getMinutes(current);
        int ans = 0;

        for (final int op : ops) {
            ans += diff / op;
            diff %= op;
        }

        return ans;
    }

    private static int getMinutes(final String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
    }


    public static int convertTime2(String current, String correct) {
        String[] correctSplitted = correct.split(":");
        String[] currentSplitted = current.split(":");
        int hours = Integer.parseInt(correctSplitted[0]) - Integer.parseInt(currentSplitted[0]);
        int minutes = Integer.parseInt(correctSplitted[1]) - Integer.parseInt(currentSplitted[1]);
        int totalMinutesNeeded = hours * 60 + minutes;
        return countOperationsNeeded(totalMinutesNeeded);
    }

    private static int countOperationsNeeded(int time) {
        int count = 0;
        if (time >= 60) {
            count += time / 60;
            time = time % 60;
        }
        if (time >= 15) {
            count += time / 15;
            time = time % 15;
        }
        if (time >= 5) {
            count += time / 5;
            time = time % 5;
        }
        if (time >= 1) {
            count += time / 1;
            time = time % 1;
        }
        return count;
    }
}