package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
              int count = Integer.bitCount(i);
              counts.add(count);
        }

        return counts.stream().mapToInt(i -> i).toArray();
    }
}

