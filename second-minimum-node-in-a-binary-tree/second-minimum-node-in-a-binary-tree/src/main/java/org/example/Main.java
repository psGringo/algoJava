package org.example;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 671. Second Minimum Node In a Binary Tree
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        dfs(root, pq, set);
        if (pq.size() >= 2) {
            pq.poll();
            return pq.peek();
        }
        return -1;
    }

    private void dfs(TreeNode node, PriorityQueue<Integer> pq, Set<Integer> set) {
        if (node == null) {
            return;
        }

        if (!set.contains(node.val)) {
            set.add(node.val);
            pq.offer(node.val);
        }

        dfs(node.left, pq, set);
        dfs(node.right, pq, set);
    }
}