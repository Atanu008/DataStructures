package org.bgd.java.ds.tree.binarytree;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">...</a>
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfABT {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        diameterOfBinaryTree(root, max);
        return max[0];
    }

    public int diameterOfBinaryTree(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftD = diameterOfBinaryTree(root.left, max);
        int rightD = diameterOfBinaryTree(root.right, max);

        max[0] = Math.max(max[0], leftD + rightD);
        return 1 + Math.max(leftD, rightD);
    }
}
