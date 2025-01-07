package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            // Check if adjacent digits have the same parity
            if (arr[i - 1] % 2 == arr[i] % 2) {
                // Check if swapping will result in a smaller lexicographical order
                if (arr[i - 1] > arr[i]) {
                    // Perform the swap
                    char temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    break; // Only one swap is allowed
                }
            }
        }
        return new String(arr);
    }
}