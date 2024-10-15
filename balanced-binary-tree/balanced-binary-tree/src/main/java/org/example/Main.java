package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getTreeHeight(root) != -1 ? true : false;
    }

    private int getTreeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getTreeHeight(node.left);
        int rightHeight = getTreeHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}