package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/same-tree/
//LeetCode 100
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
