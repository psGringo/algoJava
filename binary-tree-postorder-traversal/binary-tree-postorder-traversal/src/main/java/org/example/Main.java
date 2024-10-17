package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        return doPostorderTraversal(root, list);
    }

    private List<Integer> doPostorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return null;
        }
        doPostorderTraversal(node.left, list);
        doPostorderTraversal(node.right, list);
        list.add(node.val);
        return list;
    }

}