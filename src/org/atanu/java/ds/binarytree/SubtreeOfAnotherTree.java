package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/subtree-of-another-tree/
//LeetCode 572
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null){
            return true;
        }

        //here subTree is not equeal to null and Maintree is null.
        if(root == null){
            return false;
        }

        //If both the trees are same
        if(isIdentical(root, subRoot)){
            return true;
        }

        //If either of Left and Right part of the main tree has sub tree return True
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode a, TreeNode b){

        if(a == null && b == null){
            return true;
        }

        if(a == null || b == null){
            return false;
        }

        return a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}
