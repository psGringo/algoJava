package org.example;


/**
 * https://leetcode.com/problems/path-sum/description/
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        hasPathSum(root, 5);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return doHasPathSum(root, 0, 22);
    }

    public static boolean doHasPathSum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            System.out.println(sum);
            return sum == targetSum;
        }
        boolean resLeft = doHasPathSum(node.left, sum, targetSum);
        boolean resRight = doHasPathSum(node.right, sum, targetSum);
        return resLeft || resRight;
    }


}