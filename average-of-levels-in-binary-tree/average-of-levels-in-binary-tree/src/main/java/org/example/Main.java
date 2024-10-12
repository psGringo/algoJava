package org.example;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();

        queue.add(root);
        queue.add(null);

        while (queue.peek() != null) {
            double sum = 0;
            int nodes = 0;

            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                sum += node.val;
                nodes++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            queue.add(queue.poll());
            result.add(sum / nodes);
        }

        return result;
    }

}