package org.atanu.java.ds.binarysearchtree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
//LeetCode 235
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case: empty tree
        if(root == null){
            return null;
        }

        // if both x and y is smaller than root, LCA exists in left subtree
        if(root.val > Math.max(p.val, q.val)){
            return lowestCommonAncestor(root.left, p, q);
        }

        // if both x and y is greater than root, LCA exists in right subtree
        if(root.val < Math.min(p.val, q.val)){
            return lowestCommonAncestor(root.right, p, q);
        }

        // if one key is greater (or equal) than root and one key is smaller
        // (or equal) than root, then the current node is LCA
        return root;
    }
}
