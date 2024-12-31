package org.example;


/**
 * https://leetcode.com/problems/capitalize-the-title/
 */
public class Main {
    public static void main(String[] args) {
        capitalizeTitle("capiTalIze tHe titLe");
    }

    public static String capitalizeTitle(String title) {
        String[] words = title.toLowerCase().split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 2) {
                words[i] = words[i].toLowerCase();
            } else {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
        }

        return String.join(" ", words);
    }
}