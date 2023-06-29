package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/same-tree/
//LeetCode 100
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case A
        // If both of them are null then they are same
        if(p == null && q == null){
            return true;
        }
        // Base Case B
        // If Either of them is NOT null Then its not same
        if(p == null || q == null){
            return false;
        }
        // Recursively check the
        // 1.Check Values
        // 2.Left and Left
        // 3.Right and Right
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Same . but verbose
    public boolean isSameTree_v2(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree_v2(p.right, q.right) &&
                isSameTree_v2(p.left, q.left);
    }
}
