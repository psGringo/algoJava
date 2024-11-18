package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> startNodes = new ArrayList<>();
        getStartValues(root, subRoot.val, startNodes);

        List<Integer> subRootValues = new ArrayList<>();
        getSortedValuesInorder(subRoot, subRootValues);

        for (TreeNode startNode : startNodes) {
            List<Integer> values = new ArrayList<>();
            getSortedValuesInorder(startNode, values);
            if (subRootValues.equals(values)) {
                return true;
            }
        }

        return false;

    }

    private void getSortedValuesInorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        getSortedValuesInorder(node.left, values);
        values.add(node.val);
        getSortedValuesInorder(node.right, values);
    }

    private void getStartValues(TreeNode node, int targetValue, List<TreeNode> startNodes) {
        if (node == null) {
            return;
        }
        if (node.val == targetValue) {
            startNodes.add(node);
        }

        getStartValues(node.left, targetValue, startNodes);
        getStartValues(node.right, targetValue, startNodes);
    }
}