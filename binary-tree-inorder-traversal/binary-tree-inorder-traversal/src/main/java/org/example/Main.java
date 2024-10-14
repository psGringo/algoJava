package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doInorderTraversal(root, res);
        return res;
    }

    public void doInorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        doInorderTraversal(node.left, list);
        list.add(node.val);
        doInorderTraversal(node.right, list);
    }


}