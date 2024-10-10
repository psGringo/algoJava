package org.example;


/**
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doIsSymmetric(root.left, root.right);
    }

    private boolean doIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && doIsSymmetric(left.left, right.right) && doIsSymmetric(left.right, right.left);
    }

}