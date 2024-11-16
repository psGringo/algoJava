package org.example;


public class Main {
    public static void main(String[] args) {

    }

    public boolean checkTree(TreeNode root) {
       if (root.val == root.left.val + root.right.val) {
           return true;
       }

       return false;
    }

}