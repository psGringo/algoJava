package org.example;


/**
 * https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int minimumChairs(String s) {
        int minChairs = 0;
        int currPeopleCount = 0;
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == 'E') {
               currPeopleCount++;
               if (minChairs < currPeopleCount) {
                   minChairs += currPeopleCount - minChairs;
               }
           }   else {
               currPeopleCount--;
           }
        }
        return minChairs;
    }

}