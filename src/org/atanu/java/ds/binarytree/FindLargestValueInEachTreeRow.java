package org.atanu.java.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
//LeetCode 515
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        //Base Case
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();
                //track the maximum value of each level.
                maxValue = Math.max(maxValue, current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(maxValue);
        }

        return result;
    }
}
