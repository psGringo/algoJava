package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        findSpecialInteger(new int[]{1, 2, 3, 3});
    }


    public static int findSpecialInteger(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }

        int count = 1;
        int i = 1;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                double ratio = (count * 1.0 / arr.length) * 100;
                if (ratio > 25) {
                    return arr[i - 1];
                }
                count = 1;
            } else {
                count++;
            }
        }

        // for the last index
        double ratio = (count * 1.0 / arr.length) * 100;
        if (ratio > 25) {
            return arr[i - 1];
        }


        return -1;
    }
}


//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        }
//        var iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            var entry = iterator.next();
//            if ((int) entry.getValue() * 100 / arr.length > 25) {
//                return entry.getKey();
//            }
//        }