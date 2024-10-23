package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        List<TreeNode> list = new ArrayList<>();
        doIncreasingBST(root, list);

        TreeNode next = null;
        TreeNode prev = null;
        for (int i = list.size() - 1; i > 0; i--) {
            next = new TreeNode(list.get(i).val, null,  next);
            prev = new TreeNode(list.get(i - 1).val, null, next);
        }

        return prev;
    }

    public void doIncreasingBST(TreeNode node, List<TreeNode> values) {
        if (node == null) {
            return;
        }

        doIncreasingBST(node.left, values);
        values.add(node);
        doIncreasingBST(node.right, values);
    }

}