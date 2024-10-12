package org.example;


/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        sumOfLeftLeaves(root);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return doSumOfLeftLeaves(root);
    }

    private static int doSumOfLeftLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (node.left != null && isLeftLeaf(node)) {
                sum += node.left.val;
        }

        sum += doSumOfLeftLeaves(node.left);
        sum += doSumOfLeftLeaves(node.right);

        return sum;
    }

    private static boolean isLeftLeaf(TreeNode node) {
        return node.left.left == null && node.left.right == null;
    }

}