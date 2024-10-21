package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        return doFindTarget(root, set, k);
    }

    public boolean doFindTarget(TreeNode node, HashSet<Integer> set, int k) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return doFindTarget(node.left, set, k) || doFindTarget(node.right, set, k);
    }

}