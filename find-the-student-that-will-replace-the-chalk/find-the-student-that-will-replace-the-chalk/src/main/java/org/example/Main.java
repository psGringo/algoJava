package org.example;


public class Main {
    public static void main(String[] args) {
        chalkReplacer(new int[]{5, 1, 5}, 22);
    }

    public static int chalkReplacer(int[] chalk, int k) {
        while (true) {
            for (int i = 0; i < chalk.length; i++) {
                if (k <= chalk[i]) {
                    return i;
                }
                k -= chalk[i];
            }
        }
    }

}