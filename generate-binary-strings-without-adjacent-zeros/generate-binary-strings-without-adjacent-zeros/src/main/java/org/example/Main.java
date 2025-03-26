package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         validStrings(3);
    }

    static List<String> result = new ArrayList<>();

    public static List<String> validStrings(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        validStrings(chars, 0);
        return result;
    }

    public static void validStrings(char[] arr, int index) {
        if (index == arr.length) {
            // Only check after full string is built
            boolean hasAdjacentZeros = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == '0' && arr[i - 1] == '0') {
                    hasAdjacentZeros = true;
                    break;
                }
            }
            if (!hasAdjacentZeros) {
                result.add(new String(arr));
            }
            return;
        }

        // Option 1: Place '1'
        arr[index] = '1';
        validStrings(Arrays.copyOf(arr, arr.length), index + 1);

        // Option 2: Place '0'
        arr[index] = '0';
        validStrings(Arrays.copyOf(arr, arr.length), index + 1);
    }

}