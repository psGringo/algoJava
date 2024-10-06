package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

    }


    private List<Integer> getAllElementsTwoLists(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, first);
        }

        List<Integer> second = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, second);
        }

        show(first);
        System.out.println();
        show(second);
        System.out.println();

        Collections.sort(first);
        Collections.sort(second);

        List<Integer> result = new ArrayList<>();
        int i = 0; int j = 0;
        while (i < first.size() && j < second.size()) {
            if (first.get(i) < second.get(j)) {
                result.add(first.get(i));
                i++;
            } else {
                result.add(second.get(j));
                j++;
            }
        }


        while (i < first.size()) {
            result.add(first.get(i++));
        }
        while (j < second.size()) {
            result.add(second.get(j++));
        }

        return result;
    }


    private List<Integer> getAllElementsOneList(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, result);
        }
        if (root2 != null) {
            dfs(root2, result);
        }

        Collections.sort(result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

    private void dfsSorted(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        dfsSorted(node.left, list);
        list.add(node.val);
        dfsSorted(node.right, list);
    }


    private void show(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("%s ".formatted(list.get(i)));
        }
    }


}