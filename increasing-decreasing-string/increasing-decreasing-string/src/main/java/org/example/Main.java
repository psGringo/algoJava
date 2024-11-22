package org.example;


public class Main {
    public static void main(String[] args) {
        sortString("aaaabbbbcccc");
    }

    public static String sortString(String s) {
        int[] fq = new int[131];
        for (int i = 0; i < s.length(); i++) {
            fq[(int) s.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean needBreak = true;
            for (int i = 65; i < 130; i++) {
                if (fq[i] > 0) {
                    sb.append((char) i);
                    fq[i]--;
                    needBreak = false;
                }
            }
            for (int i = 130; i >= 65; i--) {
                if (fq[i] > 0) {
                    sb.append((char) i);
                    fq[i]--;
                    needBreak = false;
                }
            }
            if (needBreak) {
                break;
            }
        }
        return sb.toString();
    }
}