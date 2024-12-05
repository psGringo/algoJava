package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        divisorSubstrings(240, 2);
    }

    public static int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int j = i;
            while (j < numStr.length()) {
                if (j - i + 1 == k) {
                    int sunNum = Integer.parseInt(numStr.substring(i, j + 1));
                    if (sunNum != 0 && num % sunNum == 0) {
                        count++;
                    }
                }
                j++;
            }
        }
        return count;
    }
}