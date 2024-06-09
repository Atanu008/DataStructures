package org.bgd.java.ds.tree.binarytree;

/**
 * <a href="https://leetcode.com/problems/same-tree/description/">...</a>
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null) {
            return false;
        }
        if(q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

