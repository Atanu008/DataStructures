package org.bgd.java.ds.tree.binarytree.views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bgd.java.ds.tree.binarytree.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/">...</a>
 *
 *Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 */

public class ZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        List<Integer> levelList = new LinkedList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.pollFirst();
            if (curr != null) {
                if (leftToRight) {
                    levelList.addLast(curr.val);
                } else {
                    levelList.addFirst(curr.val);
                }
                if (curr.left != null) {
                    queue.addLast(curr.left);
                }
                if (curr.right != null) {
                    queue.addLast(curr.right);
                }
            } else {
                answer.add(levelList);
                levelList = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
                leftToRight = !leftToRight;
            }
        }
        return answer;
    }
}
