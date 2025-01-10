package org.example;


import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }


        var iterator = map.entrySet().iterator();
        int gcd = 0;
        while (iterator.hasNext()) {
            var entry = iterator.next();
            gcd = getGCD(gcd, entry.getValue());
            if (gcd == 1) {
                return false;
            }
        }

        return gcd >= 2;
    }

    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

}