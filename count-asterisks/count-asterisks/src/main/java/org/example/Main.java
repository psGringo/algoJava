package org.example;


/**
 * https://leetcode.com/problems/count-asterisks/submissions/1451525770/
 *
 * to the essence, the problem statement says,
 * in terms of 0-based indices,
 * only those '|' MAKES PAIRS : (0, 1), (2, 3), (4, 5), ...,
 * while (1, 2), (3, 4),
 * and so on WON'T make pairs, so confusing that I only understand it
 * after seeing other's solution
 */
public class Main {
    public static void main(String[] args) {
        countAsterisks("l|*e*et|c**o|*de|");
    }

    public static int countAsterisks(String s) {
        int count = 0;
        int countSeparators = 0;
        boolean isOpen = false;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '|') {
                countSeparators++;
            }

            isOpen = countSeparators % 2 == 0;
            if (isOpen && s.charAt(i) == '*') {
                count++;
            }


        }
        return count;

    }

}

//        String[] arr = s.split("\\|");
//        for (int i = 2; i < arr.length; i = i + 2) {
//            for (int j = 0; j < arr[i].length(); j++) {
//                if (arr[i].charAt(j) == '*') {
//                    count++;
//                }
//            }
//        }