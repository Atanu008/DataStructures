package org.bgd.java.ds.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-distance-in-a-binary-tree/?envType=weekly-question&envId=2024-07-15">...</a>
 *
 * Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.
 *
 * The distance between two nodes is the number of edges on the path from one to the other.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
 * Output: 3
 * Explanation: There are 3 edges between 5 and 0: 5-3-1-0.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
 * Output: 2
 * Explanation: There are 2 edges between 5 and 7: 5-2-7.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
 * Output: 0
 * Explanation: The distance between a node and itself is 0.
 */
public class DistanceInBT {

    /**
     * Algorithm :
     * 1. Find LCA of p and q
     * 2. Count depth from LCA to p and q separately
     * 3. Sum of distance
     */
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = lca(root, p, q);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(lca);
        int distance = 0;

        boolean foundp = false, foundq = false;

        int depth = 0;

        while (!queue.isEmpty() && (!foundq || !foundp)) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top.val == p) {
                    distance += depth;
                    foundp = true;
                }
                if (top.val == q) {
                    distance += depth;
                    foundq = true;
                }

                if (top.left != null) {
                    queue.offer(top.left);
                }

                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            depth += 1;
        }
        return distance;
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }

        if (root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
