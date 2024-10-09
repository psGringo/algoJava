package org.example;


public class Main {
    public static void main(String[] args) {

    }

    private void traversePreorder(TreeNode node){
        if (node==null) {
            return;
        }
        System.out.println(node.val);
        traversePreorder(node.left);
        traversePreorder(node.right);
    }

    /**
     * gives in sorted order
     * 
     *
     * @param node
     */
    private void traverseInorder(TreeNode node){
        if (node==null) {
            return;
        }

        traversePreorder(node.left);
        System.out.println(node.val);
        traversePreorder(node.right);
    }


    private void traversePostorder(TreeNode node){
        if (node==null) {
            return;
        }

        traversePreorder(node.left);
        traversePreorder(node.right);
        System.out.println(node.val);
    }
}