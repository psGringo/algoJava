package org.example;


public class Main {
    public static void main(String[] args) {
        addBinary("11", "1");
    }

    public static String addBinary(String a, String b) {
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int t1 = 0, t2 = 0;

            if (n1 >= 0) {
                t1 = a.charAt(n1--) - '0';
            }
            if (n2 >= 0) {
                t2 = b.charAt(n2--) - '0';
            }

            int sum = t1 + t2 + carry;
            carry = sum / 2;
            result.append(sum % 2);
        }
        return result.reverse().toString();
    }
}