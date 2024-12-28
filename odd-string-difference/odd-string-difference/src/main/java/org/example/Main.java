package org.example;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/odd-string-difference/description/
 */
public class Main {
    public static void main(String[] args) {
        oddString(new String[]{"abm", "bcn", "alm"});
    }

    public static String oddString(String[] words) {
        HashMap<String, StringInfo> map = new HashMap<>();
        for (String word : words) {
            String diffString = getDiffString(word);
            if (map.containsKey(diffString)) {
                StringInfo stringInfo = map.get(diffString);
                map.put(diffString, new StringInfo(stringInfo.frequency() + 1, word));
            } else {
                map.put(diffString, new StringInfo(1, word));
            }

        }


        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue().frequency() == 1) {
                return entry.getValue().word();
            }
        }

        return null;
    }

    private static String getDiffString(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            int diff = (int) word.charAt(i) - (int) word.charAt(i - 1);
            sb.append(diff);
            sb.append(',');
        }
        return sb.toString();
    }

}

record StringInfo(Integer frequency, String word) {
}