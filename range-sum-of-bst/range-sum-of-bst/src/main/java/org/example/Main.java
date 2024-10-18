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
        doRangeSumBST(root, low, high, list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public void doRangeSumBST(TreeNode node, int low, int high, List<Integer> sum) {
        if (node == null) {
            return;
        }

        if (node.val >= low && node.val <= high) {
            sum.add(node.val);
        }

        doRangeSumBST(node.left, low, high, sum);
        doRangeSumBST(node.right, low, high, sum);
    }

}