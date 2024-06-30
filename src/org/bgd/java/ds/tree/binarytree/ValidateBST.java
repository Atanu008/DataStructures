package org.bgd.java.ds.tree.binarytree;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">...</a>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {
    /**
     * Recursive inorder to solve this problem while keeping track of the previous element.
     * @param root
     * @return
     */

    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!inorder(root.left)) {
            return false;
        }

        if (prev != null && root.val <= prev) {
            return false;
        }

        prev = root.val;
        return inorder(root.right);
    }

    /**
     * Range Based Query to validate BST.
     * Start off with null ranges and keep updating upper and lower ranges recursively
     * @param root
     * @return
     */

    public boolean isValidBSTII(TreeNode root) {
        return validateRec(root, null, null);
    }

    private boolean validateRec(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        if ((lower != null && root.val <= lower) || (upper != null && root.val >= upper)) {
            return false;
        }

        return validateRec(root.left, lower, root.val) && validateRec(root.right, root.val, upper);
    }
}
