package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/range-sum-of-bst/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        return doRangeSumBST(root, low, high);
    }

    public int doRangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }

        if (node.val >= low) {
            sum += doRangeSumBST(node.left, low, high);
        }

        if (node.val <= high) {
            sum += doRangeSumBST(node.right, low, high);
        }

        return sum;
    }

}