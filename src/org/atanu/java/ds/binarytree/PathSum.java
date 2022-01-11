package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/path-sum/
//LeetCode 112
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        targetSum -= root.val;
        //Reached a leaf node and sum became zero i.e path exists
        if(root.left == null && root.right == null && targetSum == 0){
            return true;
        }
        //Check either of the path. return true if any path return
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
