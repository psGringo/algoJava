package org.example;


public class Main {
    public static void main(String[] args) {
        kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = arr[0] * 1.0 / arr[n - 1];

        double high = 1.0;

        while (low < high) {
            double mid = (low + high) / 2;
            int[] c = find(mid, arr);
            if (c[0] > k) {
                high = mid;
            } else if (c[0] < k) {
                low = mid;
            } else {
                return new int[]{c[1], c[2]};
            }
        }
        return new int[]{0, 0};
    }

    public static int[] find(double target, int arr[]) {
        int n = arr.length;

        int i = 0;
        int cuntSmallerFractions = 0;
        int num = arr[0];
        int den = arr[n - 1];

        for (int j = 1; j < n; j++) {
            while (arr[i] * 1.0 / arr[j] <=  target) {
                i++; // after i, more than target
            }
            cuntSmallerFractions += i; //??

            // if smallest fraction more then num, den, than update it
            if (i > 0 && arr[i - 1] * 1.0 / arr[j]  > num * 1.0 / den) {
                num = arr[i - 1];
                den = arr[j];
            }
        }
        return new int[]{cuntSmallerFractions, num, den};
    }
}