package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        lemonadeChange(new int[]{10, 10});
    }

    public static boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> sellersMoney = new HashMap<>();
        for (int bill : bills) {
            sellersMoney.put(bill, sellersMoney.getOrDefault(bill, 0) + 1);
            if (!canGiveChange(sellersMoney, bill - 5)) {
                return false;
            }
        }
        return true;
    }

    private static boolean canGiveChange(HashMap<Integer, Integer> sellersChange, int change) {
        // 35 for ex = 20 + 10 + 5

        if (change >= 20) {
            change = tryGiveChange(sellersChange, change, 20);
        }
        if (change >= 10) {
            change = tryGiveChange(sellersChange, change, 10);
        }

        if (change >= 5) {
            change = tryGiveChange(sellersChange, change, 5);
        }

        return change == 0;
    }

    private static int tryGiveChange(HashMap<Integer, Integer> map, int change, int value) {
        if (change >= value) {
            int integer = change / value;
            while (map.containsKey(value) && map.get(value) > 0 && integer > 0) {
                map.put(value, map.get(value) - 1);
                integer--;
                change -= value;
            }
        }

        return change;
    }
}