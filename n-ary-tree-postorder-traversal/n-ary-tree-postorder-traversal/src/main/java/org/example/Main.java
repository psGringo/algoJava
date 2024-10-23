package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        postorder(root, list);
        return list;
    }

    private void postorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            postorder(child, list);
        }
        list.add(node.val);
    }

}