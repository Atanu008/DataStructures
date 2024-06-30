package org.bgd.java.ds.tree.binarytree;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">...</a>
 * If root matches any of the nodes p and q, it is the LCA.
 * Recurse for left and right.
 * If left is null , right is the LCA
 * If right is null , left is the LCA
 * if both are present, root is the LCA
 */
public class LCABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
