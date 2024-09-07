package org.example;


/**
 * https://leetcode.com/problems/find-the-highest-altitude/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        int minPartitions = minPartitions("32");
        System.out.println("Min partitions: " + minPartitions);
    }

    /**
     * max digit in the string is the answer
     *
     * @param n
     * @return
     */
    public static int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            int current = Character.getNumericValue(n.charAt(i));
            if ( Character.getNumericValue(n.charAt(i)) > max ) {
                max = current;
            }
        }
        return max;
    }

/*

 The reason why the answer is the max digit is the following.
Let say we're working with 82734, and we find a way to generate a deci-binary for each digit in a brute force way.
* What would this be? Well, probably just generate 1s at each digit. See following.

|        | Addend#1 | Addend#2 | Addend#3 | Addend#4 | Addend#5 | Addend#6 | Addend#7 | Addend#8 | Sum   |
            |--------|----------|----------|----------|----------|----------|----------|----------|----------|-------|
            |        | 10000    | 10000    | 10000    | 10000    | 10000    | 10000    | 10000    | 10000    | 80000 |
            |        | 1000     | 1000     |          |          |          |          |          |          | 2000  |
            |        | 100      | 100      | 100      | 100      | 100      | 100      | 100      |          | 700   |
            |        | 10       | 10       | 10       |          |          |          |          |          | 30    |
            |        | 1        | 1        | 1        | 1        |          |          |          |          | 4     |
            |--------|----------|----------|----------|----------|----------|----------|----------|----------|-------|
            | Merged | 11111    | 11111    | 10111    | 10101    | 10100    | 10100    | 10100    | 100000   | 82734 |

If you add everything up on the left hand side (non-merged onces), you'll get 82374.
This is not the minimum for sure, but if you stare at this long enough, you'll see that you can merge these numbers
at each column and still get deci-binary. The bottleneck is the number of columns, which is the max digit.

*/


}