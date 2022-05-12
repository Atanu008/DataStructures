package org.atanu.java.ds.binarysearchtree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
//LeetCode 653
public class TwoSumIVInputIsABST {

    //Its uses the fact that its BST.
    //get Sorted List using In Order Traversal . Use Two Pointer to determine
    public boolean findTarget(TreeNode root, int k) {

        List<Integer> sortedNums = new ArrayList<>();
        //InOrder will give sorted list
        inOrder(root, sortedNums);

        int low = 0;
        int high = sortedNums.size() -1;

        while(low < high){

            int expectedSum = sortedNums.get(low) + sortedNums.get(high);

            if(expectedSum == k){
                return true;
            }

            if(expectedSum < k) low++;
            else if(expectedSum > k) high--;
        }

        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums){

        if(root == null){
            return;
        }

        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);

    }


    //This solution would work for any any Binary Tree
    public boolean findTargetV2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return isPairAvailable(root, set, k);
    }

    private boolean isPairAvailable(TreeNode root, Set<Integer> set, int k){

        if(root == null){
            return false;
        }

        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return isPairAvailable(root.left, set, k) || isPairAvailable(root.right, set, k);
    }
}
