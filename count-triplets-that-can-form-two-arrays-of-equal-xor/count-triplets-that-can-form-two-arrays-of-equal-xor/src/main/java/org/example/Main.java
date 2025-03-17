package org.example;


/**
 * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Prefix XOR (cumulative XOR)
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        // Finding valid triplets
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefix[i] == prefix[k + 1]) {
                    count += (k - i);  // j can be any index between i+1 to k
                }
            }
        }

        return count;
    }
}