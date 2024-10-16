package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        return doPreorderTraversal(root, list);
    }

    private List<Integer> doPreorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return null;
        }
        list.add(node.val);
        doPreorderTraversal(node.left, list);
        doPreorderTraversal(node.right, list);
        return list;
    }

}