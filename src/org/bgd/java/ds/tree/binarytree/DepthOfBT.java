package org.bgd.java.ds.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">...</a>
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 */

public class DepthOfBT {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Iterative solution involves doing a DFS with a Stack
     */

    public int maxDepthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        int depth = 0;
        while (!stack.isEmpty()) {
            int s = stack.size();
            depth++;
            for (int i = 0; i < s; i++) {
                TreeNode top = stack.poll();
                if (top.left != null) {
                    stack.offer(top.left);
                }

                if (top.right != null) {
                    stack.offer(top.right);
                }
            }
        }
        return depth;
    }
}
