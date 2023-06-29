package org.atanu.java.ds.binarytree;

// https://leetcode.com/problems/invert-binary-tree/description/
// Leetcode 226

public class InvertBinaryTree {

    // we use Post Order Treversal in which first we go in Left subtree and then in Right subtree
    // then we return back to Parent node.
    // When we come back to the parent node we swap it's Left subtree and Right subtree.

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);
        swap(root);

        return root;
    }

    private void swap(TreeNode root){

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
