package org.example;


public class Main {
    public static void main(String[] args) {
        countTestedDevices(new int[]{1, 1, 2, 1, 3});
    }

    public static int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                for (int j = i + 1; j < batteryPercentages.length; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return count;
    }


}