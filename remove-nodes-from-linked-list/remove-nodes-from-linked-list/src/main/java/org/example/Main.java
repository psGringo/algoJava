package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-nodes-from-linked-list/description/
 */
public class Main {
    public static void main(String[] args) {

        //int[] arr = {138, 466, 216, 67, 642, 978, 264, 136, 463, 331, 60, 600, 223, 275, 856, 809, 167, 101, 846, 165, 575, 276, 409, 590, 733, 200, 839, 515, 852, 615, 8, 584, 250, 337, 537, 63, 797, 900, 670, 636, 112, 701, 334, 422, 780, 552, 912, 506, 313, 474, 183, 792, 822, 661, 37, 164, 601, 271, 902, 792, 501, 184, 559, 140, 506, 94, 161, 167, 622, 288, 457, 953, 700, 464, 785, 203, 729, 725, 422, 76, 191, 195, 157, 854, 730, 577, 503, 401, 517, 692, 42, 135, 823, 883, 255, 111, 334, 365, 513, 338, 65, 600, 926, 607, 193, 763, 366, 674, 145, 229, 700, 11, 984, 36, 185, 475, 204, 604, 191, 898, 876, 762, 654, 770, 774, 575, 276, 165, 610, 649, 235, 749, 440, 607, 962, 747, 891, 943, 839, 403, 655, 22, 705, 416, 904, 765, 905, 574, 214, 471, 451, 774, 41, 365, 703, 895, 327, 879, 414, 821, 363, 30, 130, 14, 754, 41, 494, 548, 76, 825, 899, 499, 188, 982, 8, 890, 563, 438, 363, 32, 482, 623, 864, 161, 962, 678, 414, 659, 612, 332, 164, 580, 14, 633, 842, 969, 792, 777, 705, 436, 750, 501, 395, 342, 838, 493, 998, 112, 660, 961, 943, 721, 480, 522, 133, 129, 276, 362, 616, 52, 117, 300, 274, 862, 487, 715, 272, 232, 543, 275, 68, 144, 656, 623, 317, 63, 908, 565, 880, 12, 920, 467, 559, 91, 698};
        int[] arr = {5, 2, 13, 3, 8};
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        removeNodesReverseList(head);

    }

    /**
     * with reverse of the nodes
     *
     * @param head
     * @return
     */
    public static ListNode removeNodesReverseList(ListNode head) {
        ListNode reversedHead = reverse(head);
        ListNode curr = reversedHead;
        while (curr.next != null) {
            if (curr.next.val < curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        ListNode resHead = reverse(reversedHead);
        return resHead;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * with stack and maximums
     *
     * @param head
     * @return
     */
    private static ListNode removeNodesWithStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode currNode = head;
        while (currNode != null) {
            stack.push(currNode.val);
            currNode = currNode.next;
        }

        int[] maxs = new int[stack.size()];
        int i = maxs.length - 1;
        while (!stack.isEmpty()) {
            if (i == maxs.length - 1) {
                maxs[i] = stack.pop();
                i--;
            } else {
                maxs[i] = Math.max(maxs[i + 1], stack.pop());
                i--;
            }
        }

        currNode = head;
        ListNode prev = head;
        int j = 0;
        while (currNode != null) {
            if (currNode.val < maxs[j]) {
                if (currNode == head) {
                    head = currNode.next;
                    prev = currNode.next;
                } else {
                    ListNode next = currNode.next;
                    prev.next = next;
                    currNode = prev;

                }
            }
            prev = currNode;
            currNode = currNode.next;
            j++;
        }
        return head;
    }

}