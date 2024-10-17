package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        binaryTreePaths(root);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        doBinaryTreePaths(root, null, result);
        return result;
    }

    private static void doBinaryTreePaths(TreeNode node, List<String> prevStepRes, List<String> result) {
        if (node == null) {
            return;
        }

        List<String> list = new ArrayList<>();
        if (prevStepRes != null) {
            list.addAll(prevStepRes);
        }
        list.add(String.valueOf(node.val));

        if (node.left == null && node.right == null) {
            result.add(String.join("->", list));
        }

        doBinaryTreePaths(node.left, list, result);
        doBinaryTreePaths(node.right, list, result);
    }

}