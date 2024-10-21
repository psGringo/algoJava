package org.example;


/**
 * https://leetcode.com/problems/univalued-binary-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return doIsUnivalTree(root, root.val);
    }

    public boolean doIsUnivalTree(TreeNode node, int prevValue) {
        if (node == null) {
            return true;
        }
        if (node.val != prevValue) {
            return false;
        }
        return doIsUnivalTree(node.left, node.val) && doIsUnivalTree(node.right, node.val);
    }

}