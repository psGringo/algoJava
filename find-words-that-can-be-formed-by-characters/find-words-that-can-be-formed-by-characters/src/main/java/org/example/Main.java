package org.example;


public class Main {
    public static void main(String[] args) {
        countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
    }

    public static int countCharacters(String[] words, String chars) {
        int[] targetFq = getFq(chars);
        int length = 0;
        for (String word : words) {
            int[] fq = getFq(word);
            boolean isWordOk = true;
            for (int i = 0; i < fq.length; i++) {
                if (targetFq[i] < fq[i]) {
                    isWordOk = false;
                    break;
                }
            }
            if (isWordOk) {
                length += word.length();
            }
        }
        return length;
    }

    private static int[] getFq(String word) {
        int[] fq = new int[30];
        for (char c : word.toCharArray()) {
            fq[c - 'a']++;
        }
        return fq;
    }
}