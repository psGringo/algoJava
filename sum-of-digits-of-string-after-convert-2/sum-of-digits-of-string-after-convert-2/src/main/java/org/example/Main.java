package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += sb.charAt(i) - '0';
        }

        for (int i = 0; i < k - 1; i++) {
            sum = convert(sum);
        }

        return sum;
    }

    private int convert(int sum) {
        int res = 0;
        while (sum != 0) {
            res += sum % 10;
            sum /= 10;
        }
        return res;
    }

}