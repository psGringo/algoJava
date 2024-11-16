package org.example;


/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    private TreeNode result;

    public TreeNode searchBST(TreeNode root, int val) {
       doSearchBST(root, val);
       return result;
    }

    private void doSearchBST(TreeNode node, int val) {
        if (node == null) {
            return;
        }

        if (node.val == val) {
            result = node;
        }
        doSearchBST(node.left, val);
        doSearchBST(node.right, val);
    }
}