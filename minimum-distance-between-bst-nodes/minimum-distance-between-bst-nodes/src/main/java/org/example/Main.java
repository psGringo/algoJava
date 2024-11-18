package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
public class Main {

    private int min;

    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
      List<Integer> values = new ArrayList<>();
      doMinDiffInBST(root, values);
      int min = Integer.MAX_VALUE;
      for (int i = 1; i < values.size(); i++) {
          min = Math.min(min, values.get(i) - values.get(i - 1));
      }
      return min;
    }

    public void doMinDiffInBST(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        doMinDiffInBST(node.left, values);
        values.add(node.val);
        doMinDiffInBST(node.right, values);
    }

}