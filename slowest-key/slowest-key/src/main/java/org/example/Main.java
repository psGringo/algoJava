package org.example;


import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda");
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        PriorityQueue<CharInfo> pq = new PriorityQueue<>((x, y) -> {
            if (y.pressTime() == x.pressTime()) {
                return y.c() - x.c();
            } else {
                return y.pressTime() - x.pressTime();
            }
        });

        for (int i = 0; i < releaseTimes.length; i++) {
            if (i == 0) {
                pq.add(new CharInfo(keysPressed.charAt(i), releaseTimes[i]));
            } else {
                pq.add(new CharInfo(keysPressed.charAt(i), releaseTimes[i] - releaseTimes[i - 1]));
            }
        }

        return pq.peek().c();
    }
}

record CharInfo(Character c, Integer pressTime) {
}