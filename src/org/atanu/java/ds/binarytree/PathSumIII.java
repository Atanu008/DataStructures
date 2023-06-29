package org.atanu.java.ds.binarytree;

import java.util.HashMap;

//https://leetcode.com/problems/path-sum-iii/
//LeetCode 437
public class PathSumIII {

    //Brute Force
    int totalCount = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        findPathSum(root,0,targetSum); //Start from Root Node

        pathSum(root.left,targetSum); //Recursively check from every Node and check sum
        pathSum(root.right,targetSum);//Recursively check from every Node and check sum

        return totalCount;
    }

    private void findPathSum(TreeNode root, int currentSum, int targetSum){
        if(root == null){
            return;
        }

        currentSum += root.val;
        if(currentSum == targetSum){
            totalCount++;
        }

        findPathSum(root.left, currentSum, targetSum);
        findPathSum(root.right, currentSum, targetSum);
    }

    //++++++++
    // Prefix Sum Approach
    // Find a number of continuous subarrays that sum to target.
    // This time in Binary Tree
    // Video : https://www.youtube.com/watch?v=yyZA4v0x16w

    int count = 0;
    HashMap<Integer, Integer> prefixSum = new HashMap<>();
    int k;
    public int pathSumV2(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        k = targetSum;
        prefixSum.put(0,1); //This is imp . It checks if sum starts from starting of node. like root
        dfs(root, 0);

        return totalCount;
    }

    private void dfs(TreeNode root, int currentSum){
        if(root == null){
            return;
        }

        currentSum += root.val;

        // number of times the curr_sum − k has occured already,
        // determines the number of times a path with sum k
        // has occured upto the current node
        count += prefixSum.getOrDefault(currentSum - k, 0);

        // add the current sum into hashmap
        // to use it during the child nodes processing
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        dfs(root.left, currentSum);
        dfs(root.right, currentSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
    }
}
