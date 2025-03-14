package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {

    }


    /**
     * optimized and fast solution
     *
     * @param bank
     * @return
     */
    public int numberOfBeams(String[] bank) {
        int prevDevices = 0; // Stores devices count in the last non-empty row
        int result = 0;

        for (String row : bank) {
            int devices = getCountDevices(row);
            if (devices > 0) { // Only consider non-empty rows
                result += prevDevices * devices;
                prevDevices = devices; // Move to next row
            }
        }

        return result;
    }




    /**
     * my solution
     *
     * calc devices on each row
     * reusult = sum (countDevicesOnRow * countDevicesOnPreviousRow)
     *
     * @param bank
     * @return
     */
    public int numberOfBeams1(String[] bank) {
        int[] allRows = new int[bank.length];
        int currentRow = 0;
        int countEmptyRows = 0;
        for (String rowValue : bank) {
            int count = getCountDevices(rowValue);
            if (count == 0) {
                countEmptyRows++;
            }
            allRows[currentRow++] = count;
        }

        // clearing from zeros
        int countNonEmptyRows = allRows.length - countEmptyRows;
        int[] nonEmptyRows = new int[countNonEmptyRows];
        currentRow = 0;
        for (int i = 0; i < allRows.length; i++) {
            if (allRows[i] > 0) {
                nonEmptyRows[currentRow++] = allRows[i];
            }
        }

        int result = 0;
        for (int i = 1; i < nonEmptyRows.length; i++) {
            result += nonEmptyRows[i] * nonEmptyRows[i - 1];
        }

        return result;
    }

    private int getCountDevices(String row) {
        int count = 0;
        for (char c : row.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}