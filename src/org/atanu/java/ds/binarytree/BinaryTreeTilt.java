package org.atanu.java.ds.binarytree;

//https://leetcode.com/problems/binary-tree-tilt/
//LeetCode 563

//Easy . but Leetcode wording is misleading
//https://www.youtube.com/watch?v=A9gY4H0O-U4&t=165s
public class BinaryTreeTilt {

    int result = 0;

    public int findTilt(TreeNode root){

        portOrder(root);
        return result;
    }
    public int portOrder(TreeNode root) {

        if(root == null){
            return 0;
        }
        int left = portOrder(root.left);
        int right = portOrder(root.right);

        result += Math.abs(left - right);

        return root.val + left + right;
    }
}
