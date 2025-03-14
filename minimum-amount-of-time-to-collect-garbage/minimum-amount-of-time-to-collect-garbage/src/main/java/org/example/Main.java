package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     * almost my solution
     *
     * @param garbage
     * @param travel
     * @return
     */
    public int garbageCollection(String[] garbage, int[] travel) {

        int totalTime = 0;
        int lastG = 0, lastP = 0, lastM = 0; // Last house indices for each type

        for (int i = 0; i < garbage.length; i++) {
            totalTime += garbage[i].length(); // time to collect garbage


            if (garbage[i].contains("M")) {
                lastM = i;
            }
            if (garbage[i].contains("P")) {
                lastP = i;

            }
            if (garbage[i].contains("G")) {
                lastG = i;
            }
        }

        totalTime += getTimeToHouse(travel, lastM);
        totalTime += getTimeToHouse(travel, lastP);
        totalTime += getTimeToHouse(travel, lastG);

        return totalTime;
    }

    private int getTimeToHouse(int[] travel, int lastHouse) {
        int sum = 0;
        for (int i = 0; i < lastHouse; i++) {
            sum += travel[i];
        }
        return sum;
    }


}


