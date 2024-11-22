package org.example;


/**
 * https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
 */
public class Main {
    public static void main(String[] args) {
        minTimeToType("zjpc");
    }


    public static int minTimeToType(String word) {
        int count = 0;
        count = move2('a', word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            count += move2(word.charAt(i - 1), word.charAt(i));
        }
        return count;
    }

    /**
     * TODO...
     *
     * @param current
     * @param next
     * @return
     */
    private static int move2(char current, char next) {
        int countClockwise = 0;
        int countCounterClockwise = 0;
        int timeToType = 1;
        if (current == next) {
            return 0 + timeToType;
        }

        if (next > current) {
            countClockwise = next - current;
            countCounterClockwise = current - 'a' + ('z' - next) + 1;
        } else if (next < current) {
            countClockwise = 'z' - current + (next - 'a') + 1;
            countCounterClockwise = current - next;
        }

        int minCount = Math.min(countClockwise, countCounterClockwise);
        System.out.println("%s -> %s, %d".formatted(current, next, minCount));

        return minCount + timeToType;
    }

    private static int move(char current, char next) {
        int countClockwise = 0;
        int countCounterClockwise = 0;
        char temp = current;
        while (temp != next) {
            temp++;
            if ((int) temp > (int) 'z') {
                temp = 'a';
            }
            countClockwise++;
        }

        temp = current;
        while (temp != next) {
            temp--;
            if ((int) temp < (int) 'a') {
                temp = 'z';
            }
            countCounterClockwise++;
        }

        int minCount = Math.min(countClockwise, countCounterClockwise);
        int timeToType = 1;
        System.out.println("%s -> %s, %d, timeToType = %d".formatted(current, next, minCount, timeToType));
        return minCount + timeToType;
    }
}