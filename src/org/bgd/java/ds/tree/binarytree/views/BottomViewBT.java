package org.bgd.java.ds.tree.binarytree.views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.bgd.java.ds.tree.binarytree.TreeNode;

/**
 * <a href="https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1">...</a>
 *
 * Given a binary tree, print the bottom view from left to right.
 * A node is included in bottom view if it can be seen when we look at the tree from bottom.
 *
 * Input:
 *          10
 *        /    \
 *       20    30
 *      /  \
 *     40   60
 * Output: 40 20 60 30
 */
public class BottomViewBT {
    public List<Integer> bottomView(TreeNode root) {

        List<Integer> answer = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair top = queue.poll();

            // Put the last value in each column
            map.put(top.col, top.node.val);
            if (top.node.left != null) {
                queue.offer(new Pair(top.node.left, top.col - 1));
            }
            if (top.node.right != null) {
                queue.offer(new Pair(top.node.right, top.col + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer.add(entry.getValue());
        }

        return answer;

    }

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
