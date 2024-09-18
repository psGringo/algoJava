package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> setA = new HashSet<>();
        var currA = headA;
        while (currA != null) {
            setA.add(currA);
            currA = currA.next;
        }

        ListNode currB = headB;
        while (currB != null) {
            if (setA.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }

        return null;
    }

}