package org.example;


/**
 * https://leetcode.com/problems/distance-between-bus-stops/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // Reverse if start > destination
        // Ensure start is less than destination
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int totalDistance = 0;
        int clockwiseDistance = 0;

        // Calculate total distance and clockwise distance
        for (int i = 0; i < distance.length; i++) {
            totalDistance += distance[i];
            if (i >= start && i < destination) {
                clockwiseDistance += distance[i];
            }
        }

        // Calculate counterclockwise distance
        int counterclockwiseDistance = totalDistance - clockwiseDistance;

        // Return the shorter distance
        return Math.min(clockwiseDistance, counterclockwiseDistance);
    }


}