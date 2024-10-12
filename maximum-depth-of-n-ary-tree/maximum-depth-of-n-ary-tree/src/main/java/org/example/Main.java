package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        return doMaxDepth(root);
    }

    private int doMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int depth = 1;
        int maxDepth = depth;
        List<Integer> depthes = new ArrayList<>();
        for (int i = 0; i < node.children.size(); i++) {
            int currDepth = depth + doMaxDepth(node.children.get(i));
            depthes.add(currDepth);
            maxDepth = Math.max(maxDepth, currDepth);
        }
        return maxDepth;
    }

}