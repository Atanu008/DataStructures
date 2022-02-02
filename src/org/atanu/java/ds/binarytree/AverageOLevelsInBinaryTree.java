package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/
//LeetCode 637
public class AverageOLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            double levelSum = 0;
            for(int i = 0; i < size; i++) {

                TreeNode current = queue.poll();
                levelSum += current.val;

                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }

            double average = levelSum / size;
            result.add(average);
        }

        return result;
    }
}
