package org.example;


public class Main {
    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Find the max element index in the given range
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Create the root node
        TreeNode node = new TreeNode(nums[maxIndex]);

        // Recursively construct left and right subtrees
        node.left = buildTree(nums, left, maxIndex - 1);
        node.right = buildTree(nums, maxIndex + 1, right);

        return node;
    }

}