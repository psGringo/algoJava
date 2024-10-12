package org.example;


/**
 * https://leetcode.com/problems/invert-binary-tree/submissions/1419729078/
 */
public class Main {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        doInvertTree(root);
        return root;
    }

    private void doInvertTree(TreeNode root) {
        if (root == null) {
            return;
        }

        var temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
    }
}