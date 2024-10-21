package org.example;


import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Main {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(6);
//
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        //var res = isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long min, long max){
        if (root == null){
            return true;
        } else if (root.val >= max || root.val <= min){
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public boolean isValidBSTStack(TreeNode root) {
        if (root == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        inorder(root, stack);
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            if (stack.isEmpty()) {
                return true;
            }
            if (value <= stack.peek()) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, Stack<Integer> values) {
        if (root == null) {
            return;
        }
        inorder(root.left, values);
        values.push(root.val);
        inorder(root.right, values);
    }



}