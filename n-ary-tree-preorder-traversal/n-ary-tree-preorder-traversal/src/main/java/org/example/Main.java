package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
      List<Integer> result = new ArrayList<>();
      doPreorder(root, result);
      return result;
    }

    public void doPreorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        for (Node child : node.children) {
            doPreorder(child, list);
        }
    }

}