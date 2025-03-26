package org.example;


public class Main {
    public static void main(String[] args) {

    }

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return doBstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode doBstFromPreorder(int[] preorder, int min, int max) {
        if (index >= preorder.length) {
            return null;
        }
        int value = preorder[index];
        if (value < min || value > max) {
            return null;
        }
        TreeNode node = new TreeNode(value);
        index++;

        node.left = doBstFromPreorder(preorder, min, value);
        node.right = doBstFromPreorder(preorder, value, max);

        return node;
    }
}