package org.example;


/**
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean evaluateTree(TreeNode node) {
        return doEvaluateTree(node);
    }

    private boolean doEvaluateTree(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            if (node.val == 0) {
                return false;
            } else if (node.val == 1) {
                return true;
            }
        }

        if (node.val == 2) {
            return doEvaluateTree(node.left) || doEvaluateTree(node.right);
        } else //if (node.val == 3) {
            return doEvaluateTree(node.left) && doEvaluateTree(node.right);
    }
}

