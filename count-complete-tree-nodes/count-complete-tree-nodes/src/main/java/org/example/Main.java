package org.example;


/**
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        return doCountNodes(root);
    }

    private int doCountNodes(TreeNode node) {
        if (node == null) return 0;
        int left = doCountNodes(node.left);
        int right = doCountNodes(node.right);
        return left + right + 1;
    }

}