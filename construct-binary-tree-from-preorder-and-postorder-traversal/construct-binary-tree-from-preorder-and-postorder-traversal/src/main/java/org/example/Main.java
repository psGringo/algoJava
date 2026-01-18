package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }


    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> postOrderMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postOrderMap.put(postorder[i], i);
        }


        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, postOrderMap);
    }

    public TreeNode build(int[] pre, int preL, int preR,
                          int[] post, int postL, int postR,
                          HashMap<Integer, Integer> postOrderMap) {
        if (preL > preR) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);

        if (preL == preR) {
            return root;
        }


        int leftRootVal = pre[preL + 1];
        int k = postOrderMap.get(leftRootVal);
        int leftSize = k - postL + 1;

        root.left = build(pre, preL + 1, preL + leftSize, post, postL, k, postOrderMap);
        root.right = build(pre, preL + leftSize + 1, preR, post, k + 1, postR - 1, postOrderMap);

        return root;
    }
}