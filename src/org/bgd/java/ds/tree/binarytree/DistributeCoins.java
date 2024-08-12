package org.bgd.java.ds.tree.binarytree;

/**
 * <a href="https://leetcode.com/problems/distribute-coins-in-binary-tree/description/">...</a>
 *
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins.
 * There are n coins in total throughout the whole tree.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.
 * A move may be from parent to child, or from child to parent.
 *
 * Return the minimum number of moves required to make every node have exactly one coin.
 *
 *
 */
public class DistributeCoins {
    int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        distribute(root);
        return moves;
    }

    private int distribute(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = distribute(root.left);
        int right = distribute(root.right);

        moves += Math.abs(left) + Math.abs(right);

        return root.val - 1 + left + right;
    }
}

