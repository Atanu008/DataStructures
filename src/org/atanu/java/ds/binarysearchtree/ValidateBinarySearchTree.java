package org.atanu.java.ds.binarysearchtree;

//https://leetcode.com/problems/validate-binary-search-tree/
//LeetCode 98
//Can Refer Video : https://www.youtube.com/watch?v=s6ATEkipzow&list=PLot-Xpze53lfOdF3KwpMSFEyfE77zIwiP&index=26
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        return isBST(root, null, null); //Instead of passingInteger.MIN_VALUE and  Integer.MAX_VALUE , pass null
    }

    //isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE), but it failed when a tree node is either Integer.MIN_VALUE or Integer.MAX_VALUE.
    public boolean isBST(TreeNode root, Integer low, Integer high){

        if(root == null){
            return true;
        }

        // If the node is not in range then return false
        if((low != null && root.val <=  low) || (high != null && root.val >= high)){
            return false;
        }

        //To Go Left make the high boundary as the current nodes value as the left node can not be higher than this
        //To Go Right make the low boundary as the current nodes value as the right node can not be lower than this
        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }

}
