package org.atanu.java.ds.binarysearchtree;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//LeetCode 108
public class ConvertSortedArrayToBinarySearchTree {

    //In Order Traversal of a BST is a sorted array
    //Middle Element of the array will always be the root
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return buildBST(nums, 0, nums.length -1);
    }

    private TreeNode buildBST(int[] nums, int low, int high){
        //Base Case. Search Space exhausted
        if(low > high){
            return null;
        }

        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, low, mid-1);
        root.right = buildBST(nums, mid+1, high);
        return root;
    }
}
