package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/cousins-in-binary-tree/
//LeetCode 993
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        return getLevel(root, x, 1) == getLevel(root, y, 1) && !isSiblings(root, x, y);
    }

    private int getLevel(TreeNode root, int nodeVal, int level) {

        if (root == null) {
            return 0;
        }

        if (root.val == nodeVal) {
            return level;
        }

        // Recur for left Sub Tree
        int increasedLevel = getLevel(root.left, nodeVal, level + 1);

        if (increasedLevel != 0) {
            return increasedLevel;
        }

        // Recurr right sub tree if not found in left subtree
        return getLevel(root.right, nodeVal, level + 1);
    }

    public  boolean isSiblings(TreeNode root, int a, int b) {


        if (root == null) {
            return false;
        }

        if(root.left != null && root.right != null && root.left.val == a && root.right.val == b){
            return true;
        }
        if(root.left != null && root.right != null && root.left.val == b && root.right.val == a){
            return true;
        }

        return isSiblings(root.left, a, b) || isSiblings(root.right, a, b);

    }
}
