package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
 */
public class Main {
    public static void main(String[] args) {
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(0);
     root.right = new TreeNode(1);
     root.left.left = new TreeNode(0);
     root.left.right = new TreeNode(1);
     root.right.left = new TreeNode(0);
     root.right.right = new TreeNode(1);
     sumRootToLeaf(root);
    }

    public static int sumRootToLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doSumRootToLeaf(root, list,  "");
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void doSumRootToLeaf(TreeNode node, List<Integer> list, String prev) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.println(prev);
            Integer num = Integer.parseInt(prev + String.valueOf(node.val), 2);
            list.add(num);
        }

        doSumRootToLeaf(node.left, list, prev + node.val);
        doSumRootToLeaf(node.right, list, prev + node.val);
    }
}