package org.example;


/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class Main {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return doSortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode doSortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = doSortedArrayToBST(nums, lo, mid - 1);
        node.right = doSortedArrayToBST(nums, mid + 1, hi);
        return node;
    }

}