package org.example;


/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int maxHeight = doGetMaxHeight(root) -1;
        System.out.println(maxHeight);
        return diameter - 1;
    }

    private int doGetMaxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = doGetMaxHeight(node.left);
        int right = doGetMaxHeight(node.right);

        int localDiameter = left + right + 1;
        diameter = Math.max(localDiameter, diameter);

        return Math.max(left, right) + 1;
    }



    // THIS APPROACH GIVES ONLY HEIGHT, NOT DIAMETER

//    public static int diameterOfBinaryTree(TreeNode root) {
//        int leftMaxDepth = doDiameterOfBinaryTree(root.left, 1);
//
//        int rightMaxDepth = doDiameterOfBinaryTree(root.right, 1);
//        return leftMaxDepth + rightMaxDepth;
//    }
//
//    private static int doDiameterOfBinaryTree(TreeNode node, int prevLength) {
//        if (node == null) {
//            return 0;
//        }
//        System.out.println(node.val);
//        int leftMax = Math.max(prevLength, doDiameterOfBinaryTree(node.left, prevLength + 1));
//        int rightMax = Math.max(prevLength, doDiameterOfBinaryTree(node.right, prevLength + 1));
//
//        System.out.println("node.val = %d left = %d, right =%d".formatted(node.val, leftMax, rightMax));
//
//        return Math.max(leftMax, rightMax);
//    }
}