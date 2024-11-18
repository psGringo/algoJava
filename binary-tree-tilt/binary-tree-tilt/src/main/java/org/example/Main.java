package org.example;


/**
 * https://leetcode.com/problems/binary-tree-tilt/description/
 */
public class Main {
    private int sum = 0;

    public static void main(String[] args) {

    }

    public int findTilt(TreeNode root) {
        doFindTilt(root);
        return sum;
    }

    public int doFindTilt(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = doFindTilt(node.left);
        int rightSum = doFindTilt(node.right);
        sum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}