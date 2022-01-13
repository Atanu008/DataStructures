package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/count-complete-tree-nodes/
//LeetCode 222
//Video : https://www.youtube.com/watch?v=CvrPf1-flAA
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }

        ////Passing Root because we need to Number of nodes ias height
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            return  (int)Math.pow(2, leftHeight) -1;
            //return (1 << leftHeight) -1; This should be fast

        }

        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        int count = 0;
        while(root != null){
            root = root.left;
            count++;
        }

        return count;
    }

    private int getRightHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        int count = 0;
        while(root != null){
            root = root.right;
            count++;
        }

        return count;
    }
}
