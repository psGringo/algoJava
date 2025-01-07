package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public String thousandSeparator(int n) {
        String num = String.valueOf(n);
        StringBuilder result = new StringBuilder();

        int count = 0;

        // Traverse the string from right to left
        for (int i = num.length() - 1; i >= 0; i--) {
            result.append(num.charAt(i));
            count++;

            // Add a dot after every 3 digits (except at the end)
            if (count % 3 == 0 && i != 0) {
                result.append('.');
            }
        }

        // Reverse the result to get the correct order
        return result.reverse().toString();
    }
}