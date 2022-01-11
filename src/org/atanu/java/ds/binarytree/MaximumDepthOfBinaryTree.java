package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
//LeetCode 104
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
