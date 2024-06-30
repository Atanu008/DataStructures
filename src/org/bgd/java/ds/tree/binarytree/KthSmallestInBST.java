package org.bgd.java.ds.tree.binarytree;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/editorial/">...</a>
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestInBST {

    /**
     * Easiest solution would be to do an inorder traversal while storing the values in an array.
     * This will automatically store the result in a sorted way given that the input tree is a BST.
     * Finally return the kth value
     *
     * However, a space optimised solution is to keep track of only the kth value while performing inorder
     * and then return preemptively.
     *
     */

    Integer counter, k, val;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.counter = 0;
        this.val = -1;
        kthSmallestInOrder(root);
        return val;
    }

    private void kthSmallestInOrder(TreeNode root) {
        if (root == null || counter >= k) {
            return;
        }
        kthSmallestInOrder(root.left);
        this.counter++;

        if (counter == k) {
            this.val = root.val;
            return;
        }
        kthSmallestInOrder(root.right);
    }
}
