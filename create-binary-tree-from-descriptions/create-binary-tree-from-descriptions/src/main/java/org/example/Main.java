package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        createBinaryTree();
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, int[]> children = new HashMap<>();
        for (int[] description : descriptions) {
            children.put(description[1], description);
        }

        HashMap<Integer, TreeNode> nodes = new HashMap<>();

        TreeNode root = null;

        for (int[] description : descriptions) {
            int childValue = description[1];
            int parentValue = description[0];
            int isLeft = description[2];

            TreeNode child = nodes.getOrDefault(childValue, new TreeNode(childValue));
            nodes.put(childValue, child);

            TreeNode parent = nodes.getOrDefault(parentValue, new TreeNode(parentValue));
            nodes.put(parentValue, parent);

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // ✅ Determine the true root: node never used as a child
        for (int val : nodes.keySet()) {
            if (!children.containsKey(val)) {
                return nodes.get(val);
            }
        }

        return null; // should never happen
    }
}

record NodeInfo(int parent, int child, boolean isLeft) {
}