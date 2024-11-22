package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean judgeCircle(String moves) {
        int[] fq = new int[26];
        // this loop works faster rather than for i loop
        for (char c: moves.toCharArray()) {
            fq[c - 'A']++;
        }
//        for (int i = 0; i < moves.length(); i++) {
//            fq[moves.charAt(i) - 'A']++; // decreasing A,because A has a minimal alphabet code = 65
//        }
        return fq['L' - 'A'] == fq['R' - 'A'] && fq['U' - 'A'] == fq['D' - 'A'];
    }
}