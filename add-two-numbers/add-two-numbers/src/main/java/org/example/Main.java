package org.example;


/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class Main {
    public static void main(String[] args) {
        addTwoNumbers(null, null);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String firstNumber = getNumber(l1);
        System.out.println(firstNumber);
        String secondNumber = getNumber(l2);
        System.out.println(secondNumber);
        int i = 0;
        int j = 0;
        int digit1 = 0;
        int digit2 = 0;
        int rest = 0;
        StringBuilder sum = new StringBuilder();

        while (i <= firstNumber.length() - 1 || j <= secondNumber.length() - 1) {
            digit1 = 0;
            digit2 = 0;

            if (i <= firstNumber.length() - 1) {
                digit1 = Character.digit(firstNumber.charAt(i), 10);
            }
            if (j <= secondNumber.length() - 1) {
                digit2 = Character.digit(secondNumber.charAt(j), 10);
            }

            int localSum = digit1 + digit2 + rest;
            rest = localSum / 10;
            sum.append(localSum % 10);

            i++;
            j++;
        }

        if (rest != 0) {
            sum.append(rest);
        }

        String res = sum.toString();
        System.out.println(res);
        ListNode head = new ListNode(Character.digit(sum.charAt(0), 10));
        ListNode curr = head;
        for (int k = 1; k < res.length(); k++) {
            curr.next = new ListNode(Character.digit(res.charAt(k), 10));
            curr = curr.next;
        }

        return head;
    }

    private static String getNumber(ListNode head) {
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val);
            curr = curr.next;
        }

        return sb.toString();
    }

}