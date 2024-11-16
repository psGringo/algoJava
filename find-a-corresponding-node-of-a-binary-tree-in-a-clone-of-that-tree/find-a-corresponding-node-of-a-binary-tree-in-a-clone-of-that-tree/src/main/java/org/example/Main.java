package org.example;


/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */
public class Main {
    public static void main(String[] args) {

    }

    private TreeNode result;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned, target);
        return result;
    }

    private void dfs(final TreeNode node, final TreeNode target) {
        if (node == null) {
            return;
        }

        if (target.val == node.val) {
            result = node;
        }

        dfs(node.left, target);
        dfs(node.right, target);
    }
}