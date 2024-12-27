package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/
 */
public class Main {
    public static void main(String[] args) {
        divideString("ctoyjrwtngqwt", 8, 'n');
    }

    public static String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int wholes = s.length() / k;
        int j = 0;
        for (int i = 0; i < wholes; i++) {
            String substr = s.substring(j, j + k);
            j = j + k;
            result.add(substr);
        }

        int remainder = s.length() % k;
        if (remainder != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = j; i < j + remainder; i++) {
                sb.append(s.charAt(i));
            }

            for (int i = 0; i < k - remainder; i++) {
                sb.append(fill);
            }

            result.add(sb.toString());
        }


        return result.toArray(new String[result.size()]);
    }
}