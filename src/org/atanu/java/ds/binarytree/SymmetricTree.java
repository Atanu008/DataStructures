package org.atanu.java.ds.binarytree;

// https://leetcode.com/problems/symmetric-tree/description/
// Leetcode 101

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        // Base Case . If the tree is null its always Symmetric
        if(root == null){
            return true;
        }
        // Check the Mirror of Left and Right Node
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode a, TreeNode b){
        // Base Case A
        // If both of them are null then they are Symmetric
        if(a == null && b == null){
            return true;
        }
        // Base Case B
        // If Either of them is NOT null Then its not Symmetric
        if(a == null || b == null){
            return false;
        }
        // Recursively check the
        // 1.Check Values
        // 2.left and Right
        // 3.Right and Left
        return (a.val == b.val) && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
