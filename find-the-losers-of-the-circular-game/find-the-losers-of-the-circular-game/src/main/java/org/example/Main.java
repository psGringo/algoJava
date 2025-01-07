package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }

    public int[] circularGameLosers(int n, int k) {
        Set<Integer> received = new HashSet<>();
        int current = 0;
        int steps = 1;

        // Simulate the game
        while (!received.contains(current)) {
            received.add(current);
            current = (current + steps * k) % n; // Move `steps * k` steps clockwise
            steps++;
        }

        // Find losers
        List<Integer> losers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!received.contains(i)) {
                losers.add(i + 1); // Convert 0-based index to 1-based
            }
        }

        return losers.stream().mapToInt(i -> i).toArray();
    }
}