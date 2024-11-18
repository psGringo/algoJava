package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 */
public class Main {
    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.right = new TreeNode(4);
       root.right.right = new TreeNode(5);

//       boolean res = isCousins(root, 5, 4);
    }

    /**
     * level, nodes with value x
     */
    private static HashMap<Integer, List<TreeNodeInfo>> mapX = new HashMap<>();

    /**
     * level, nodes with value y
     */
    private static HashMap<Integer, List<TreeNodeInfo>> mapY = new HashMap<>();

    private int x;

    private int y;


    public boolean isCousins(TreeNode root, int x, int y) {
        final boolean res = false;
        this.x = x;
        this.y = y;
        this.mapX = new HashMap<>();
        this.mapY = new HashMap<>();
        collect(root, null, 0);

        var xSet = mapX.entrySet();

        for (var entry : xSet) {
            List<TreeNodeInfo> nodesX = entry.getValue();
            int xDepth = entry.getKey();
            List<TreeNodeInfo> nodesY = mapY.get(xDepth); // yNodes on the same depth

            if (nodesX != null && nodesY != null) {
                for (int i = 0; i < nodesX.size(); i++) {
                    for (int j = 0; j < nodesY.size(); j++) {
                        boolean isDifferentParents = nodesX.get(i).parent() != nodesY.get(j).parent();
                        if (isDifferentParents) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private void collect(TreeNode node, TreeNode parent, int depth) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            List<TreeNodeInfo> list = mapX.getOrDefault(depth, new ArrayList<>());
            list.add(new TreeNodeInfo(node, parent));
            mapX.put(depth, list);
        }
        if (node.val == y) {
            List<TreeNodeInfo> list = mapY.getOrDefault(depth, new ArrayList<>());
            list.add(new TreeNodeInfo(node, parent));
            mapY.put(depth, list);
        }
        collect(node.left, node, depth + 1);
        collect(node.right, node, depth + 1);
    }

}

record TreeNodeInfo(TreeNode node, TreeNode parent) {}