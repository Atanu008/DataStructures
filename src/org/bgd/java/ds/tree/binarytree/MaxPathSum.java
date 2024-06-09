package org.bgd.java.ds.tree.binarytree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * 124. Binary Tree Maximum Path Sum
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 *
 *
 * Explanation Video
 * <a href="https://www.youtube.com/watch?v=WszrfSwMz58">...</a>
 */
public class MaxPathSum {

    /**
     * This uses an algorithm similar to max depth to evaluate the max Path sums of left, right and itself.
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumRec(root, max);
        return max[0];
    }

    public int maxPathSumRec(TreeNode root, int[] max) {

        if (root == null) {
            return 0;
        }

        /**
         * Negative sums are reset to 0.
         */
        int leftSum = Math.max(0, maxPathSumRec(root.left, max));
        int rightSum = Math.max(0, maxPathSumRec(root.right, max));

        max[0] = Math.max(max[0], root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}
