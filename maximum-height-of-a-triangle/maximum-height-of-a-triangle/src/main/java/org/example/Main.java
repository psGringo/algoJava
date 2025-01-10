package org.example;


public class Main {
    public static void main(String[] args) {
        maxHeightOfTriangle(10, 10);

    }

    public static int maxHeightOfTriangle(int red, int blue) {
        int first = getCountRows(red, blue);
        int second = getCountRows(blue, red);

        return Math.max(first, second);
    }

    private static int getCountRows(int first, int second) {
        int rowIndexRedFirst = 0;
        int countRows = 0;
        while (true) {
            int count = rowIndexRedFirst + 1;
            first -= count;
            if (first >= 0) {
                countRows++;
                rowIndexRedFirst++;
            } else {
                break;
            }

            count = rowIndexRedFirst + 1;
            second -= count;
            if (second >= 0) {
                countRows++;
                rowIndexRedFirst++;
            } else {
                break;
            }
        }
        return countRows;
    }
}