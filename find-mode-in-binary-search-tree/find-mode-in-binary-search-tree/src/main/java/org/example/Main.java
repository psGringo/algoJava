package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        findMode(root);
    }

    private static int mode = 0;

    public static int[] findMode(TreeNode root) {
        int[] result = new int[]{};
        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        doFindMode(root, map);

        List<Integer> list = new ArrayList<>();
        map.entrySet().forEach((entry) -> {
            if (entry.getValue() == mode) {
                list.add(entry.getKey());
            }
        });

        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void doFindMode(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        int localMode = map.getOrDefault(node.val, 0) + 1;
        map.put(node.val, localMode);
        mode = Math.max(mode, localMode);
        doFindMode(node.left, map);
        doFindMode(node.right, map);
    }

}