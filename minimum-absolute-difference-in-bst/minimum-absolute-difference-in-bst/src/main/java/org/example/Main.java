package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 */
public class Main {

    private static Integer previous = null;    // Integer used to store null so we used
    private static int dif = Integer.MAX_VALUE;

    public static void main(String[] args) {
//         TreeNode root = new TreeNode(543);
//         root.left = new TreeNode(384);
//         root.left.right = new TreeNode(445);
//         root.right = new TreeNode(652);
//         root.right.right = new TreeNode(699);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        int res = getMinimumDifference(root);
    }

    /**
     * This problem has 2 decisions
     *  1. brute force: collect all values and get diff for all of them
     *  2. optimal: in bst values a < b < c,
     *
     *  so |a-b| = dif1, |c-b| = dif1
     *  |a-c| = dif1 + dif2 > dif1 || dif2, so we can traverse inorder and compare just linked neighbours
     */
    public static int getMinimumDifference(TreeNode root) {
       if (root == null) {
           return 0;
       }

        doGetMinimumDifferenceOptimal(root);
       return dif;
    }

    private static int getMinimumDifferenceBruteForce(TreeNode root) {
        if (root == null) {
            return 0;
        }

       List<Integer> list = new ArrayList<>();
        doGetMinimumDifferenceCollectValues(root, list);
       Integer[] values = list.toArray(new Integer[list.size()]);
       int min = Integer.MAX_VALUE;
       for (int i = 0; i < values.length; i++) {
           for (int j = i + 1; j < values.length; j++) {
               min = Math.min(min, Math.abs(values[i] - values[j]));
           }
       }
       return min;
    }



    private static void doGetMinimumDifferenceCollectValues(TreeNode node, List<Integer> sortedValues) {
        if (node == null) {
            return;
        }

        doGetMinimumDifferenceCollectValues(node.left, sortedValues);
        sortedValues.add(node.val);
        doGetMinimumDifferenceCollectValues(node.right, sortedValues);
    }

    private static void doGetMinimumDifferenceOptimal(TreeNode node) {
        if(node == null)    return;

        doGetMinimumDifferenceOptimal(node.left);

        // Calculate the difference with the previous node
        if(previous != null) {
            int currDif = node.val - previous; // No need for Math.abs, as root.val >= previous in BST inorder
            if(dif > currDif) dif = currDif;
        }

        // Update the previous value to current node's value
        previous = node.val;

        doGetMinimumDifferenceOptimal(node.right);
    }


}