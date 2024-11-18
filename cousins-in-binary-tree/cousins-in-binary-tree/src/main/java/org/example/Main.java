package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    private int xTarget;
    private int yTarget;


    private List<TreeNodeDepth> xResult = new ArrayList<>();
    private List<TreeNodeDepth> yResult = new ArrayList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        xTarget = x;
        yTarget = y;

        collectNodes(root,null, 0);

        var xNodesArr = xResult.toArray(new TreeNodeDepth[xResult.size()]);
        var yNodesArr = yResult.toArray(new TreeNodeDepth[yResult.size()]);

        for (int i = 0; i < xNodesArr.length; i++) {
            for (int j = 0; j < yNodesArr.length; j++) {
                if (xNodesArr[i].depth() == yNodesArr[j].depth() && xNodesArr[i].parent() != yNodesArr[j].parent()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void collectNodes(TreeNode node, TreeNode parent, int depth) {
        if (node == null) {
            return;
        }

        if (node.val == xTarget) {
            xResult.add(new TreeNodeDepth(node, parent, depth));
        }
        if (node.val == yTarget) {
            yResult.add(new TreeNodeDepth(node, parent, depth));
        }

        collectNodes(node.left, node, depth + 1);
        collectNodes(node.right, node, depth + 1);
    }
}

record TreeNodeDepth(TreeNode node, TreeNode parent, int depth) {
}