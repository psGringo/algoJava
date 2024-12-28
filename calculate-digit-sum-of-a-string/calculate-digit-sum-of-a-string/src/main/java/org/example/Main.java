package org.example;


public class Main {
    public static void main(String[] args) {
        digitSum("01234567890", 100);
    }

    /**
     * more optimal solution
     *
     * @param s
     * @param k
     * @return
     */
    public static String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int sum = 0;
        for (int i = 1; i <= s.length(); i++) {
            sum += s.charAt(i-1) - '0';
            if (i % k == 0 || i == s.length()) {
                builder.append(sum);
                sum = 0;
            }
        }

        return digitSum(builder.toString(), k);
    }


    /**
     * my first solution
     *
     * @param s
     * @param k
     * @return
     */
    public static String digitSum2(String s, int k) {
        if (s.length() <= k) {
            return s;
        }

        while (true) {
            int sum = 0;
            int j = 0;
            int wholes = s.length() / k;
            int remainder = s.length() % k;

            int l = 0;
            StringBuilder sb = new StringBuilder();
            while (l < wholes) {
                for (int i = j; i < j + k; i++) {
                    sum += Character.digit(s.charAt(i), 10);
                }
                j = j + k;
                sb.append(sum);
                sum = 0;
                l++;
            }



            if (remainder != 0) {
                for (int i = j; i < s.length(); i++) {
                    sum += Character.digit(s.charAt(i), 10);
                }
                sb.append(sum);
            }

            s = sb.toString();

            // flush
            sb.setLength(0);
            sum = 0;

            if (s.length() <= k) {
                return s;
            }
        }
    }
}