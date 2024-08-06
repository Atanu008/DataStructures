package org.bgd.java.ds.tree.binarytree.views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.bgd.java.ds.tree.binarytree.TreeNode;

/**
 * Problem Statement: Given a Binary Tree, return its Top View. The Top View of a Binary Tree is the set of nodes visible when we see the tree from the top.
 * <a href="https://takeuforward.org/data-structure/top-view-of-a-binary-tree/">...</a>
 *
 * Input:Binary Tree: 1 2 3 4 10 9 11 -1 5 -1 -1 -1 -1 -1 -1 -1 6
 *
 * Output: Top View: [4, 2, 1, 3, 11]
 */
public class TopViewBT {
    public List<Integer> TopView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        Map<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            if (!map.containsKey(top.col)) {
                map.put(top.col, top.node.val);
            }
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
