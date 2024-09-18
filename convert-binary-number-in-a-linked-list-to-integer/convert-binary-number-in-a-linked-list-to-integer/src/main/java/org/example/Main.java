package org.example;


/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

}