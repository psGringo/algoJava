package org.example;


import java.util.List;

/**
 * https://leetcode.com/problems/count-items-matching-a-rule/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        var iterator = items.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            var localItems = iterator.next();
            if (ruleKey.equals("type")) {
                if (localItems.get(0).equals(ruleValue)) {
                    count++;
                }
            } else if (ruleKey.equals("color")) {
                if (localItems.get(1).equals(ruleValue)) {
                    count++;
                }
            } else if (ruleKey.equals("name")) {
                if (localItems.get(2).equals(ruleValue)) {
                    count++;
                }
            }
        }

        return count;
    }

}