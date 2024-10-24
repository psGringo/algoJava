package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeafs(root1);
        List<Integer> list2 = getLeafs(root2);
        return list1.equals(list2);
    }

    private List<Integer> getLeafs(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> leafs = new ArrayList<>();
        doGetLeafs(root, leafs);

        return leafs;
    }

    private void doGetLeafs(TreeNode node, List<Integer> leafs) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafs.add(node.val);
        }
        doGetLeafs(node.left, leafs);
        doGetLeafs(node.right, leafs);
    }

}