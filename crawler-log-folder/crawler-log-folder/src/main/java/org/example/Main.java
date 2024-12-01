package org.example;


/**
 * https://leetcode.com/problems/crawler-log-folder/description/
 */
public class Main {
    public static void main(String[] args) {
        int res = minOperations(new String[]{"d1/","d2/","../","d21/","./"});
        System.out.println(res);
    }

    public static int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (level > 0) {
                    level--;
                }
            } else if (log.equals("./")) {
                // do nothing
                System.out.println("./");
            } else {
                level++;
                System.out.println("other");
            }
        }
        return level;
    }
}