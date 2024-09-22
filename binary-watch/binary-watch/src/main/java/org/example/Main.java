package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch/
 */
public class Main {

    public static void main(String[] args) {

    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        int[] arr = new int[10];
        dfs(list, arr, 0, turnedOn);
        return list;
    }

    public void dfs(List<String> list, int[] arr, int index, int turnedOn){
        if (turnedOn == 0 || index == arr.length) {
            if (turnedOn == 0) {
                int hours = getHours(arr);
                int minutes = getMinutes(arr);
                if (hours < 12 && minutes < 60) {
                    list.add(String.format("%s:%02d", hours, minutes));
                }
            }
            return;
        }

        arr[index] = 1; dfs(list, arr, index + 1, turnedOn - 1);
        arr[index] = 0; dfs(list, arr, index + 1, turnedOn);
    }

    private void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    private int getHours(int[] arr) {
        int hours = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i] == 1) {
                hours += (int) Math.pow(2, 3 - i);
            }
        }

        return hours;
    }

    private int getMinutes(int[] arr) {
        int minutes = 0;
        for (int i = 4; i < arr.length; i++) {
            if (arr[i] == 1) {
                minutes += (int) Math.pow(2, 5 - i + 4 );
            }
        }

        return minutes;
    }

}