package org.bgd.java.ds.tree.binarytree;

/**
 * <a href="https://leetcode.com/problems/inorder-successor-in-bst/editorial/">...</a>
 * Given the root of a binary search tree and a node p in it,
 * return the in-order successor of that node in the BST.
 * If the given node has no in-order successor in the tree, return null.
 * The successor of a node p is the node with the smallest key greater than p.val.
 * Input: root = [2,1,3], p = 1
 * Output: 2
 */
public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;

        while(root != null) {
            if(p.val >= root.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
}
